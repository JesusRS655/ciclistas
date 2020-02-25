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
import application.model.PortModel;
import application.service.CyclistService;
import application.service.PortService;
import application.service.StageService;

@Controller
@RequestMapping("/")
public class PortController {

	@Autowired
	@Qualifier("portServiceImpl")
	private PortService portService;

	@Autowired
	@Qualifier("cyclistServiceImpl")
	private CyclistService cyclistService;

	@Autowired
	@Qualifier("stageServiceImpl")
	private StageService stageService;

	private static final Log LOG = LogFactory.getLog(PortController.class);

	@GetMapping("/port")
	public ModelAndView port() {
		LOG.info("Returning view: " + ViewConstants.PORT_VIEW);
		ModelAndView mav = new ModelAndView(ViewConstants.PORT_VIEW);
		mav.addObject("ports", portService.listPorts());
		return mav;
	}

	@GetMapping("/portForm")
	public String portForm(Model model, @RequestParam(name = "portname") String portname) {
		LOG.info("Returning view: " + ViewConstants.PORT_FORM_VIEW);
		PortModel portModel = new PortModel();
		List<PortModel> pModelList = portService.listPorts();
		if (!portname.isEmpty())
			for (PortModel pm : pModelList)
				if (portname.equals(pm.getPortname()))
					portModel = pm;
		model.addAttribute("port", portModel);
		model.addAttribute("cyclists", cyclistService.listCyclists());
		model.addAttribute("stages", stageService.listStages());
		return ViewConstants.PORT_FORM_VIEW;
	}

	@PostMapping("/addPort")
	public ModelAndView addPort(Model model, @ModelAttribute("port") PortModel portModel) {
		LOG.info("Adding port");
		ModelAndView mav = new ModelAndView();

		portService.addPort(portModel);

		mav.setViewName("redirect:/port");
		return mav;
	}

	@PostMapping("/removePort")
	public String removePort(@RequestParam(name = "portname") String portname) {
		LOG.info("Removing port");
		portService.removePort(portname);
		return "redirect:/port";
	}

}
