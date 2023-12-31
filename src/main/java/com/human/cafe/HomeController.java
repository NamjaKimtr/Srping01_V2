package com.human.cafe;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		
		//model.addAttribute("serverTime", formattedDate );
		System.out.println(" / 컨트롤러 처리");
		
		return "home";
	}
	
	@RequestMapping(value = "/toserver", method = RequestMethod.GET)
	public String toserver(Locale locale, Model model) {
		
		return "/socket/webchat";
	}
	/*
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(Locale locale, Model model, HttpServletRequest request) {	
		String name = request.getParameter("nnn");
		System.out.println(name);
		model.addAttribute("sss", "hi" );		
		return "ttt";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(Locale locale, Model model, @RequestParam("nnn") String name ) {	
		System.out.println("어노테이션으로 받는 법 :" +name);
		model.addAttribute("sss", "hi" );		
		return "ttt";
	}*/
	
}
