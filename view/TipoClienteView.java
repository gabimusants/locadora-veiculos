package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TipoClienteView extends JFrame {
	
	private static final long serialVersionUID = -3072806496542568334L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipoClienteView frame = new TipoClienteView();
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
	public TipoClienteView() {
		setTitle("CLIENTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPessoaFisica = new JButton("Pessoa Física");
		btnPessoaFisica.setBounds(150, 102, 142, 25);
		contentPane.add(btnPessoaFisica);
		
		btnPessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionClienteView();
			}
		});
		
		JButton btnPessoaJuridica = new JButton("Pessoa Jurídica");
		btnPessoaJuridica.setBounds(150, 139, 142, 25);
		contentPane.add(btnPessoaJuridica);
		
		btnPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionClienteJurView();
			}
		});
		
		JLabel lblCadastro = new JLabel("CADASTRO");
		lblCadastro.setFont(new Font("Arial", Font.BOLD, 16));
		lblCadastro.setBounds(175, 41, 94, 25);
		contentPane.add(lblCadastro);
	}
	
	private void actionClienteView() {
		ClienteView clienteView = new ClienteView();
		clienteView.setVisible(true);
	}
	
	private void actionClienteJurView() {
		ClienteJurView clienteJurView = new ClienteJurView();
		clienteJurView.setVisible(true);
	}
}
