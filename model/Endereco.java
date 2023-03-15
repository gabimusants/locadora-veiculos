package model;

import java.io.Serializable;

public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 8961716448558676424L;
	
	private String logradouro;
	private int numero;
	private String cidade;

	public Endereco(String logradouro, int numero) {
		this.logradouro = logradouro;
		this.numero = numero;
	}
	
	public String getRua() {
		return logradouro;
	}
	
	public void setRua(String rua) {
		this.logradouro = rua;
	}
	
	public long getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}