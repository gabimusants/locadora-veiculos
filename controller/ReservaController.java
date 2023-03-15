package controller;

import java.io.Serializable;

import java.time.LocalDate;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import model.ICategoria;
import model.IPessoa;
import model.ISeguro;
import model.IServico;
import model.Reserva;

public class ReservaController implements Serializable {
	
	private static final long serialVersionUID = -1521226412863872317L;
	
	private Map<String, Reserva> reservas;
	
	public ReservaController() {
		reservas = new TreeMap<>();
	}
	
	public void addReserva(ICategoria categoria, IPessoa cliente, ISeguro seguro, IServico servico, LocalDate dataInicio, LocalDate dataFinal) {
		Reserva reserva = new Reserva(categoria, cliente);
		reserva.addSeguro(seguro);
		reserva.addServico(servico);
		reserva.setDataInicio(dataInicio);
		reserva.setDataFim(dataFinal);
		reservas.put(reserva.getCliente().getNome() + " (Categoria: " + reserva.getCategoria() + ")", reserva);
		MainController.save();
	}
	
	public Set<String> getListaReservas() {
		return reservas.keySet();
	}
	
	public DefaultComboBoxModel<Reserva> getDefaultComboBoxModel() {
		DefaultComboBoxModel<Reserva> res = new DefaultComboBoxModel<>();
		
		for (Reserva reserva : reservas.values()) {
			res.addElement(reserva);
		}
		return res;
	}
}