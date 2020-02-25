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
import application.model.MaillotModel;
import application.model.StageModel;
import application.service.MaillotService;

@Controller
@RequestMapping("/")
public class MaillotController {

	@Autowired
	@Qualifier("maillotServiceImpl")
	private MaillotService maillotService;

	private static final Log LOG = LogFactory.getLog(MaillotController.class);

	@GetMapping("/maillot")
	public ModelAndView maillot() {
		LOG.info("Returning view: " + ViewConstants.MAILLOT_VIEW);
		ModelAndView mav = new ModelAndView(ViewConstants.MAILLOT_VIEW);
		mav.addObject("maillots", maillotService.listMaillots());
		return mav;
	}

	@GetMapping("/maillotForm")
	public String maillotForm(Model model, @RequestParam(name = "code") String code) {
		LOG.info("Returning view: " + ViewConstants.MAILLOT_FORM_VIEW);
		MaillotModel maillotModel = new MaillotModel();
		List<MaillotModel> mModelList = maillotService.listMaillots();
		if (!code.isEmpty())
			for (MaillotModel mm : mModelList) {
				if (code.equals(mm.getCode())) {
					maillotModel = mm;
				}
			}
		model.addAttribute("maillot", maillotModel);
		return ViewConstants.MAILLOT_FORM_VIEW;
	}

	@PostMapping("/addMaillot")
	public ModelAndView addMaillot(Model model, @ModelAttribute("maillot") MaillotModel maillotModel) {
		LOG.info("Adding maillot");
		ModelAndView mav = new ModelAndView();

		maillotService.addMaillot(maillotModel);

		mav.setViewName("redirect:/maillot");
		return mav;
	}

	@PostMapping("/deleteMaillot")
	public String deleteMaillot(@RequestParam(name = "code") String code) {
		LOG.info("Removing maillot");
		maillotService.removeMaillot(code);
		return "redirect:/maillot";
	}

}