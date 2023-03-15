package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import model.ETipoTarifacao;
import model.IServico;
import model.Servico;

public class ServicoController implements Serializable{
	
	private static final long serialVersionUID = 5527347447049904941L;
	
	private Map<String, Servico> servicos;
	
	public ServicoController() {
		servicos = new TreeMap<>();
	}
	
	public void addServicoPadrao() {
		servicos.put("Nenhum" + " (Perc. Tarifa: 0.0)", new Servico(ETipoTarifacao.UNICA, "Nenhum", 0.0));
		MainController.save();
	}
	
	public void addServico(ETipoTarifacao tipoTarifacao, String descricao, double preco) {
		servicos.put(descricao + " (Preco: "+ preco +" (" + tipoTarifacao + "))", new Servico(tipoTarifacao, descricao, preco));	//insere novo objeto servico no map
		MainController.save();
	}
	
	public Set<String> getListaServicos() {
		return servicos.keySet();
	}
	
	public DefaultComboBoxModel<IServico> getDefaultComboBoxModel() {
		DefaultComboBoxModel<IServico> serv = new DefaultComboBoxModel<>();
		
		for (IServico servico : servicos.values()) {
			serv.addElement(servico);
		}
		return serv;
	}
}