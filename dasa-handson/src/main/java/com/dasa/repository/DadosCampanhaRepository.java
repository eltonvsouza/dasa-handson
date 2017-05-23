package com.dasa.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.DadoCampanha;

@Transactional
public interface DadosCampanhaRepository extends CrudRepository<DadoCampanha, Long> {

    DadoCampanha findCampanhaByAno(final String ano);

	DadoCampanha save(DadoCampanha dadoCampanha);

	DadoCampanha findProporcaoCampanhaByAno(final String ano);

}
