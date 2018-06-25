package com.startworks.starttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AtletasController {

	@RequestMapping("atletas/cadastrar")
	public String Cadastrar() {
		return "atletas/cadastrar";
	}
}
