package com.dasa.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EstatisticaAnoResponse {
	private final String ano;
	private final String popTotal;
	private final String percentM;
	private final String percentF;
	
	public EstatisticaAnoResponse(DadoPopulacional pop) {
		this.ano = pop.getAno();
		this.popTotal = String.valueOf(pop.getPopulacaoTotal());
		this.percentM = String.valueOf(
				(pop.getTotalHomens()/pop.getPopulacaoTotal().longValue())*100);
		this.percentF = String.valueOf(
				(pop.getTotalMulheres()/pop.getPopulacaoTotal().longValue())*100);
	}
	
	public double getProjecaoResponse(DadoPopulacional popIni, DadoPopulacional popFim) {
		
		/*
		 * r = taxa de crescimanto
		 * p0 = populacao inicio periodo  
		 * pt = populacao final
		 * (2016/2000)-1
		 * (pt/p0)-1
		 */
		
		int qtdAno = Integer.valueOf(popFim.getAno()) - Integer.valueOf(popIni.getAno());
		
//		double raiz = Math.pow(2016/2000, 1.0/16.0);
		double raiz = Math.pow(
				popFim.getPopulacaoTotal().doubleValue()
				/popIni.getPopulacaoTotal().doubleValue()
				, 1.0/qtdAno);
		
		return raiz;
	}
}
