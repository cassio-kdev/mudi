package br.com.kdev.mvc.mudi.orm;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kdev.mvc.mudi.model.Pedido;
import br.com.kdev.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

	@Cacheable("ped")
	List<Pedido> findByStatus(@Param("status") StatusPedido status,Pageable page);

	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
	Iterable<Pedido> findAllByUsuario(@Param("username") String username);

	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username and p.status = :status")
	List<Pedido> findByStatusEUsuario(@Param("status") StatusPedido status, @Param("username") String username);

}
