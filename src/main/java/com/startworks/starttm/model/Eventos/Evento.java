package com.startworks.starttm.model.Eventos;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.startworks.starttm.model.Categoria;


@Entity
@Table(name="evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evento")
	private long id;
	
	@NotBlank(message="O Titulo não pode estar em branco")
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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tipo_evento",insertable=true,updatable=true)
	@Cascade(CascadeType.SAVE_UPDATE)
	private TipoEvento tipo;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="evento_categoria",
				joinColumns=@JoinColumn(name="id_evento"),
				inverseJoinColumns = @JoinColumn(name="id_categoria"))
	private Collection<Categoria> categoria;
	
	
	//Adicionar Local do Circular do evento
	
	//Adicionar Local da imagem do evento
	
	

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public Collection<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(Collection<Categoria> categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long codigo) {
		this.id = codigo;
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
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
