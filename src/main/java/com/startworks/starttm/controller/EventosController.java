package com.startworks.starttm.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.startworks.starttm.model.Eventos.Evento;
import com.startworks.starttm.model.Eventos.StatusEvento;
import com.startworks.starttm.repository.EventoRepository;

@Controller
@RequestMapping("/starttm/eventos")
public class EventosController {
	
	@Autowired
	private EventoRepository eventos;
	
	
	@RequestMapping("")
	public String eventos() {
		return "eventos/portalEventos";
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView novo(Evento evento) {
		ModelAndView modelAndView = new ModelAndView("eventos/cadastrar");
		
		modelAndView.addObject(evento);
		modelAndView.addObject("status", StatusEvento.values());		
		
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView salvar(@Valid Evento evento, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(evento);
		}
		
		
		
		eventos.save(evento);
		
		attributes.addFlashAttribute("mensagem", "Evento salvo com sucesso!");
		
		return new ModelAndView("redirect:/starttm/eventos/listar");
	}
	
	@RequestMapping("/listar")
	public ModelAndView listar(){					
	
		ModelAndView modelAndView = new ModelAndView("eventos/listar"); 
		
		modelAndView.addObject("eventos", eventos.findAll());
		
		return modelAndView;
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		eventos.delete(id);
		
		attributes.addFlashAttribute("message", "Evento removido com sucesso!");
		return "redirect:/starttm/eventos/listar";
}
	
	
}
