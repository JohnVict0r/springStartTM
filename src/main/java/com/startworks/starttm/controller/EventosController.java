package com.startworks.starttm.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
	public ModelAndView salvar(
			@RequestParam("circularFile") MultipartFile circular, 
			@RequestParam("imagemFile") MultipartFile imagem,
			@Valid Evento evento, BindingResult result, 
			RedirectAttributes attributes) {			
					
		
		if (!fileStorage.validarArquivo(circular)){			
			result.addError(new FieldError("circular", "circularFile", "Formato do arquivo da circular deve ter extensão .PDF!"));		
		}
		
		if (!fileStorage.validarImagem(imagem)){			
			result.addError(new FieldError("imagem", "imagemFile", "Formato da imagem deve ter extensão Válida, por Exemplo: .JPG .JPEG .PNG!"));		
		}
		
		if (result.hasErrors()) {
			return novo(evento);
		}
		
		
		try {
			
			fileStorage.salvarCircular(circular);												
			
		} catch (Exception e) {			
			System.out.println("erro ao salvar arquivo da circular");
		}
		
		try {
			
			fileStorage.salvarImagem(imagem);												
			
		} catch (Exception e) {			
			System.out.println("erro ao salvar arquivo da circular");
		}
		
		evento.setStatus(StatusEvento.ABERTO);		
		evento.setCircular(circular.getOriginalFilename());					
		evento.setImagem(imagem.getOriginalFilename());
		
		
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
