package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "cep")
public class CepController {

	@GetMapping
	public String getCep() {
		return "fretes/entrega";
	}
}
