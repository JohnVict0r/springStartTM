package com.startworks.starttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventosController {
	
	@RequestMapping("/eventos/novo")
	public String novo() {
		return "eventos/cadastro";
	}
}
