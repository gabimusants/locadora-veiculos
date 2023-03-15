package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import model.Endereco;
import model.IPessoaFisica;
import model.PessoaFisica;

public class ClienteController implements Serializable {
	
	private static final long serialVersionUID = 8854621977014694052L;
	
	private Map<String, IPessoaFisica> clientesFis;

	public ClienteController() {
		clientesFis = new TreeMap<>();
	}

	public void addCliente(String nome, Long telefone, Endereco endereco, Long cpf, Long cnh, String email) {
		PessoaFisica pessoa = new PessoaFisica(nome, telefone, endereco, cpf, cnh);
		pessoa.setEmail(email);
		clientesFis.put(nome, pessoa);
		MainController.save();
	}
	
	public Set<String> getListaClientes() {
		return clientesFis.keySet();
	}
	
	public DefaultComboBoxModel<IPessoaFisica> getDefaultComboBoxModel() {
		DefaultComboBoxModel<IPessoaFisica> pes = new DefaultComboBoxModel<>();
		
		for (IPessoaFisica pessoa : clientesFis.values()) {
			pes.addElement(pessoa);
		}
		return pes;
	}
}