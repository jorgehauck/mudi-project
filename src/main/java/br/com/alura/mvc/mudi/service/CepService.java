package br.com.alura.mvc.mudi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface CepService {

	@GetMapping(path = "{cep}/json")
	EnderecoService findByCep(@PathVariable("cep") String cep);
}
