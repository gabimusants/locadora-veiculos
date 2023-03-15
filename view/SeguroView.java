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

import controller.MainController;
import controller.SeguroController;

public class SeguroView extends JFrame {
	
	private static final long serialVersionUID = 2874364113045241551L;
	
	private JPanel contentPane;
	private JTextField textFieldCobertura;
	private JTextField textFieldTarifa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeguroView frame = new SeguroView();
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
	public SeguroView() {
		setTitle("Cadastrar Seguro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCobertura = new JLabel("Cobertura");
		lblCobertura.setBounds(12, 55, 83, 15);
		contentPane.add(lblCobertura);
		
		JLabel lblPercTarifa = new JLabel("Perc. Tarifa");
		lblPercTarifa.setBounds(12, 105, 83, 15);
		contentPane.add(lblPercTarifa);
		
		textFieldCobertura = new JTextField();
		textFieldCobertura.setBounds(120, 48, 318, 28);
		contentPane.add(textFieldCobertura);
		textFieldCobertura.setColumns(10);
		
		textFieldTarifa = new JTextField();
		textFieldTarifa.setColumns(10);
		textFieldTarifa.setBounds(120, 97, 318, 28);
		contentPane.add(textFieldTarifa);
		
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

		SeguroController controller = MainController.getSeguroController();
		
		String cobertura = textFieldCobertura.getText();
		
		double tarifaDouble;;
		
        try {
        	String percTarifa = textFieldTarifa.getText();
        	tarifaDouble = Double.parseDouble(percTarifa);
    	    
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, String.format("Campo 'Perc. Tarifa' deve ser um numero double"), "Entrada invalida", JOptionPane.INFORMATION_MESSAGE);
        	textFieldTarifa.setText("");
        	return;
        }

		controller.addSeguro(cobertura, tarifaDouble);
		
		JOptionPane.showMessageDialog(null,String.format("Seguro cadastrado com sucesso!"), "Cadastro de seguro", JOptionPane.INFORMATION_MESSAGE);
		
		limparForm();
	}
	
	private void limparForm() {
		textFieldCobertura.setText("");
		textFieldTarifa.setText("");
	}
}