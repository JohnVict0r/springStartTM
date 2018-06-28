package com.startworks.starttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventosController {
	
	@RequestMapping("/eventos")
	public String eventos() {
		return "eventos/portalEventos";
	}
	@RequestMapping("/eventos/novo")
	public String novo() {
		return "eventos/cadastrar";
	}
	@RequestMapping("/eventos/listar")
	public String listar() {
		return "eventos/listar";
	}
	
	
	
	
}
