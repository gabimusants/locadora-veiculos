package model;

public class PessoaFisica extends Pessoa implements IPessoaFisica {
	
	private static final long serialVersionUID = 2791566462687946257L;
	
	private final long CPF;
	private final long CNH;

	public PessoaFisica(String nome, long telefone, Endereco endereco, long cPF, long cNH) {
		super(nome, telefone, endereco);
		CPF = cPF;
		CNH = cNH;
	}

	@Override
	public long getCPF() {
		return CPF;
	}
	
	@Override
	public long getCNH() {
		return CNH;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}