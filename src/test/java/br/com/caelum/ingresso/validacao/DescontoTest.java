package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

import static org.junit.Assert.*;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingressos.model.descontos.DescontoBancos;
import br.com.caelum.ingressos.model.descontos.DescontoEstudante;
import br.com.caelum.ingressos.model.descontos.SemDesconto;
import br.com.caelum.ingressos.model.descontos.TipoDeIngresso;

public class DescontoTest {

	@Test
	public void deveConcederDescontoDe30PorCentoParaIngressosDeClientesDeBanco(){
		
		Lugar lugar = new Lugar("A", 1);
		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
		
		Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.BANCO, lugar);
		
		BigDecimal precoEsperado = new BigDecimal("22.75");
		
		assertEquals(precoEsperado, ingresso.getPreco());
		
	}
	
	@Test
	public void deveConcederDescontoDe5PorcentoParaIngressoDeEstudante(){
		
		Lugar lugar = new Lugar("A", 1);
		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
		
		Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.ESTUDANTE, lugar);
		
		BigDecimal precoEsperado = new BigDecimal("16.25");
		
		assertEquals(precoEsperado, ingresso.getPreco());
		
	}
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal(){
		
		Lugar lugar = new Lugar("A", 1);
		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
		
		Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO, lugar);
		
		BigDecimal precoEsperado = new BigDecimal("32.5");
		
		assertEquals(precoEsperado, ingresso.getPreco());
	}
	
}
