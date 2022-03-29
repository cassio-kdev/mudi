package br.com.kdev.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kdev.mvc.mudi.dto.PedidoDto;
import br.com.kdev.mvc.mudi.model.Pedido;
import br.com.kdev.mvc.mudi.model.StatusPedido;
import br.com.kdev.mvc.mudi.orm.PedidoRepository;

@RestController
@RequestMapping("api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<PedidoDto> getPedidosAguardandoOfertas(){
		Sort sort = Sort.by("id").descending();
		PageRequest request = PageRequest.of(0, 10,sort);
		
		List<Pedido> findByStatus = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, request);
		
		return PedidoDto.builder(findByStatus);
	}
}
