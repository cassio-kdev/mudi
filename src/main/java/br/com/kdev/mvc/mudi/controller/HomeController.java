package br.com.kdev.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.kdev.mvc.mudi.model.Pedido;
import br.com.kdev.mvc.mudi.model.StatusPedido;
import br.com.kdev.mvc.mudi.orm.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String status(Model model, Principal principal) {
		
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest page = PageRequest.of(0, 1, sort);

		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, page);

		model.addAttribute("pedidos", pedidos);
		return "home";
	}

}
