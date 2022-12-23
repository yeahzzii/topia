package topia.com.prac;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import topia.com.prac.entity.UserInfo;
import topia.com.prac.personalHistory.serv.PersonalHistoryServImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// http://localhost:8010/prac/
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @RequestParam(required = false) String userIdx) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("userIdx", userIdx );
		
		return "home";
	}
	// http://localhost:8010/prac/list
	 @Autowired(required=false)
	 PersonalHistoryServImpl service;
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getUserList(Locale locale, Model model, Integer userIdx, UserInfo userinfo) {
		
		 
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("listPage", service.getUserList(userIdx));
		service.detailUserList(userIdx);
		service.deleteUserList(userinfo);
		
		return "list";
	}
	/*
	 @Autowired(required=false)
	 @RequestMapping(value = "/boardList")
	public String boardList(Locale locale, Model model) {
		
		 
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		model.addAttribute("board", service.getUserList());
		
		return "boardList";
	}
	 */
	
	
	 
	

	
}
