package br.com.caelum.ingressos.model.descontos;

import java.math.BigDecimal;

public enum TipoDeIngresso {

	INTEIRO(new SemDesconto()),
	ESTUDANTE(new DescontoEstudante()),
	BANCO(new DescontoBancos());
	
	private final Desconto desconto;
	
	TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}
	
	public BigDecimal aplicaDesconto(BigDecimal valor){
		return desconto.aplicarDescontoSobre(valor);
	}
	
	public String getDescricao(){
		return desconto.getDescricao();
	}
	
	//TipoDeIngresso tipo = TipoDeIngresso.INTEIRO;
	
	/*
	 * A linha de código acima funciona da mesma forma se estivessemos criando diretamente uma 
	 * instância de TipoDeDesconto, e em seu construtor, colocaríamos um objeto do tipo da internface Desconto,
	 * já populando a constante privada do tipo Desconto.
	 * 
	 * */
	
}
