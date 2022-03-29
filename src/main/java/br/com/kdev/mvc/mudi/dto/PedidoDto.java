package br.com.kdev.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.kdev.mvc.mudi.model.Pedido;
import br.com.kdev.mvc.mudi.model.StatusPedido;

public class PedidoDto {
	private Integer id;
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	private StatusPedido status;

	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.nomeProduto = pedido.getNomeProduto();
		this.urlProduto = pedido.getUrlProduto();
		this.urlImagem = pedido.getUrlImagem();
		this.descricao = pedido.getDescricao();
		this.status = pedido.getStatus();
	}

	public static List<PedidoDto> builder(List<Pedido> pedidos) {
		List<PedidoDto> pedidosdto = new ArrayList<>();

		pedidos.forEach(pedido -> {
			pedidosdto.add(new PedidoDto(pedido));
		});

		return pedidosdto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
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

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

}
