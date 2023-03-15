package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

import controller.DevolucaoController;
import controller.LocacaoController;
import controller.MainController;

import model.ETipoPagamento;
import model.Locacao;

public class DevolucaoView extends JFrame {
	
	private static final long serialVersionUID = -6899221024340223145L;
	
	private JPanel contentPane;
	private JTextField textFieldKmFinal;
	
	private JComboBox<Locacao> comboBoxLocacao;
	private JComboBox<ETipoPagamento> comboBoxTipoPagamento; 
	
	private Locacao locacao;
	private ETipoPagamento tipoPagamento;
	private JTextArea textAreaList;
	
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
					DevolucaoView frame = new DevolucaoView();
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
	public DevolucaoView() {
		LocacaoController locacaoController = MainController.getLocacaoController();
		
		setTitle("DEVOLUÇÃO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocacao = new JLabel("Locacao");
		lblLocacao.setBounds(12, 5, 70, 15);
		contentPane.add(lblLocacao);
		
		JButton btnGerarNotaFiscal = new JButton("Gerar Nota Fiscal");
		btnGerarNotaFiscal.setBounds(140, 250, 165, 20);
		contentPane.add(btnGerarNotaFiscal);
		
		btnGerarNotaFiscal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionDevolucao();
			}
		});
		
		JLabel lblKmFinal = new JLabel("Km Final");
		lblKmFinal.setBounds(12, 27, 70, 15);
		contentPane.add(lblKmFinal);
		
		textFieldKmFinal = new JTextField();
		textFieldKmFinal.setColumns(10);
		textFieldKmFinal.setBounds(155, 25, 253, 23);
		contentPane.add(textFieldKmFinal);
		
		comboBoxLocacao = new JComboBox<Locacao>(locacaoController.getDefaultComboBoxModel());
		comboBoxLocacao.setBounds(155, 5, 253, 20);
		contentPane.add(comboBoxLocacao);
		
		JLabel lblTipoPagamento = new JLabel("Tipo Pagamento");
		lblTipoPagamento.setBounds(12, 48, 132, 15);
		contentPane.add(lblTipoPagamento);
		
		comboBoxTipoPagamento = new JComboBox<ETipoPagamento>();
		comboBoxTipoPagamento.setModel(new DefaultComboBoxModel<ETipoPagamento>(ETipoPagamento.values()));
		comboBoxTipoPagamento.setBounds(155, 48, 253, 20);
		contentPane.add(comboBoxTipoPagamento);
		
		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 67, 410, 187);
		contentPane.add(textAreaList);
	}
	
	protected void actionDevolucao() {
		
		locacao = (Locacao) comboBoxLocacao.getSelectedItem();
		tipoPagamento = (ETipoPagamento) comboBoxTipoPagamento.getSelectedItem();
		
		DevolucaoController controller = MainController.getDevolucaoController();
		int kmInt;
		
        try {
    		String kmFinal = textFieldKmFinal.getText();
    	    kmInt = Integer.parseInt(kmFinal);
    	    
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, String.format("Campo 'Km Final' deve ser um número inteiro"), "Entrada invalida", JOptionPane.INFORMATION_MESSAGE);
        	textFieldKmFinal.setText("");
        	return;
        }
        
        controller.addDevolucao(kmInt, tipoPagamento, locacao);
        actionGerarNotaFiscal();
	}
	
	protected void actionGerarNotaFiscal() {
	
		DevolucaoController controller = MainController.getDevolucaoController();
		locacao = (Locacao) comboBoxLocacao.getSelectedItem();
		
		String nota = controller.geraNotaFiscal(locacao);
		
		textAreaList.setText(null);
		textAreaList.append(String.format("%s\n", nota));
	}
}