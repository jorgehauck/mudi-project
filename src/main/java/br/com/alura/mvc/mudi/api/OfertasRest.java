package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Ofertas criaOferta(@Valid @RequestBody OfertasDTO ofertasDTO) {
		
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(ofertasDTO.getPedidoId());
		
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		Ofertas nova = ofertasDTO.toOfertas();
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova);
		pedidoRepository.save(pedido);
		return nova;
	}
}
