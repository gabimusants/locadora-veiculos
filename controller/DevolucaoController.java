package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Devolucao;
import model.ETipoPagamento;
import model.Locacao;

public class DevolucaoController implements Serializable {

	private static final long serialVersionUID = 7642377039548415669L;
	private Map<String, Devolucao> devolucoes;
	
	public DevolucaoController() {
		devolucoes = new TreeMap<>();
	}
	
	public void addDevolucao(int kmFinal, ETipoPagamento formaPgto, Locacao locacao) {
		Devolucao devolucao = new Devolucao(kmFinal, formaPgto);
		locacao.setDevolucao(devolucao);
		devolucoes.put(devolucao.getDataHoraDevolucao() + "", devolucao);
		MainController.save();
	}
	
	public String geraNotaFiscal(Locacao locacao) {
		String nota = locacao.listar();
		return nota;
	}
	
	public Set<String> getListaDevolucao() {
		return devolucoes.keySet();
	}
}