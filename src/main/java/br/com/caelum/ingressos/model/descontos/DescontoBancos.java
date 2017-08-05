package br.com.caelum.ingressos.model.descontos;

import java.math.BigDecimal;

public class DescontoBancos implements Desconto {

	private BigDecimal desconto = new BigDecimal("0.3");
	
	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(desconteBanco(precoOriginal));
	}

	private BigDecimal desconteBanco(BigDecimal precoOriginal) {
		return precoOriginal.multiply(desconto);
	}

}
