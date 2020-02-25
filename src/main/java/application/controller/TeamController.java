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
import application.model.TeamModel;
import application.service.TeamService;

@Controller
@RequestMapping("/")
public class TeamController {

	@Autowired
	@Qualifier("teamServiceImpl")
	private TeamService teamService;

	private static final Log LOG = LogFactory.getLog(TeamController.class);

	@GetMapping("/team")
	public ModelAndView team() {
		LOG.info("Returning view: " + ViewConstants.TEAM_VIEW);
		ModelAndView mav = new ModelAndView(ViewConstants.TEAM_VIEW);
		mav.addObject("teams", teamService.listTeams());
		return mav;
	}

	@GetMapping("/teamForm")
	public String teamForm(Model model, @RequestParam(name = "teamname") String teamname) {
		LOG.info("Returning view: " + ViewConstants.TEAM_FORM_VIEW);
		TeamModel teamModel = new TeamModel();
		List<TeamModel> tModelList = teamService.listTeams();
		if (!teamname.isEmpty())
			for (TeamModel tm : tModelList)
				if (teamname.equals(tm.getTeamname()))
					teamModel = tm;
		model.addAttribute("team", teamModel);
		return ViewConstants.TEAM_FORM_VIEW;
	}

	@PostMapping("/addTeam")
	public ModelAndView addTeam(Model model, @RequestParam(name = "teamPic") MultipartFile picture,
			@ModelAttribute("team") TeamModel teamModel) {

		LOG.info("Adding team");

		ModelAndView mav = new ModelAndView();

		if (!picture.isEmpty()) {
			Path dir = Paths.get(".\\src\\main\\resources\\static\\img");
			String rootPath = dir.toFile().getAbsolutePath();
			try {
				byte[] bytes = picture.getBytes();
				Path route = Paths.get(rootPath + "\\" + teamModel.getTeamname() + ".png");
				Files.write(route, bytes);
				teamModel.setPicture("/img/" + teamModel.getTeamname() + ".png");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
			teamModel.setPicture("/img/defaultT.png");
		}
		teamService.addTeam(teamModel);

		mav.setViewName("redirect:/team");
		return mav;
	}

}
