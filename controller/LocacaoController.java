package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import model.IVeiculo;
import model.Locacao;
import model.Reserva;

public class LocacaoController implements Serializable {
	
	private static final long serialVersionUID = 5436555559920290666L;
	
	private Map<String, Locacao> locacoes;
	
	public LocacaoController() {
		locacoes = new TreeMap<>();
	}
	
	public void addLocacao(int kmInicial, IVeiculo veiculo, Reserva reserva) {
		Locacao locacao = new Locacao(kmInicial, veiculo, reserva);
		locacoes.put(reserva.getCliente().getNome() + " (Veiculo: " + locacao.getVeiculo() + ")", locacao);
		MainController.save();
	}
	
	public Set<String> getListaLocacao() {
		return locacoes.keySet();
	}
	
	public DefaultComboBoxModel<Locacao> getDefaultComboBoxModel() {
		DefaultComboBoxModel<Locacao> loc = new DefaultComboBoxModel<>();
		
		for (Locacao locacao : locacoes.values()) {
			loc.addElement(locacao);
		}
		return loc;
	}
}