package model;

import java.time.temporal.ChronoUnit;
import java.io.Serializable;
import java.time.LocalDate;

public class Locacao implements Serializable { 
	
	private static final long serialVersionUID = -6290844141343568180L;
	
	private final LocalDate dataHoraRetirada = LocalDate.now();
	private final int kmInicial;
	
	private IVeiculo veiculo;
    private Reserva reserva;
    private Devolucao devolucao;
    
	public Locacao(int kmInicial, IVeiculo veiculo, Reserva reserva) {
		this.kmInicial = kmInicial;
		this.veiculo = veiculo;
		this.reserva = reserva;
	}
	
	public LocalDate getDataHoraRetirada() {
		return dataHoraRetirada;
	}
	
	public long getKmInicial() {
		return kmInicial;
	}
	
	public IVeiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(IVeiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Reserva getReserva() {
		return reserva;
	}
	
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Devolucao getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}
	
	public long getTotalDiarias() {
		long dias = ChronoUnit.DAYS.between(reserva.getDataInicio(), reserva.getDataFim());
		return dias;
	}
	
	public double getTotalSeguros() {
		double valorTotalSeg = 0;
		for (ISeguro seg : getReserva().getSeguro()) {
			if(seg == null)
				return valorTotalSeg;
			
			valorTotalSeg += seg.getPercTarifa() * getTotalDiarias() * getReserva().getValorTarifa(); 
		}
		return valorTotalSeg;
	}
	
	public double getTotalServicos() {
		double valorTotalServ = 0;
		for (IServico serv : getReserva().getServico()) {
			if(serv == null)
				return valorTotalServ;
			if(serv.getTipoTarifacao() == ETipoTarifacao.UNICA)
				valorTotalServ += serv.getPreco();
			
			valorTotalServ += getTotalDiarias() * serv.getPreco();
		}
		return valorTotalServ;
	}
	
	public double getTotalLocacao() {
		double valorTotalLocacao = 0;
		valorTotalLocacao = (getReserva().getValorTarifa() * getTotalDiarias()) + getTotalSeguros() + getTotalServicos();
		return valorTotalLocacao;
	}
	
	public String listar() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------------------------ NOTA ------------------------------------------");
		sb.append("\n");
		sb.append("Numero da reserva: " + getReserva().getNumero());
		sb.append("\n");
		sb.append("Nome do cliente: " + getReserva().getCliente().getNome());
		sb.append("\n");
		sb.append("Data de devolucao: " + devolucao.getDataHoraDevolucao());
		sb.append("\n");
		sb.append("Quilometragem Inicial: " + getKmInicial());
		sb.append("\n");
		sb.append("Quilometragem Final: " + devolucao.getKmFinal());
		sb.append("\n");
		sb.append("Categoria do Veiculo: " + getReserva().getCategoria().getNome());
		sb.append("\n");
		sb.append("Modelo do Veiculo: " + getVeiculo().getModelo());
		sb.append("\n");
		
		for (ISeguro seg : getReserva().getSeguro()) {
			if(seg != null) {
				sb.append("Seguro contratado: " + seg.getCobertura());
				sb.append("\n");
			} else {
				sb.append("Nenhum seguro contratado!");
				sb.append("\n");
			}
		}
		
		for (IServico serv : getReserva().getServico()) {
			if(serv != null) {
				sb.append("Servico contratado: " + serv.getDescricao());
				sb.append("\n");
			} else {
				sb.append("Nenhum servico contratado!");
				sb.append("\n");
			}
		}
		
		sb.append("Tipo do pagamento: " + devolucao.getFormaPgto());
		sb.append("\n");
		sb.append("Valor total: " + getTotalLocacao());
		sb.append("\n");
		return sb.toString();
	}
	
	public String toString() {
		return this.reserva.getCliente().getNome() + " (Categoria: " + this.reserva.getCategoria().getNome() + ")";
	}
}