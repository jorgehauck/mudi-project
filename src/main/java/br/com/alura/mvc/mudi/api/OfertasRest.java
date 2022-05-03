package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.OfertasDTO;
import br.com.alura.mvc.mudi.model.Ofertas;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;

@RestController
@RequestMapping(path = "api/ofertas")
public class OfertasRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Ofertas criaOferta(OfertasDTO ofertasDTO) {
		
		Optional<Pedido> pedido = pedidoRepository.findById(ofertasDTO.getPedidoId());
		
		if(!pedido.isPresent()) {
			return null;
		}
		
		Ofertas nova = ofertasDTO.toOfertas();
		
		return nova;
		
	}
}
