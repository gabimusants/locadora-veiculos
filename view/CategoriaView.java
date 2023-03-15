package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.CategoriaController;
import controller.MainController;

public class CategoriaView extends JFrame {

	private static final long serialVersionUID = -6413586146501224567L;
	
	private JPanel contentPane;
	
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JTextField textFieldTarifaDiaria;
	
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoriaView frame = new CategoriaView();
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
	public CategoriaView() {
		setTitle("Cadastrar Categoria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 29, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(12, 78, 70, 15);
		contentPane.add(lblDescricao);
		
		JLabel lblTarifaDiaria = new JLabel("Tarifa Diária");
		lblTarifaDiaria.setBounds(12, 125, 93, 15);
		contentPane.add(lblTarifaDiaria);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(120, 22, 318, 28);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(120, 72, 318, 28);
		contentPane.add(textFieldDescricao);
		
		textFieldTarifaDiaria = new JTextField();
		textFieldTarifaDiaria.setColumns(10);
		textFieldTarifaDiaria.setBounds(120, 119, 318, 28);
		contentPane.add(textFieldTarifaDiaria);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(175, 233, 117, 25);
		contentPane.add(btnCadastrar);
	
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
	}
	
	protected void actionCadastrar() {

		CategoriaController controller = MainController.getCategoriaController();
		
		String nome = textFieldNome.getText();
		String descricao = textFieldDescricao.getText();
		String tarifaDiaria = textFieldTarifaDiaria.getText();
		
		double tarifaDouble = Double.parseDouble(tarifaDiaria);

		controller.addCategoria(nome, descricao, tarifaDouble);
		
		JOptionPane.showMessageDialog(null,String.format("Categoria cadastrada com sucesso!"), "Cadastro de categoria", JOptionPane.INFORMATION_MESSAGE);
		
		limparForm();
	}
	
	private void limparForm() {
		textFieldNome.setText("");
		textFieldDescricao.setText("");
		textFieldTarifaDiaria.setText("");
	}
}