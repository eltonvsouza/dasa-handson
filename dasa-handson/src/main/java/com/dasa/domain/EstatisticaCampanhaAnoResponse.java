package com.dasa.domain;

import java.math.BigDecimal;
import java.util.Optional;

import com.dasa.enumeration.Campanha;
import com.dasa.enumeration.Sexo;

import lombok.Data;

@Data
public class EstatisticaCampanhaAnoResponse {
	private final Optional<String> ano;
	private final Enum<Campanha> campanha;
	private final String totalHomens;
	private final String totalMulheres;
	private final String total;
	
	public EstatisticaCampanhaAnoResponse(DadoCampanha camp) {
		this.ano = camp.getAno();
		this.campanha = camp.getCampanha();
		this.totalHomens = String.valueOf(camp.getTotalHomens());
		this.totalMulheres = String.valueOf(camp.getTotalMulheres());
		this.total = String.valueOf(camp.getTotal());
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
