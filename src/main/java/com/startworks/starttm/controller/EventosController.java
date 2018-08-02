package com.startworks.starttm.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.startworks.starttm.filestorage.FileStorage;
import com.startworks.starttm.model.Eventos.Evento;
import com.startworks.starttm.model.Eventos.StatusEvento;
import com.startworks.starttm.repository.EventoRepository;
import com.startworks.starttm.repository.TipoEventoRepository;



@Controller
@RequestMapping("/starttm/eventos")
public class EventosController {
	
	@Autowired
	private EventoRepository eventos;
	
	@Autowired
	private TipoEventoRepository tipos;
	
	@Autowired
	private FileStorage fileStorage;
		
	@RequestMapping("")
	public String eventos() {
		return "eventos/portalEventos";
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView novo(Evento evento) {
		ModelAndView modelAndView = new ModelAndView("eventos/cadastrar");
		
		modelAndView.addObject(evento);
		modelAndView.addObject("status", StatusEvento.values());		 		
		modelAndView.addObject("tipos", tipos.findAll());		
		
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView salvar(@RequestParam("circularFile") MultipartFile circular, @Valid Evento evento, BindingResult result,
			RedirectAttributes attributes) {			
					
		try {
			fileStorage.salvarCircular(circular);			
		} catch (Exception e) {
			attributes.addAttribute("message", "Fail! -> uploaded filename: " + circular.getOriginalFilename());
		}
		
		evento.setStatus(StatusEvento.ABERTO);		
		evento.setCircular(circular.getOriginalFilename());		
		
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
