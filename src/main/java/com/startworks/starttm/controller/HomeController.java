package com.startworks.starttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
	
	@RequestMapping("/public")
	public String index() {
		return "public";
	}
	@RequestMapping("/starttm")
	public String home() {
		return "home";
	}

}
