package com.startworks.starttm.model.Eventos;

public enum TipoEvento {

	ESCOLAR,
	ESTADUAL,
	INTERESTADUAL,
	CBTM_NAO;
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
