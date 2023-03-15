package model;

public class PessoaJuridica extends Pessoa implements IPessoaJuridica {
	
	private static final long serialVersionUID = -367169721093557918L;
	
	private final long CNPJ;
	private String contato;
	
	public PessoaJuridica(String nome, long telefone, Endereco endereco, long cNPJ, String contato) {
		super(nome, telefone, endereco);
		CNPJ = cNPJ;
		this.contato = contato;
	}
	
	public PessoaJuridica(String nome, long telefone, Endereco endereco, long cNPJ, String contato, String email) {
		super(nome, telefone, endereco, email);
		CNPJ = cNPJ;
		this.contato = contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public String getContato() {
		return contato;
	}

	@Override
	public long getCNPJ() {
		return CNPJ;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}