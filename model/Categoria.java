package model;

import java.io.Serializable;

public class Categoria implements ICategoria, Serializable {
	
	private static final long serialVersionUID = 5273198899295012178L;
	
	private String nome;
	private String descricao;
	private double tarifaDiaria;
	
	public Categoria(String nome, String descricao, double tarifaDiaria) {
		this.nome = nome;
		this.descricao = descricao;
		this.tarifaDiaria = tarifaDiaria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getNome() {
		return nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String getDescricao() {
		return descricao;
	}

	public void setTarifaDiaria(double tarifaDiaria) {
		this.tarifaDiaria = tarifaDiaria;
	}
	
	@Override
	public double getTarifaDiaria() {
		return tarifaDiaria;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}