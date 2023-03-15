package model;

import java.io.Serializable;

public class Veiculo implements IVeiculo, Serializable {
	
	private static final long serialVersionUID = -8020031403117895509L;
	
	private final String placa;
	private final String modelo;
	private final int ano;
	private String cor;
	private EStatusVeiculo status;
	
	public Veiculo(String placa, String modelo, String cor, int ano) {
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
	}

	@Override
	public String getPlaca() {
		return placa;
	}

	@Override
	public String getModelo() {
		return modelo;
	}
	
	@Override
	public int getAno() {
		return ano;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String getCor() {
		return cor;
	}

	@Override
	public EStatusVeiculo getStatus() {
		return status;
	}

	@Override
	public void setStatus(EStatusVeiculo status) {
		// TODO Auto-generated method stub
		this.status = status;
		
	}
	
	@Override
	public String toString() {
		return this.modelo + " (Placa: " + this.placa + ")";
	}
}