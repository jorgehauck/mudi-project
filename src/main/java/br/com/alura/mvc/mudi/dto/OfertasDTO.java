package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Ofertas;

public class OfertasDTO {
	
	
	private Long pedidoId;
	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	private String valor;
	@NotNull
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	private String dataDaEntrega;
	private String comentario;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public OfertasDTO() {
	}

	public OfertasDTO(Long pedidoId, String valor, String dataDaEntrega, String comentario) {
		this.pedidoId = pedidoId;
		this.valor = valor;
		this.dataDaEntrega = dataDaEntrega;
		this.comentario = comentario;
	}
	
	public OfertasDTO(Ofertas ofertas) {
		this.pedidoId = ofertas.getId();
		this.comentario = ofertas.getComentario();
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	public Ofertas toOfertas() {
		Ofertas ofertas = new Ofertas();
		ofertas.setComentario(this.comentario);
		LocalDate date = LocalDate.parse(this.dataDaEntrega, formatter);
		ofertas.setDataDaEntrega(date);
		ofertas.setValor(new BigDecimal(this.valor));
		
		return ofertas;
	}
}
