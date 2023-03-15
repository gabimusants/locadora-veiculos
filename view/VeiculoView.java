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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import controller.MainController;
import controller.VeiculosController;

import model.EStatusVeiculo;

public class VeiculoView extends JFrame {
	
	private static final long serialVersionUID = 3326127610190746700L;
	
	private JPanel contentPane;
	private JTextField textFieldPlaca;
	private JTextField textFieldModelo;
	private JTextField textFieldCor;
	private JTextField textFieldAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeiculoView frame = new VeiculoView();
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
	public VeiculoView() {
		setTitle("Cadastrar Veículo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(12, 12, 70, 15);
		contentPane.add(lblPlaca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 43, 70, 15);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(12, 70, 70, 15);
		contentPane.add(lblCor);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(12, 97, 70, 15);
		contentPane.add(lblAno);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(12, 124, 70, 15);
		contentPane.add(lblStatus);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setBounds(80, 10, 348, 24);
		contentPane.add(textFieldPlaca);
		textFieldPlaca.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		textFieldModelo.setBounds(80, 37, 348, 24);
		contentPane.add(textFieldModelo);
		
		textFieldCor = new JTextField();
		textFieldCor.setColumns(10);
		textFieldCor.setBounds(80, 66, 348, 24);
		contentPane.add(textFieldCor);
		
		textFieldAno = new JTextField();
		textFieldAno.setColumns(10);
		textFieldAno.setBounds(80, 93, 348, 24);
		contentPane.add(textFieldAno);
		
		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(EStatusVeiculo.values()));
		comboBoxStatus.setBounds(80, 119, 348, 24);
		contentPane.add(comboBoxStatus);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(175, 233, 117, 25);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
	}
	
	protected void actionCadastrar() {

		VeiculosController controller = MainController.getVeiculosController();
		
		String placa = textFieldPlaca.getText();
		String modelo = textFieldModelo.getText();
		String cor = textFieldCor.getText();
	
		int anoInt;
		
        try {
        	String ano = textFieldAno.getText();
    	    anoInt = Integer.parseInt(ano);
    	    
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, String.format("Campo 'Ano' deve ser um número inteiro"), "Entrada invalida", JOptionPane.INFORMATION_MESSAGE);
        	textFieldAno.setText("");
        	return;
        }

		controller.addVeiculo(placa, modelo, cor, anoInt);
		
		JOptionPane.showMessageDialog(null,String.format("Veiculo cadastrado com sucesso!"), "Cadastro de veículo", JOptionPane.INFORMATION_MESSAGE);
		
		limparForm();
	}
	
	private void limparForm() {
		textFieldPlaca.setText("");
		textFieldModelo.setText("");
		textFieldCor.setText("");
		textFieldAno.setText("");
	}
}
