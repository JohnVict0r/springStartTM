package com.startworks.starttm.model.Eventos;

public enum CategoriaEvento {

	RANKING_MAS,
	RANKING_FEM,
	RATING_MAS,
	RATING_FEM;
	
	private String categoria;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
