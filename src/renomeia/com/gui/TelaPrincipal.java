package renomeia.com.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import renomeia.com.negocios.Botoes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;


public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JTextField textFieldCodigoCam;
	private JComboBox comboBoxExtensoes = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Raylison\\workspace\\Renomeia\\icon.png"));
		setTitle("Renomeador de imagens em lotes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 440, 541);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnRenomear = new JButton("RENOMEAR");
		btnRenomear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Botoes bt = new Botoes();
				
                
				bt.botaoRenomeia(textArea, textFieldCodigoCam.getText(),comboBoxExtensoes.getSelectedItem().toString() );
                
                	
			}
		});
		btnRenomear.setBounds(178, 481, 125, 25);
		panel.add(btnRenomear);

		
		
		JLabel lblTivit = new JLabel("TIVIT JBT");
		lblTivit.setBounds(131, 0, 177, 52);
		lblTivit.setForeground(Color.RED);
		lblTivit.setFont(new Font("SansSerif", Font.PLAIN, 40));
		panel.add(lblTivit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("teste");
		panel_1.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Copie e cole o c\u00F3digo e o cpf", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(3, 81, 434, 332);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 16, 410, 316);
		panel_1.add(scrollPane);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				textArea.setText("");
			}
		});
		btnLimpar.setBounds(315, 481, 116, 25);
		panel.add(btnLimpar);

		JLabel lblTiEmAo = new JLabel("TI EM A\u00C7\u00C3O");
		lblTiEmAo.setForeground(Color.RED);
		lblTiEmAo.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTiEmAo.setBounds(162, 42, 116, 26);
		panel.add(lblTiEmAo);
		
		JLabel lblDesenvolvedoresRaylison = new JLabel("Desenvolvedores: Raylison - Alex | Vers\u00E3o: 1.6");
		lblDesenvolvedoresRaylison.setForeground(Color.BLACK);
		lblDesenvolvedoresRaylison.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblDesenvolvedoresRaylison.setBounds(93, 506, 253, 22);
		panel.add(lblDesenvolvedoresRaylison);
		
		JLabel lblCodigoDaCamera = new JLabel("Codigo da c\u00E2mera");
		lblCodigoDaCamera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoDaCamera.setBounds(12, 418, 104, 23);
		panel.add(lblCodigoDaCamera);
		
		textFieldCodigoCam = new JTextField();
		textFieldCodigoCam.setBounds(119, 419, 116, 22);
		panel.add(textFieldCodigoCam);
		textFieldCodigoCam.setColumns(10);
		
		JLabel lblExtenso = new JLabel("Extens\u00E3o");
		lblExtenso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblExtenso.setBounds(12, 449, 56, 16);
		panel.add(lblExtenso);
		
		
		comboBoxExtensoes.setModel(new DefaultComboBoxModel(new String[] {"", ".jpg", ".bmp", ".png", ".bitmap"}));
		comboBoxExtensoes.setBounds(119, 446, 116, 22);
		panel.add(comboBoxExtensoes);
		
		
	}
}
