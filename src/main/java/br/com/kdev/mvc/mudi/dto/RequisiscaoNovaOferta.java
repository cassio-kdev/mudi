package br.com.kdev.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.kdev.mvc.mudi.model.Oferta;

public class RequisiscaoNovaOferta {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Integer pedidoId;
	
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	@NotNull(message = "Campo valor obrigatório")
	private String valor;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "O campo dever está neste formato dd/MM/yyyy ex: 31/12/2022" )
	@NotNull(message = "Campo data obrigatório")
	private String dataDaEntrega;
	private String comentario;

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
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

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setValor(new BigDecimal(this.valor));
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formatter));
		return oferta;
	}

}
