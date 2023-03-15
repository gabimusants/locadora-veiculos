package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva implements Serializable {
	
	private static final long serialVersionUID = -2794007571026034546L;
	
	private final String numero = java.util.UUID.randomUUID().toString();;
	private final double valorTarifa;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	private final ICategoria categoria;
	private final IPessoa cliente;

	private ArrayList<ISeguro> seguros = new ArrayList<ISeguro>();
	private ArrayList<IServico> servicos = new ArrayList<IServico>();

	public Reserva(ICategoria categoria, IPessoa cliente) {
		//this.dataInicio = new Date();
		this.categoria = categoria;
		this.valorTarifa = categoria.getTarifaDiaria();
		this.cliente = cliente;
	}

	public void addSeguro(ISeguro seg) {
		seguros.add(seg);
	}
	
	public void addServico(IServico ser) {
		servicos.add(ser);
	}
	
	public ArrayList<ISeguro> getSeguro() {
		return seguros;
	}

	public void setSeguro(ArrayList<ISeguro> seguro) {
		this.seguros = seguro;
	}

	public ArrayList<IServico> getServico() {
		return servicos;
	}

	public void setServico(ArrayList<IServico> servico) {
		this.servicos = servico;
	}

	public String getNumero() {
		return numero;
	}

	public ICategoria getCategoria() {
		return categoria;
	}
	
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}
	
	public double getValorTarifa() {
		return valorTarifa;
	}

	public IPessoa getCliente() {
		return cliente;
	}
	
	@Override
	public String toString() {
		return cliente.getNome() + " (Categoria: " + categoria.getNome() + ")";
	}
}