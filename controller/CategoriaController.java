package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import model.Categoria;
import model.ICategoria;

public class CategoriaController implements Serializable{

	private static final long serialVersionUID = -1856937418076658849L;
	
	private Map<String, ICategoria> categorias;
	
	public CategoriaController() {
		categorias = new TreeMap<>();
	}
	
	public void addCategoria(String nome, String descricao, double tarifaDiaria) {
		categorias.put(nome + " (Tarifa Diaria: " + tarifaDiaria + ")", new Categoria(nome, descricao, tarifaDiaria));
		MainController.save();
	}
	
	public Set<String> getListaCategorias() {
		return categorias.keySet();
	}
	
	public DefaultComboBoxModel<ICategoria> getDefaultComboBoxModel() {
		DefaultComboBoxModel<ICategoria> cat = new DefaultComboBoxModel<>();
		
		for (ICategoria categoria : categorias.values()) {
			cat.addElement(categoria);
		}
		return cat;
	}
}