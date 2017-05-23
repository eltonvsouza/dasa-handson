package com.dasa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.DadoCampanha;
import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.EstatisticaAnoResponse;
import com.dasa.domain.EstatisticaCampanhaAnoResponse;
import com.dasa.enumeration.Campanha;
import com.dasa.enumeration.Sexo;
import com.dasa.repository.DadosPopulacionaisRepository;
import com.dasa.service.DadosCampanhaService;
import com.dasa.service.DadosPopulacionaisService;

@RestController
public class SampleController {

	@Autowired
	DadosPopulacionaisService service;
	
	@Autowired
	DadosCampanhaService serviceCampanha;
	
	@RequestMapping("/hello")
	public String helloWorld(){
		return "Hello =)";
	}
	
	@RequestMapping("/2010")
	public EstatisticaAnoResponse get2010data(){
		
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of("2010"));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);
		
		return stat;
	}
	
	/*
	 *  1.1 Retorne o resultado para o ano de 2010.
	 */
	@RequestMapping("/dadosAno")
	public EstatisticaAnoResponse getAnoData(
			@RequestParam (value="ano", required=true, defaultValue="2016") String ano){
		
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of(ano));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);
		
		return stat;
	}
	
    /*
     * 2.1 Fornecer uma API com os dados de participação por Campanha,
     * realizando o filtro por Ano.
     */
	@RequestMapping("/dadosCampanhaAno")
	public EstatisticaCampanhaAnoResponse getCampanhaAnoData(
			@RequestParam (value="ano", required=true, defaultValue="2016") String ano){
		
		DadoCampanha pop = serviceCampanha.obterCampanhaPorAno(Optional.of(ano));
		EstatisticaCampanhaAnoResponse stat = new EstatisticaCampanhaAnoResponse(pop);
		
		return stat;
	}
	
	/*
	 *  1.2 Retorne o resultado para o ano de 2017 considerando a formula de projeção
	 *  Geométrica de crescimento. populacional
	 */
	@RequestMapping("/projecao")
	public double getProjecaoData(int qtdAno, int ano){
		
		DadoPopulacional popIni = service.obterPopulacaoPorAno(Optional.of(String.valueOf(ano-qtdAno)));
		DadoPopulacional popFim = service.obterPopulacaoPorAno(Optional.of(String.valueOf(ano)));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(popIni);

		stat.getProjecaoResponse(popIni, popFim);
		
		return stat.getProjecaoResponse(popIni, popFim);
	}
	
	/*
	 *  2.2 Fornecer uma API com a proporção de participação entre Homens X Mulheres X Campanha
	 *  filtrando pelo ano.
	 */
	@RequestMapping("/projecao")
	public EstatisticaCampanhaAnoResponse getProprcaoCampanha(
			@RequestParam (value="ano", required=true, defaultValue="2016") int ano){
		
		DadoCampanha pop = serviceCampanha.obterProporcaoCampanhaPorAno(Optional.of("2010"));
		EstatisticaCampanhaAnoResponse stat = new EstatisticaCampanhaAnoResponse(pop);
		
		return stat;
	}
	
	/*
	 * 2. Fornecer uma API onde um usuário possa notificar que participou de uma
	 * das campanhas. Importante que na resposta da participação contenha o Sexo,
	 * a Campanha e o ano.
	 */
	@PostMapping("/campanha")
	public DadosPopulacionaisRepository setCampanhadata(@RequestBody String ano,
			Enum<Campanha> campanha, Enum<Sexo> sexo){

		DadoCampanha pop = serviceCampanha.notificarCampanha(Optional.of(ano), campanha, sexo);
		EstatisticaCampanhaAnoResponse stat = new EstatisticaCampanhaAnoResponse(pop);
		
		return (DadosPopulacionaisRepository) stat;
		
	}
	
}
