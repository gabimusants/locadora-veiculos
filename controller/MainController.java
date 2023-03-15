package controller;

import java.io.Serializable;

import persistence.Serializacao;

public class MainController implements Serializable {

	private static final long serialVersionUID = 6341528978400871936L;

	private static MainController instance;
	
	// controladores da aplicacao
	private DevolucaoController devolucaoController;
	private LocacaoController locacaoController;
	private VeiculosController veiculosController;
	private ReservaController reservaController;
	private ClienteController clienteController;
	private ClienteJurController clienteJurController;
	private SeguroController seguroController;
	private ServicoController servicoController;
	private CategoriaController categoriaController;
	
	private MainController() {	
		devolucaoController = new DevolucaoController();
		locacaoController = new LocacaoController();
		veiculosController = new VeiculosController();
		reservaController = new ReservaController();
		clienteJurController = new ClienteJurController();
		clienteController = new ClienteController();
		seguroController = new SeguroController();
		servicoController = new ServicoController();
		categoriaController = new CategoriaController();
	}
	
	public static MainController getInstance() {
		return instance;
	}
	
	public static VeiculosController getVeiculosController() {
		return instance.veiculosController;
	}
	
	public static ReservaController getReservaController() {
		return instance.reservaController;
	}
	
	public static ClienteController getClienteController() {
		return instance.clienteController;
	}
	
	public static ClienteJurController getClienteJurController() {
		return instance.clienteJurController;
	}
	
	public static SeguroController getSeguroController() {
		return instance.seguroController;
	}
	
	public static ServicoController getServicoController() {
		return instance.servicoController;
	}
	
	public static CategoriaController getCategoriaController() {
		return instance.categoriaController;
	}
	
	public static LocacaoController getLocacaoController() {
		return instance.locacaoController;
	}
	
	public static DevolucaoController getDevolucaoController() {
		return instance.devolucaoController;
	}
	
	public static void load() {

		instance = Serializacao.readFile();
		if (instance == null) {
			instance = new MainController();
		}
	}

	public static void save() {
		Serializacao.writeFile(instance);
	}
}