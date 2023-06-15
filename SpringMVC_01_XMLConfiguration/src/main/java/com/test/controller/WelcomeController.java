package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	
	// below code will work as servlet
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		System.out.println("welcome method call from welcome controller");
		// set data
		model.addAttribute("message","Welcome to User Application");
		// navigate to view
		return "welcome-page";
		// WEB-INF/views/welcome-page.jsp
	}
	
}
