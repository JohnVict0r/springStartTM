package com.startworks.starttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/starttm/atletas")
public class AtletasController {

	@RequestMapping("/cadastrar")
	public String Cadastrar() {
		return "atletas/cadastrar";
	}
}
