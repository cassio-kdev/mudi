package br.com.kdev.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kdev.mvc.mudi.interceptor.InterceptadorDeAcessos;
import br.com.kdev.mvc.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RestController
@RequestMapping("acessos")
public class AcessoRest {
	
	@GetMapping
	public List<Acesso> acessos(){
		return InterceptadorDeAcessos.acessos;
	}

}
