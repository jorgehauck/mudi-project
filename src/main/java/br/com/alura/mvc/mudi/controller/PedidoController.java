package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.PedidoDTO;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;
import br.com.alura.mvc.mudi.repositories.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public String formulario(PedidoDTO pedidoDTO) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid PedidoDTO pedidoDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		/*
		 * Variável username sendo atribuída a um método que retorna o nome do usuário
		 * logado.
		 */
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(pedidoDTO.getNomeProduto());
		pedido.setUrlProduto(pedidoDTO.getUrlProduto());
		pedido.setUrlImagem(pedidoDTO.getUrlImagem());
		pedido.setDescricao(pedidoDTO.getDescricao());
		pedido.setStatus(StatusPedido.APROVADO);
		pedido.setUser(user);
		
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}
