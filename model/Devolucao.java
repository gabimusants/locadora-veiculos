package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Devolucao implements Serializable {
	
	private static final long serialVersionUID = -7160692577849786106L;
	
	private final LocalDate dataHoraDevolucao = LocalDate.now();
	private final int kmFinal;
	private final ETipoPagamento formaPgto;
	private double valorPago;
	
	public Devolucao(int kmFinal, ETipoPagamento formaPgto) {
		this.kmFinal = kmFinal;
		this.formaPgto = formaPgto;
	}

	public LocalDate getDataHoraDevolucao() {
		return dataHoraDevolucao;
	}

	public long getKmFinal() {
		return kmFinal;
	}
	
	public double getValorPago() {
		return valorPago;
	}
	
	public ETipoPagamento getFormaPgto() {
		return formaPgto;
	}
}