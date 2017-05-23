package com.dasa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasa.domain.DadoPopulacional;
import com.dasa.repository.DadosPopulacionaisRepository;

@Service
public class DadosPopulacionaisServiceimpl implements DadosPopulacionaisService {

    @Autowired
    private DadosPopulacionaisRepository dadosPopulacionaisRepository;

    @Override
    public DadoPopulacional obterPopulacaoPorAno(final Optional<String> ano) {

        final String anoCenso = ano.get();

        if (!ano.isPresent()) {
            throw new IllegalArgumentException("Parametro Ano é Obrigatório");
        }

        return dadosPopulacionaisRepository.findByAno(anoCenso);
    }
}
