package model;

import java.io.Serializable;

public class Seguro implements ISeguro, Serializable {
	
	private static final long serialVersionUID = -9165254208089858196L;
	
	private String cobertura;
	private double percTarifa;
	
	public Seguro(String cobertura, double percTarifa) {
		this.cobertura = cobertura;
		this.percTarifa = percTarifa;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	
	@Override
	public String getCobertura() {
		return cobertura;
	}

	public void setPercTarifa(double percTarifa) {
		this.percTarifa = percTarifa;
	}

	@Override
	public double getPercTarifa() {
		return percTarifa;
	}
	
	@Override
	public String toString() {
		return this.cobertura;
	}
}