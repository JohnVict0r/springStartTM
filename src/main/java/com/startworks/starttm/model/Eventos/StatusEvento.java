package com.startworks.starttm.model.Eventos;

public enum StatusEvento {

	ABERTO("Aberto"),
	FINALIZADO("Finalizado"),
	EXECUCAO("Execucao");
	
	private String descricao;
	
	StatusEvento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
}
	
}
