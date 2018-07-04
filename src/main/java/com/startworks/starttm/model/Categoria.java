package com.startworks.starttm.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String divisao;
	
	@Enumerated(EnumType.STRING)
	private CategoriaTipo tipo;
	
	private String modalidade;
	
	private Boolean paraolimpico;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDivisao() {
		return divisao;
	}

	public void setDivisao(String divisao) {
		this.divisao = divisao;
	}

	public CategoriaTipo getTipo() {
		return tipo;
	}

	public void setTipo(CategoriaTipo tipo) {
		this.tipo = tipo;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public Boolean getParaolimpico() {
		return paraolimpico;
	}

	public void setParaolimpico(Boolean paraolimpico) {
		this.paraolimpico = paraolimpico;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
