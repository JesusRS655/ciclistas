package application.controller;

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
import org.springframework.web.servlet.ModelAndView;

import application.configuration.TestCrypt;
import application.constants.ViewConstants;
import application.model.UserModel;
import application.service.UserRoleService;
import application.service.UserService;

@Controller
@RequestMapping("/")
public class RegisterController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@Autowired
	@Qualifier("userRoleServiceImpl")
	private UserRoleService userRoleService;

	private static final Log LOG = LogFactory.getLog(RegisterController.class);

	private TestCrypt crypt = new TestCrypt();

	@GetMapping("/register")
	public String register(Model model) {
		LOG.info("Returning view: " + ViewConstants.REGISTER_FORM_VIEW);
		UserModel userModel = new UserModel();
		model.addAttribute("user", userModel);
		return ViewConstants.REGISTER_FORM_VIEW;
	}

	@PostMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute("user") UserModel userModel) {
		LOG.info("Adding a user");
		LOG.info(userModel.getUsername());
		ModelAndView mav = new ModelAndView();
		userModel.setPassword(crypt.crypt(userModel.getPassword()));
		userModel.setEnabled(true);
		userService.registerUser(userModel);
		mav.setViewName("redirect:/login");
		return mav;
	}

}
