package application.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.constants.ViewConstants;
import application.service.NewsService;

@Controller
@RequestMapping("/")
public class IndexController {

	private static final Log LOG = LogFactory.getLog(IndexController.class);

	@Autowired
	@Qualifier("newsServiceImpl")
	private NewsService newsService;

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewConstants.INDEX_VIEW);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		LOG.info("Returning view: " + ViewConstants.INDEX_VIEW);
		mav.addObject("username", user.getUsername());
		mav.addObject("news", newsService.listNews());
		return mav;
	}

}
