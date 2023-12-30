package com.human.cafe;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JsonMiseMunji {
	@RequestMapping(value = "/testJson", method = RequestMethod.GET)
	public String WrAction(Locale locale, Model modele) throws Exception{
		
		return "sampleCode/jsonAPI";  // 수정예정
	}
	
}
