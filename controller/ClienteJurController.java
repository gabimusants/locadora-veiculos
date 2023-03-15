package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import model.Endereco;
import model.IPessoaJuridica;
import model.PessoaJuridica;

public class ClienteJurController implements Serializable{
	
	private static final long serialVersionUID = 8717505512626610135L;
	
	private Map<String, IPessoaJuridica> clientesJur;

	public ClienteJurController() {
		clientesJur = new TreeMap<>();
	}

	public void addClienteJur(String nome, Long telefone, Endereco endereco, Long cnpj, String contato, String email) {
		
		PessoaJuridica pessoa = new PessoaJuridica(nome, telefone, endereco, cnpj, contato);
		pessoa.setEmail(email);
		clientesJur.put(nome, pessoa);
		MainController.save();
	}

	public Set<String> getListaClientesJur() {
		return clientesJur.keySet();
	}
	
	public DefaultComboBoxModel<IPessoaJuridica> getDefaultComboBoxModel() {
		DefaultComboBoxModel<IPessoaJuridica> pes = new DefaultComboBoxModel<>();
		
		for (IPessoaJuridica pessoa : clientesJur.values()) {
			pes.addElement(pessoa);
		}
		return pes;
	}
}