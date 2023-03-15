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

import controller.ClienteController;
import controller.ExceptionEmail;
import controller.MainController;
import controller.TrataEmail;

import model.Endereco;

public class ClienteView extends JFrame {

	private static final long serialVersionUID = 4234804038231881300L;
	
	private JPanel contentPane;
	
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEndereco;
	private JTextField textFieldCPF;
	private JTextField textFieldCNH;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            	System.err.println(ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView frame = new ClienteView();
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
	public ClienteView() {
		setTitle("Cadastro de Pessoa Física");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 18, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(12, 47, 70, 15);
		contentPane.add(lblTelefone);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(12, 75, 70, 15);
		contentPane.add(lblEndereco);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(12, 102, 70, 15);
		contentPane.add(lblCPF);
		
		JLabel lblCNH = new JLabel("CNH");
		lblCNH.setBounds(12, 130, 70, 15);
		contentPane.add(lblCNH);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(100, 9, 328, 28);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(100, 38, 328, 28);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(100, 67, 328, 28);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(100, 96, 328, 28);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldCNH = new JTextField();
		textFieldCNH.setBounds(100, 125, 328, 28);
		contentPane.add(textFieldCNH);
		textFieldCNH.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(172, 233, 117, 25);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 160, 70, 15);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(100, 154, 328, 28);
		contentPane.add(textFieldEmail);
	}
	
	protected void actionCadastrar() {

		ClienteController controller = MainController.getClienteController();
		try {
			TrataEmail.EmailRecebido(textFieldEmail.getText());
			
			String nome = textFieldNome.getText();
			String endereco = textFieldEndereco.getText();
			String telefone = textFieldTelefone.getText();
			String cpf = textFieldCPF.getText();
			String cnh = textFieldCNH.getText();
			String email = textFieldEmail.getText();
			
			Endereco end = new Endereco(endereco, 1000);
			long telefoneLong = Long.parseLong(telefone);
			long cpfLong = Long.parseLong(cpf);
			long cnhLong = Long.parseLong(cnh);
	
			controller.addCliente(nome, telefoneLong, end, cpfLong, cnhLong, email);
			
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
		textFieldCPF.setText("");
		textFieldCNH.setText("");
		textFieldEmail.setText("");
	}
}