package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MenuView extends JFrame{

	private static final long serialVersionUID = -7098009153183460579L;
	
	private JPanel frmLocadoraDeCarros;

	/**
	 * Create the application.
	 */
	public MenuView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLocadoraDeCarros = new JPanel();
		frmLocadoraDeCarros.setFont(new Font("Arial Black", Font.PLAIN, 12));
		setTitle("Locadora de carros - POO");
		this.setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setVerticalAlignment(SwingConstants.TOP);
		lblMenu.setBounds(184, 24, 125, 41);
		lblMenu.setFont(new Font("Cantarell Extra Bold", Font.BOLD, 25));
		getContentPane().add(lblMenu);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setBounds(20, 77, 190, 33);
		btnCadastrarCliente.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnCadastrarCliente);
		
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionTipoClienteView();
			}
		});
		
		JButton btnReserva = new JButton("Reserva");
		btnReserva.setBounds(230, 113, 190, 33);
		btnReserva.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnReserva);
		
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionReservaView();
			}
		});
		
		JButton btnCadastrarVeiculo = new JButton("Cadastrar Veículo");
		btnCadastrarVeiculo.setBounds(20, 113, 190, 33);
		btnCadastrarVeiculo.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnCadastrarVeiculo);
		
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionVeiculoView();
			}
		});
		
		JButton btnCadastrarServico = new JButton("Cadastrar Serviço");
		btnCadastrarServico.setBounds(20, 185, 190, 33);
		btnCadastrarServico.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnCadastrarServico);
		
		btnCadastrarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionServicoView();
			}
		});
		
		JButton btnCadastrarSeguro = new JButton("Cadastrar Seguro");
		btnCadastrarSeguro.setBounds(20, 149, 190, 33);
		btnCadastrarSeguro.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnCadastrarSeguro);
		
		btnCadastrarSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSeguroView();
			}
		});
		
		JButton btnCatalogo = new JButton("Catálogo");
		btnCatalogo.setBounds(230, 75, 190, 33);
		btnCatalogo.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnCatalogo);
		
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCatalogoView();
			}
		});
		
		JButton btnCadastrarCategoria = new JButton("Cadastrar Categoria");
		btnCadastrarCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrarCategoria.setBounds(20, 221, 190, 33);
		getContentPane().add(btnCadastrarCategoria);
		
		btnCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCategoriaView();
			}
		});
		
		JButton btnLocacao = new JButton("Locação");
		btnLocacao.setFont(new Font("Arial", Font.BOLD, 14));
		btnLocacao.setBounds(230, 149, 190, 33);
		getContentPane().add(btnLocacao);
		
		btnLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionLocacaoView();
			}
		});
		
		JButton btnDevolucao = new JButton("Devolução");
		btnDevolucao.setFont(new Font("Arial", Font.BOLD, 14));
		btnDevolucao.setBounds(230, 184, 190, 33);
		getContentPane().add(btnDevolucao);
		
		btnDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionDevolucaoView();
			}
		});
		
		JButton btnSair = new JButton("Sair do sistema");
		btnSair.setFont(new Font("Arial", Font.BOLD, 14));
		btnSair.setBounds(230, 220, 190, 33);
		getContentPane().add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSair();
			}
		});
	}
	
	private void actionReservaView() {
		TipoReservaView reservaView = new TipoReservaView();
		reservaView.setVisible(true);
	}
	
	private void actionCatalogoView() {
		CatalogoView catalogoView = new CatalogoView();
		catalogoView.setVisible(true);
	}
	
	private void actionTipoClienteView() {
		TipoClienteView tipoclienteView = new TipoClienteView();
		tipoclienteView.setVisible(true);
	}
	
	private void actionVeiculoView() {
		VeiculoView veiculoView = new VeiculoView();
		veiculoView.setVisible(true);
	}
	
	private void actionServicoView() {
		ServicoView servicoView = new ServicoView();
		servicoView.setVisible(true);
	}
	
	private void actionSeguroView() {
		SeguroView seguroView = new SeguroView();
		seguroView.setVisible(true);
	}
	
	private void actionCategoriaView() {
		CategoriaView categoriaView = new CategoriaView();
		categoriaView.setVisible(true);
	}
	
	private void actionLocacaoView() {
		LocacaoView locacaoView = new LocacaoView();
		locacaoView.setVisible(true);
	}
	
	private void actionDevolucaoView() {
		DevolucaoView devolucaoView = new DevolucaoView();
		devolucaoView.setVisible(true);
	}
	
	private void actionSair() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}