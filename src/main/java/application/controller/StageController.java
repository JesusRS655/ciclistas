package application.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import application.constants.ViewConstants;
import application.model.StageModel;
import application.service.CyclistService;
import application.service.StageService;

@Controller
@RequestMapping("/")
public class StageController {

	@Autowired
	@Qualifier("stageServiceImpl")
	private StageService stageService;

	@Autowired
	@Qualifier("cyclistServiceImpl")
	private CyclistService cyclistService;

	private static final Log LOG = LogFactory.getLog(StageController.class);

	@GetMapping("/stage")
	public ModelAndView stage() {
		LOG.info("Returning view: " + ViewConstants.STAGE_VIEW);
		ModelAndView mav = new ModelAndView(ViewConstants.STAGE_VIEW);
		mav.addObject("stages", stageService.listStages());
		return mav;
	}

	@GetMapping("/stageForm")
	public String stageForm(Model model, @RequestParam(name = "stagenumber") int stagenumber) {
		LOG.info("Returning view: " + ViewConstants.STAGE_FORM_VIEW);
		StageModel stageModel = new StageModel();
		List<StageModel> sModelList = stageService.listStages();
		if (stagenumber != -1)
			for (StageModel sm : sModelList)
				if (stagenumber == sm.getStagenumber())
					stageModel = sm;
		model.addAttribute("stage", stageModel);
		model.addAttribute("cyclists", cyclistService.listCyclists());
		return ViewConstants.STAGE_FORM_VIEW;
	}

	@PostMapping("/addStage")
	public ModelAndView addStage(Model model, @ModelAttribute("stage") StageModel stageModel) {
		LOG.info("Adding stage");
		ModelAndView mav = new ModelAndView();
		stageService.addStage(stageModel);

		mav.setViewName("redirect:/stage");
		return mav;
	}

	@PostMapping("/deleteStage")
	public String deleteStage(@RequestParam(name = "stagenumber") int stagenumber) {
		LOG.info("Removing maillot");
		stageService.removeStage(stagenumber);
		return "redirect:/stage";
	}

}
