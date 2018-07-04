package com.startworks.starttm.model.Eventos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.startworks.starttm.model.Categoria;


@Entity
public class Eventos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	private String titulo;

	private String cidade;

	private String estado;
	
	private String endereco;
	
	
	//Adicionar horario de inicio e fim nas datas
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorIncricao;
	
	@Enumerated(EnumType.STRING)
	private StatusEvento status;
	
	//adicionar tipo
	
	private ArrayList<Categoria> categorias;
	
	

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public BigDecimal getValorIncricao() {
		return valorIncricao;
	}

	public void setValorIncricao(BigDecimal valorIncricao) {
		this.valorIncricao = valorIncricao;
	}

	public StatusEvento getStatus() {
		return status;
	}

	public void setStatus(StatusEvento status) {
		this.status = status;
	}



	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
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
		Eventos other = (Eventos) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
