package br.com.petrobras.exp.projetostg.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.petrobras.exp.projetostg.domain.enums.LinhaPesquisa;

@Entity
public class Projeto implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	
	private String objetivo;
	
	private String justificativa;
	
	@OneToMany(mappedBy = "projeto")
	private List<Marco> marcos = new ArrayList<>();
	
	@JsonFormat(pattern="dd/MM/yyy")
	private Date dataInicio;
	
	@JsonFormat(pattern="dd/MM/yyy")
	private Date dataTermino;
	
	@ManyToOne
	private Empregado coordenador;
	
	@ManyToMany
	private List<Empregado> responsaveisTecnicos;
	
	@ManyToMany
	private List<Empregado> participantes;
	
	@Enumerated(EnumType.STRING)
	private LinhaPesquisa linhaPesquisa;
	
	public Projeto() {	
	}

	public Projeto(Integer id, String titulo, String objetivo, String justificativa, List<Marco> marcos, Date dataInicio,
			Date dataTermino, LinhaPesquisa linhaPesquisa, Empregado coordenador, List<Empregado> responsaveisTecnicos,
			List<Empregado> participantes) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.objetivo = objetivo;
		this.justificativa = justificativa;
		this.marcos = marcos;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.linhaPesquisa = linhaPesquisa;
		this.coordenador = coordenador;
		this.responsaveisTecnicos = responsaveisTecnicos;
		this.participantes = participantes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public List<Marco> getMarcos() {
		return marcos;
	}

	public void setMarco(Marco marco) {
		this.marcos.add(marco);
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public LinhaPesquisa getLinhaPesquisa() {
		return linhaPesquisa;
	}

	public void setLinhaPesquisa(LinhaPesquisa linhaPesquisa) {
		this.linhaPesquisa = linhaPesquisa;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((dataTermino == null) ? 0 : dataTermino.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((justificativa == null) ? 0 : justificativa.hashCode());
		result = prime * result + ((marcos == null) ? 0 : marcos.hashCode());
		result = prime * result + ((objetivo == null) ? 0 : objetivo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Projeto other = (Projeto) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (justificativa == null) {
			if (other.justificativa != null)
				return false;
		} else if (!justificativa.equals(other.justificativa))
			return false;
		if (marcos == null) {
			if (other.marcos != null)
				return false;
		} else if (!marcos.equals(other.marcos))
			return false;
		if (objetivo == null) {
			if (other.objetivo != null)
				return false;
		} else if (!objetivo.equals(other.objetivo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
}
