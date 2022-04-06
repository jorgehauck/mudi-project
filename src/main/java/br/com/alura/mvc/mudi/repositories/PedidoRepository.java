package br.com.alura.mvc.mudi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;

@Repository
public class PedidoRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<Pedido> findPedidos() {
		Query query = entityManager.createQuery("SELECT p from Pedido p", Pedido.class);
		
		List<Pedido> pedidos = query.getResultList();
		
		return pedidos;
	}
}
