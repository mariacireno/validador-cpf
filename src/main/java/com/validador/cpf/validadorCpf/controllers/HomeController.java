package com.validador.cpf.validadorCpf.controllers;

import com.validador.cpf.validadorCpf.models.Cliente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "home/index";
	}

	@GetMapping("/valida-cpf")
	public String validaCpf(Cliente cliente, Model model) {
		boolean verdade = cliente.validarCpf();
		model.addAttribute("verdade", verdade);
		return "home/cpfValidado";
	}
}
