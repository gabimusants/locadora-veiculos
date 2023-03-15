package model;

import java.io.Serializable;

public abstract class Pessoa implements IPessoa, Serializable {
	
	private static final long serialVersionUID = -5781922093659298216L;
	
	private String nome;
	private long telefone;
	private String email;
	private Endereco endereco;
	private String contato;
	
	public Pessoa(String nome, long telefone, Endereco endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Pessoa(String nome, long telefone, Endereco endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	//TODO throws EmailException
	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
}