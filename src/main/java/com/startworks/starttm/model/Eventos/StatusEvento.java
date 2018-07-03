package com.startworks.starttm.model.Eventos;

public enum StatusEvento {

		ABERTO,
		FINALIZADO,
		EXECUCAO;
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
