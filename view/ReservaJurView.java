package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.CategoriaController;
import controller.ClienteJurController;
import controller.MainController;
import controller.ReservaController;
import controller.SeguroController;
import controller.ServicoController;

import model.ICategoria;
import model.IPessoa;
import model.IPessoaJuridica;
import model.ISeguro;
import model.IServico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ReservaJurView extends JFrame {
	
	private static final long serialVersionUID = 6203713311511705348L;
	
	private JPanel contentPane;
	private JLabel lblServico;
	private JLabel lblSeguro;
	private JButton btnReservar;
	private JLabel lblCategoria;
	private JComboBox<ICategoria> comboBoxCategoria;
	private JComboBox<IPessoaJuridica> comboBoxCliente;
	private JComboBox<IServico> comboBoxServico;
	private JComboBox<ISeguro> comboBoxSeguro;
	private JLabel lblDataDeInicio;
	private JLabel lblDataFinal;
	private JTextField textFieldDataInicio;
	private JTextField textFieldDataFinal;
	
	private IPessoa cliente;
	private ICategoria categoria;
	private IServico servico;
	private ISeguro seguro;

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
					ReservaFisView frame = new ReservaFisView();
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
	public ReservaJurView() {
		ClienteJurController clienteJurController = MainController.getClienteJurController();
		SeguroController seguroController = MainController.getSeguroController();
		ServicoController servicoController = MainController.getServicoController();
		CategoriaController categoriaController = MainController.getCategoriaController();
		
		setFont(new Font("Arial Black", Font.PLAIN, 12));
		setTitle("RESERVA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente Juridico");
		lblCliente.setBounds(5, 3, 108, 24);
		contentPane.add(lblCliente);
		
		lblServico = new JLabel("Serviço");
		lblServico.setBounds(5, 80, 70, 15);
		contentPane.add(lblServico);
		
		lblSeguro = new JLabel("Seguro");
		lblSeguro.setBounds(5, 116, 70, 15);
		contentPane.add(lblSeguro);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setBounds(175, 238, 117, 25);
		contentPane.add(btnReservar);
		
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionReservar();
			}
		});
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(5, 44, 70, 15);
		contentPane.add(lblCategoria);
		
		comboBoxCategoria = new JComboBox<ICategoria>(categoriaController.getDefaultComboBoxModel());
		comboBoxCategoria.setBounds(116, 39, 300, 25);
		contentPane.add(comboBoxCategoria);
		
		comboBoxCliente = new JComboBox<IPessoaJuridica>(clienteJurController.getDefaultComboBoxModel());
		comboBoxCliente.setBounds(116, 3, 300, 25);
		contentPane.add(comboBoxCliente);
		
		comboBoxServico = new JComboBox<IServico>(servicoController.getDefaultComboBoxModel());
		comboBoxServico.setBounds(116, 75, 300, 25);
		contentPane.add(comboBoxServico);
		
		comboBoxSeguro = new JComboBox<ISeguro>(seguroController.getDefaultComboBoxModel());
		comboBoxSeguro.setBounds(116, 111, 300, 25);
		contentPane.add(comboBoxSeguro);
		
		lblDataDeInicio = new JLabel("Data de início");
		lblDataDeInicio.setBounds(5, 151, 97, 15);
		contentPane.add(lblDataDeInicio);
		
		lblDataFinal = new JLabel("Data final");
		lblDataFinal.setBounds(5, 187, 70, 15);
		contentPane.add(lblDataFinal);
		
		textFieldDataInicio = new JTextField();
		textFieldDataInicio.setBounds(116, 147, 300, 24);
		contentPane.add(textFieldDataInicio);
		textFieldDataInicio.setColumns(10);
		
		textFieldDataFinal = new JTextField();
		textFieldDataFinal.setColumns(10);
		textFieldDataFinal.setBounds(116, 183, 300, 24);
		contentPane.add(textFieldDataFinal);
	}
	
	protected void actionReservar() {
		
		categoria = (ICategoria) comboBoxCategoria.getSelectedItem();
		cliente = (IPessoaJuridica) comboBoxCliente.getSelectedItem();
		servico = (IServico) comboBoxServico.getSelectedItem();
		seguro = (ISeguro) comboBoxSeguro.getSelectedItem();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataInicial = textFieldDataInicio.getText();
		String dataFinal = textFieldDataFinal.getText();
		
        try {
        	ReservaController controller = MainController.getReservaController();
            LocalDate dataInicio = LocalDate.parse(dataInicial, formatter);
    		LocalDate dataFim = LocalDate.parse(dataFinal, formatter);
    		controller.addReserva(categoria, cliente, seguro, servico, dataInicio, dataFim);
    		JOptionPane.showMessageDialog(null,String.format("Reserva cadastrada com sucesso!"), "Reserva", JOptionPane.INFORMATION_MESSAGE);
        } catch (DateTimeParseException e) {
        	JOptionPane.showMessageDialog(this, String.format("Data invalida. Favor inserir no formato dd/mm/aaaa!"), "Data invalida", JOptionPane.INFORMATION_MESSAGE);
        	textFieldDataInicio .setText("");
        	textFieldDataFinal.setText("");
        }
		
		limparForm();
	}
	
	private void limparForm() {
		textFieldDataInicio.setText("");
		textFieldDataFinal.setText("");
	}
}