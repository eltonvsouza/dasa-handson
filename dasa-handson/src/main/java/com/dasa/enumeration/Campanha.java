package com.dasa.enumeration;

public enum Campanha {

	CANCER_DE_MAMA (1, "CM"),
	CANCER_DE_PROSTATA (2, "CP");
	
	private int id;
	private String sigla;

	Campanha (int id, String sigla){
		this.id = id;
		this.sigla = sigla;
	}
}
