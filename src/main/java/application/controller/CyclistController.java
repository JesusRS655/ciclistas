package application.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import application.constants.ViewConstants;
import application.model.CyclistModel;
import application.model.TeamModel;
import application.service.CarryService;
import application.service.CyclistService;
import application.service.TeamService;

@Controller
@RequestMapping("/")
public class CyclistController {

	@Autowired
	@Qualifier("cyclistServiceImpl")
	private CyclistService cyclistService;

	@Autowired
	@Qualifier("teamServiceImpl")
	private TeamService teamService;

	@Autowired
	@Qualifier("carryServiceImpl")
	private CarryService carryService;

	private static final Log LOG = LogFactory.getLog(CyclistController.class);

	@GetMapping("/cyclist")
	public ModelAndView cyclist() {
		LOG.info("Returning view: " + ViewConstants.CYCLIST_VIEW);
		ModelAndView mav = new ModelAndView(ViewConstants.CYCLIST_VIEW);
		mav.addObject("cyclists", cyclistService.listCyclists());
		return mav;
	}

	@GetMapping("/cyclistForm")
	public String cyclistForm(Model model, @RequestParam(name = "id") int id) {
		LOG.info("Returning view: " + ViewConstants.CYCLIST_FORM_VIEW);
		CyclistModel cyclistModel = new CyclistModel();
		List<CyclistModel> cModelList = cyclistService.listCyclists();
		if (id != -1)
			for (CyclistModel cm : cModelList)
				if (id == cm.getId())
					cyclistModel = cm;
		model.addAttribute("cyclist", cyclistModel);
		model.addAttribute("teams", teamService.listTeams());
		return ViewConstants.CYCLIST_FORM_VIEW;
	}

	@PostMapping("/addCyclist")
	public ModelAndView addCyclist(Model model, @RequestParam(name = "teamname") String teamname,
			@RequestParam(name = "cyclistPic") MultipartFile picture,
			@ModelAttribute("cyclist") CyclistModel cyclistModel) {

		LOG.info("Adding cyclist");
		LOG.info(teamname);
		ModelAndView mav = new ModelAndView();
		TeamModel teamModel = new TeamModel();
		List<TeamModel> tModelList = teamService.listTeams();

		for (TeamModel tm : tModelList)
			if (teamname.equals(tm.getTeamname()))
				teamModel = tm;

		if (!picture.isEmpty()) {
			Path dir = Paths.get(".\\src\\main\\resources\\static\\img");
			String rootPath = dir.toFile().getAbsolutePath();
			try {
				byte[] bytes = picture.getBytes();
				Path route = Paths.get(rootPath + "\\" + cyclistModel.getName() + ".png");
				Files.write(route, bytes);
				cyclistModel.setPicture("/img/" + cyclistModel.getName() + ".png");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
			cyclistModel.setPicture("/img/defaultC.png");
		}
		cyclistModel.setTeam(teamModel);
		cyclistService.addCyclist(cyclistModel);

		mav.setViewName("redirect:/cyclist");
		return mav;
	}
}
