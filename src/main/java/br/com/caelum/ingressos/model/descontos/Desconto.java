package br.com.caelum.ingressos.model.descontos;

import java.math.BigDecimal;

public interface Desconto {

	BigDecimal  aplicarDescontoSobre(BigDecimal precoOriginal);
	
}
