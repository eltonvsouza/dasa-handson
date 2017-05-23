package com.dasa.enumeration;

public enum Sexo {

	MASCULINO(1, "M"),
	FEMININO(2, "F");
	
	private int id;
	private String sigla;
    
	Sexo(int id, String sigla){
		this.id = id;
		this.sigla = sigla;
	}
}
