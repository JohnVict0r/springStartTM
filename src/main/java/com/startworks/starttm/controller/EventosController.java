package com.startworks.starttm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.startworks.starttm.model.Eventos.Eventos;
import com.startworks.starttm.repository.EventosRepository;

@Controller
@RequestMapping("/starttm/eventos")
public class EventosController {
	
	@Autowired
	private EventosRepository eventos;
	
	
	@RequestMapping("")
	public String eventos() {
		return "eventos/portalEventos";
	}
	@RequestMapping("/cadastrar")
	public String novo() {
		return "eventos/cadastrar";
	}
	
	@RequestMapping("/listar")
	public ModelAndView listar(){
	
		ModelAndView modelAndView = new ModelAndView("eventos/listar"); 
		
		modelAndView.addObject("eventos", eventos.findAll());
		
		return modelAndView;
		
	}
	
	
}
