package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import model.ISeguro;
import model.Seguro;

public class SeguroController implements Serializable {
	
	private static final long serialVersionUID = -5892478386496874255L;
	
	private Map<String, Seguro> seguros;
	
	public SeguroController() {
		seguros = new TreeMap<>();
	}
	
	public void addSeguroPadrao() {
		seguros.put("Nenhum" + " (Perc. Tarifa: 0.0)", new Seguro("Nenhum", 0.0));
		MainController.save();
	}
	
	public void addSeguro(String cobertura, double percTarifa) {
		seguros.put(cobertura + " (Perc. Tarifa: " + percTarifa + ")", new Seguro(cobertura, percTarifa));
		MainController.save();
	}
	
	public Set<String> getListaSeguros() {
		return seguros.keySet();
	}
	
	public DefaultComboBoxModel<ISeguro> getDefaultComboBoxModel() {
		DefaultComboBoxModel<ISeguro> seg = new DefaultComboBoxModel<>();
		
		for (ISeguro seguro : seguros.values()) {
			seg.addElement(seguro);
		}
		
		return seg;
	}
}