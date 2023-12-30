package com.human.cafe;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "/rest/RESTFul_Sample";
	}
}
