package com.dasa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasa.domain.DadoCampanha;
import com.dasa.enumeration.Campanha;
import com.dasa.enumeration.Sexo;
import com.dasa.repository.DadosCampanhaRepository;

@Service
public class DadosCampanhaServiceimpl implements DadosCampanhaService {

    @Autowired
    private DadosCampanhaRepository dadosCampanhaRepository;

    
    @Override
    public DadoCampanha obterCampanhaPorAno(final Optional<String> ano) {

        final String anoCenso = ano.get();

        if (!ano.isPresent()) {
            throw new IllegalArgumentException("Parametro Ano é Obrigatório");
        }

        return dadosCampanhaRepository.findCampanhaByAno(anoCenso);
    }
    
    @Override
    public DadoCampanha notificarCampanha(Optional<String> ano,
    		Enum<Campanha> campanha, Enum<Sexo> sexo) {

    	DadoCampanha dadoCampanha = new DadoCampanha(ano, campanha, sexo);
    	
        return dadosCampanhaRepository.save(dadoCampanha);
    }
    
    @Override
    public DadoCampanha obterProporcaoCampanhaPorAno(final Optional<String> ano) {

        final String anoCenso = ano.get();

        if (!ano.isPresent()) {
            throw new IllegalArgumentException("Parametro Ano é Obrigatório");
        }

        return dadosCampanhaRepository.findProporcaoCampanhaByAno(anoCenso);
    }
}
