package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import controller.CategoriaController;
import controller.MainController;
import controller.SeguroController;
import controller.ServicoController;
import controller.VeiculosController;

import java.util.Vector;

public class CatalogoView extends JFrame {
	
	private static final long serialVersionUID = 4675757154208436630L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoView frame = new CatalogoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public CatalogoView() {
		VeiculosController veiculosController = MainController.getVeiculosController();
		SeguroController seguroController = MainController.getSeguroController();
		ServicoController servicoController = MainController.getServicoController();
		CategoriaController categoriaController = MainController.getCategoriaController();
		
		seguroController.addSeguroPadrao();
		servicoController.addServicoPadrao();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("CATÁLOGO");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeguros = new JLabel("Seguros");
		lblSeguros.setBounds(12, 13, 70, 15);
		contentPane.add(lblSeguros);
		
		JLabel lblServico = new JLabel("Serviços");
		lblServico.setBounds(12, 55, 70, 15);
		contentPane.add(lblServico);
		
		JLabel lblVeiculos = new JLabel("Veiculos");
		lblVeiculos.setBounds(12, 96, 90, 15);
		contentPane.add(lblVeiculos);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setBounds(12, 139, 90, 15);
		contentPane.add(lblCategorias);
		
		JComboBox<String> comboBoxSeguros = new JComboBox<String>(new Vector<String>(seguroController.getListaSeguros()));
		comboBoxSeguros.setBounds(100, 7, 338, 28);
		contentPane.add(comboBoxSeguros);
		
		JComboBox<String> comboBoxServico = new JComboBox<String>(new Vector<String>(servicoController.getListaServicos()));
		comboBoxServico.setBounds(100, 47, 338, 28);
		contentPane.add(comboBoxServico);
		
		JComboBox<String> comboBoxVeiculo = new JComboBox<String>(new Vector<String>(veiculosController.getListaVeiculos()));
		comboBoxVeiculo.setBounds(100, 91, 338, 28);
		contentPane.add(comboBoxVeiculo);
		
		JComboBox<String> comboBoxCategorias = new JComboBox<String>(new Vector<String>(categoriaController.getListaCategorias()));
		comboBoxCategorias.setBounds(100, 133, 338, 28);
		contentPane.add(comboBoxCategorias);
	}
}