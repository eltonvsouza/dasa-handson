package com.dasa.domain;

import javax.persistence.*;

import com.dasa.enumeration.Campanha;
import com.dasa.enumeration.Sexo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

@Data
@Entity
@Table(name = "dados_campanhas")
public class DadoCampanha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Optional<String> ano;

    private Enum<Campanha> campanha;

    private Long totalHomens;

    private Long totalMulheres;
    
    private BigDecimal total;

    public DadoCampanha() {
    }
    
    public DadoCampanha(Optional<String> ano, Enum<Campanha> campanha, Enum<Sexo> sexo) {
		this.ano = ano;
		this.campanha = campanha;
		this.totalHomens = totalHomens;
		this.totalMulheres = totalMulheres;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Optional<String> getAno() {
		return ano;
	}

	public void setAno(Optional<String> ano) {
		this.ano = ano;
	}

	public Enum<Campanha> getCampanha() {
		return campanha;
	}

	public void setCampanha(Enum<Campanha> campanha) {
		this.campanha = campanha;
	}

	public Long getTotalHomens() {
		return totalHomens;
	}

	public void setTotalHomens(Long totalHomens) {
		this.totalHomens = totalHomens;
	}

	public Long getTotalMulheres() {
		return totalMulheres;
	}

	public void setTotalMulheres(Long totalMulheres) {
		this.totalMulheres = totalMulheres;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	
}
