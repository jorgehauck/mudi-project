package br.com.alura.mvc.mudi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	
	List<Pedido> findByStatus(StatusPedido statusPedido);
    // Annotation @Param filtro para buscar de dados pelo parâmetro informado.
	
	@Query("SELECT p from Pedido p JOIN p.user u where u.username = :username")
	List<Pedido> findByUserOrder(@Param("username") String username);
	
}
