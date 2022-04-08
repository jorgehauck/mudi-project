package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.PedidoDTO;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(PedidoDTO pedidoDTO) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(pedidoDTO.getNomeProduto());
		pedido.setUrlProduto(pedidoDTO.getUrlProduto());
		pedido.setUrlImagem(pedidoDTO.getUrlImagem());
		pedido.setDescricao(pedidoDTO.getDescricao());
		
		pedidoRepository.save(pedido);
		return "pedido/formulario";
	}
}
