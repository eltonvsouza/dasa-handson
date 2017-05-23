package com.dasa.service;

import java.util.Optional;

import com.dasa.domain.DadoCampanha;
import com.dasa.enumeration.Campanha;
import com.dasa.enumeration.Sexo;


public interface DadosCampanhaService {

    DadoCampanha obterCampanhaPorAno(Optional<String> ano);

    DadoCampanha notificarCampanha(Optional<String> ano, Enum<Campanha> campanha, Enum<Sexo> sexo);

    DadoCampanha obterProporcaoCampanhaPorAno(Optional<String> ano);
    
}
