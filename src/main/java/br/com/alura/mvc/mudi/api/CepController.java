package br.com.alura.mvc.mudi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.service.CepService;
import br.com.alura.mvc.mudi.service.EnderecoService;

@RestController
@RequestMapping(path = "api/cep")
public class CepController {
	
	@Autowired
	private CepService cepService;

	@GetMapping(path = "{cep}")
	public EnderecoService buscaPorCep(@PathVariable("cep") String cep) {
		EnderecoService service = cepService.findByCep(cep);
		return service;
	}
}
