package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.LocacaoController;
import controller.MainController;
import controller.ReservaController;
import controller.VeiculosController;

import model.IVeiculo;
import model.Reserva;

public class LocacaoView extends JFrame {

	private static final long serialVersionUID = -3237090061187484621L;
	
	private JComboBox<Reserva> comboBoxReserva;
	private JComboBox<IVeiculo> comboBoxVeiculo;
	
	private JPanel contentPane;
	
	private JTextField textFieldKmINicial;

	private Reserva reserva;
	private IVeiculo veiculo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocacaoView frame = new LocacaoView();
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
	public LocacaoView() {
		ReservaController reservaController = MainController.getReservaController();
		VeiculosController veiculosController = MainController.getVeiculosController();
		
		setTitle("LOCACAO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setBounds(14, 12, 57, 15);
		contentPane.add(lblReserva);
		
		comboBoxReserva = new JComboBox<Reserva>(reservaController.getDefaultComboBoxModel());
		comboBoxReserva.setBounds(106, 7, 322, 28);
		contentPane.add(comboBoxReserva);
		
		JLabel lblKmInicial = new JLabel("Km Inicial");
		lblKmInicial.setBounds(14, 98, 66, 15);
		contentPane.add(lblKmInicial);
		
		textFieldKmINicial = new JTextField();
		textFieldKmINicial.setBounds(106, 93, 322, 28);
		contentPane.add(textFieldKmINicial);
		textFieldKmINicial.setColumns(10);
		
		JButton btnAlocar = new JButton("Alocar");
		btnAlocar.setBounds(175, 233, 78, 25);
		btnAlocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionAlocar();
			}
		});
		contentPane.add(btnAlocar);
		
		JLabel lblVeiculo = new JLabel("Veiculo");
		lblVeiculo.setBounds(14, 56, 70, 15);
		contentPane.add(lblVeiculo);
		
		comboBoxVeiculo = new JComboBox<IVeiculo>(veiculosController.getDefaultComboBoxModel());
		comboBoxVeiculo.setBounds(106, 50, 322, 28);
		contentPane.add(comboBoxVeiculo);
	}
	
	protected void actionAlocar() {
		
		reserva = (Reserva) comboBoxReserva.getSelectedItem();
		veiculo = (IVeiculo) comboBoxVeiculo.getSelectedItem();
		
		LocacaoController controller = MainController.getLocacaoController();
		
		int kmInt;
	
        try {
    		String kmInicial = textFieldKmINicial.getText();
    	    kmInt = Integer.parseInt(kmInicial);
    	    
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, String.format("Campo 'Km Inicial' deve ser um número inteiro"), "Entrada invalida", JOptionPane.INFORMATION_MESSAGE);
        	textFieldKmINicial.setText("");
        	return;
        }
		
		controller.addLocacao(kmInt, veiculo, reserva);
		
		JOptionPane.showMessageDialog(null,String.format("Locacao realizada com sucesso!"), "Locacao", JOptionPane.INFORMATION_MESSAGE);		
		
		limparForm();
	}
	
	private void limparForm() {
		textFieldKmINicial.setText("");
	}
}
