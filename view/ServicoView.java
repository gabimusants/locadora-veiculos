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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import controller.MainController;
import controller.ServicoController;

import model.ETipoTarifacao;

public class ServicoView extends JFrame {
	
	private static final long serialVersionUID = 8218861182235507048L;
	
	private JPanel contentPane;
	private JTextField textFieldDesc;
	private JTextField textFieldPreco;
	private ETipoTarifacao tipoTarifa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicoView frame = new ServicoView();
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
	public ServicoView() {
		setTitle("Cadastrar Serviço");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(12, 28, 70, 15);
		contentPane.add(lblDescricao);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(12, 77, 70, 15);
		contentPane.add(lblPreco);
		
		JLabel lblTipoTarifacao = new JLabel("Tipo Tarifação");
		lblTipoTarifacao.setBounds(12, 124, 107, 15);
		contentPane.add(lblTipoTarifacao);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setBounds(135, 22, 303, 28);
		contentPane.add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(135, 72, 303, 28);
		contentPane.add(textFieldPreco);
		
		JComboBox comboBoxTipoTarif = new JComboBox();
		comboBoxTipoTarif.setModel(new DefaultComboBoxModel(ETipoTarifacao.values()));
		comboBoxTipoTarif.setBounds(135, 119, 301, 25);
		contentPane.add(comboBoxTipoTarif);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(175, 233, 117, 25);
		contentPane.add(btnCadastrar);
		
		tipoTarifa = (ETipoTarifacao) comboBoxTipoTarif.getSelectedItem();
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
	}
	
	protected void actionCadastrar() {

		ServicoController controller = MainController.getServicoController();
	
		String descricao = textFieldDesc.getText();
		
		
		double precoDouble;
		
        try {
        	String preco = textFieldPreco.getText();
        	precoDouble = Double.parseDouble(preco);
    	    
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, String.format("Campo 'Preco' deve ser um numero double"), "Entrada invalida", JOptionPane.INFORMATION_MESSAGE);
        	textFieldPreco.setText("");
        	return;
        }
		 
		controller.addServico(tipoTarifa, descricao, precoDouble);
		
		JOptionPane.showMessageDialog(null,String.format("Serviço cadastrado com sucesso!"), "Cadastro de serviço", JOptionPane.INFORMATION_MESSAGE);
		
		limparForm();
	}
	
	private void limparForm() {
		textFieldDesc.setText("");
		textFieldPreco.setText("");
	}
}