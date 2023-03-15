package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import model.Veiculo;
import model.IVeiculo;

public class VeiculosController implements Serializable {

	private static final long serialVersionUID = -6451823342484917813L;
	
	private Map<String, Veiculo> veiculos;

	public VeiculosController() {
		veiculos = new TreeMap<>();
	}
	
	public void addVeiculo(String placa, String modelo, String cor, int ano) {
		veiculos.put(modelo + " (Cor: " + cor + ", Ano: " + ano + ")", new Veiculo(placa, modelo, cor, ano));
		MainController.save();
	}
	
	public Set<String> getListaVeiculos() {
		return veiculos.keySet();
	}
	
	public DefaultComboBoxModel<IVeiculo> getDefaultComboBoxModel() {
		DefaultComboBoxModel<IVeiculo> veic = new DefaultComboBoxModel<>();
		
		for (IVeiculo veiculo : veiculos.values()) {
			veic.addElement(veiculo);
		}
		return veic;
	}
}