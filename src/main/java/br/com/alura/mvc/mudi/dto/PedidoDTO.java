package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;

public class PedidoDTO {

	private String nomeProduto;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	public PedidoDTO() {
		
	}

	public PedidoDTO(String nomeProduto, String urlProduto, String urlImagem, String descricao) {
		this.nomeProduto = nomeProduto;
		this.urlProduto = urlProduto;
		this.urlImagem = urlImagem;
		this.descricao = descricao;
	}
	
	public PedidoDTO(Pedido pedido) {
		this.nomeProduto = pedido.getNomeProduto();
		this.urlProduto = pedido.getUrlProduto();
		this.urlImagem = pedido.getUrlImagem();
		this.descricao = pedido.getDescricao();
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido toPedido() {
		
		return null;
	}
}
