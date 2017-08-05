package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingressos.model.descontos.Desconto;

public class Ingresso {

	private Sessao sessao;
	private BigDecimal preco;
	
	public Ingresso(Sessao sessao, Desconto tipoDesconto){
		this.sessao = sessao;
		this.preco = tipoDesconto.aplicarDescontoSobre(sessao.getPreco());
	}

	public Sessao getSessao() {
		return sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
	
	
}