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

import controller.ClienteJurController;
import controller.ExceptionEmail;
import controller.MainController;
import controller.TrataEmail;
import model.Endereco;

public class ClienteJurView extends JFrame {

	private static final long serialVersionUID = 4885636159494708551L;
	
	private JPanel contentPane;
	
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereco;
	private JTextField textFieldContato;
	private JTextField textFieldCNPJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteJurView frame = new ClienteJurView();
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
	public ClienteJurView() {
		setTitle("Cadastro de Pessoa Jurídica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 12, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(12, 41, 70, 15);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 70, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(12, 99, 70, 15);
		contentPane.add(lblEndereco);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(12, 128, 70, 15);
		contentPane.add(lblContato);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(12, 158, 70, 15);
		contentPane.add(lblCnpj);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(85, 8, 343, 28);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(85, 38, 343, 28);
		contentPane.add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(85, 67, 343, 28);
		contentPane.add(textFieldEmail);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(85, 96, 343, 28);
		contentPane.add(textFieldEndereco);
		
		textFieldContato = new JTextField();
		textFieldContato.setColumns(10);
		textFieldContato.setBounds(85, 124, 343, 28);
		contentPane.add(textFieldContato);
		
		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setColumns(10);
		textFieldCNPJ.setBounds(85, 153, 343, 28);
		contentPane.add(textFieldCNPJ);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(172, 233, 117, 25);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
	}
		
	protected void actionCadastrar() {

		ClienteJurController controller = MainController.getClienteJurController();
		
		try {
			TrataEmail.EmailRecebido(textFieldEmail.getText());
			
			String nome = textFieldNome.getText();
			String endereco = textFieldEndereco.getText();
			String telefone = textFieldTelefone.getText();
			String email = textFieldEmail.getText();
			String cnpj = textFieldCNPJ.getText();
			String contato = textFieldContato.getText();
			
			Endereco end = new Endereco(endereco, 1000);
			long telefoneLong = Long.parseLong(telefone);
			long cnpjLong = Long.parseLong(cnpj);
	
			controller.addClienteJur(nome, telefoneLong, end, cnpjLong, contato, email);
			
			JOptionPane.showMessageDialog(null,String.format("Cliente cadastrado com sucesso!"), "Cadastro de cliente", JOptionPane.INFORMATION_MESSAGE);
		} catch (ExceptionEmail e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			textFieldEmail.setText("");
		}
		
		limparForm();
	}
	
	private void limparForm() {
		textFieldNome.setText("");
		textFieldEndereco.setText("");
		textFieldTelefone.setText("");
		textFieldCNPJ.setText("");
		textFieldContato.setText("");
		textFieldEmail.setText("");
	}
}