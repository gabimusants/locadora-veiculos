package model;

import java.io.Serializable;

public class Servico implements IServico, Serializable {
	
	private static final long serialVersionUID = 7458392506749926341L;
	
	private ETipoTarifacao tipoTarifacao;
	private String descricao;
	private double preco;
	
	public Servico(ETipoTarifacao tipoTarifacao, String descricao, double preco) {
		this.tipoTarifacao = tipoTarifacao;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	@Override
	public ETipoTarifacao getTipoTarifacao() {
		return tipoTarifacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public double getPreco() {
		return preco;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}
}