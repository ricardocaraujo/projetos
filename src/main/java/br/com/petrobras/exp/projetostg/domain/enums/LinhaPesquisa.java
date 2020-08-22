package br.com.petrobras.exp.projetostg.domain.enums;

public enum LinhaPesquisa {
	
	IMAGEAMENTO(1, "Imageamento Geofísico"),
	INVERSÃO(2, "Inversão e Atributos Sísmicos"),
	CONSTRUTOR(3, "Construção de Modelos e Análise de Velocidades"),
	APRENDIZADO(4, "Aprendizado de Máquina"),
	ATENUAÇÃO(5, "Atenuação de Múltiplas");
	
	private int cod;
	
	private String nome;
	
	private LinhaPesquisa(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	
}
