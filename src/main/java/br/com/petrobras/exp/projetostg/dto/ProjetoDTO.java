package br.com.petrobras.exp.projetostg.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.petrobras.exp.projetostg.domain.Marco;
import br.com.petrobras.exp.projetostg.domain.Projeto;
import br.com.petrobras.exp.projetostg.domain.enums.LinhaPesquisa;

public class ProjetoDTO {
	
	private String titulo;
	
	private String objetivo;
	
	private String justificativa;
	
	private List<Marco> marcos;
	
	@JsonFormat(pattern="dd/MM/yyy")
	private Date dataInicio;
	
	@JsonFormat(pattern="dd/MM/yyy")
	private Date dataTermino;
	
	private LinhaPesquisa linhaPesquisa;

	public ProjetoDTO() {
		
	}
	
	public ProjetoDTO(Projeto projeto) {
		super();
		this.titulo = projeto.getTitulo();
		this.objetivo = projeto.getObjetivo();
		this.justificativa = projeto.getJustificativa();
		this.marcos = projeto.getMarcos();
		this.dataInicio = projeto.getDataInicio();
		this.dataTermino = projeto.getDataTermino();
		this.linhaPesquisa = projeto.getLinhaPesquisa();
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
	
}
