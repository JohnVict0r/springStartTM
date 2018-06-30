package com.startworks.starttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/starttm/eventos")
public class EventosController {
	
	@RequestMapping("")
	public String eventos() {
		return "eventos/portalEventos";
	}
	@RequestMapping("/cadastrar")
	public String novo() {
		return "eventos/cadastrar";
	}
	@RequestMapping("/listar")
	public String listar() {
		return "eventos/listar";
	}
	
	
	
	
}
