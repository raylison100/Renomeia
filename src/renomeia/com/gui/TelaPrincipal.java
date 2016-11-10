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

import renomeia.com.negocios.Copiar;
import renomeia.com.negocios.Renomeia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JTextField textFieldCodigoCam;
	private JComboBox<Object> comboBoxExtensoes = new JComboBox<Object>();
	private JComboBox<Object> comboBoxExtensoesCopy = new JComboBox<Object>();
	private JTextField textField_Origem;
	private JTextField textField_Destino;
	private Copiar cp = new Copiar();
	private Renomeia ren = new Renomeia();

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

	public TelaPrincipal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
             }
		
		}
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"icon.png"));
		setTitle("Renomeador de imagens em lotes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 440, 541);
		contentPane.add(tabbedPane);

		JPanel aba1 = new JPanel();
		tabbedPane.addTab("Renomear", null, aba1, null);
		aba1.setLayout(null);

		JButton btnRenomear = new JButton("RENOMEAR");
		btnRenomear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ren.botaoRenomeia(textArea, textFieldCodigoCam.getText(),
						comboBoxExtensoes.getSelectedItem().toString());

			}
		});
		btnRenomear.setBounds(178, 481, 125, 25);
		aba1.add(btnRenomear);

		JLabel lblTivit = new JLabel("TIVIT JBT");
		lblTivit.setBounds(131, 0, 177, 52);
		lblTivit.setForeground(Color.RED);
		lblTivit.setFont(new Font("SansSerif", Font.PLAIN, 40));
		aba1.add(lblTivit);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("teste");
		panel_1.setBorder(new TitledBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Copie e cole o c\u00F3digo e o CPF", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(3, 81, 434, 332);
		aba1.add(panel_1);
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
				comboBoxExtensoes.setSelectedItem(null);
			}
		});
		btnLimpar.setBounds(315, 481, 116, 25);
		aba1.add(btnLimpar);

		JLabel lblTiEmAo = new JLabel("TI EM A\u00C7\u00C3O");
		lblTiEmAo.setForeground(Color.RED);
		lblTiEmAo.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTiEmAo.setBounds(162, 42, 116, 26);
		aba1.add(lblTiEmAo);

		JLabel lblCodigoDaCamera = new JLabel("Codigo da c\u00E2mera");
		lblCodigoDaCamera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoDaCamera.setBounds(12, 418, 104, 23);
		aba1.add(lblCodigoDaCamera);

		textFieldCodigoCam = new JTextField();
		textFieldCodigoCam.setBounds(119, 419, 116, 22);
		aba1.add(textFieldCodigoCam);
		textFieldCodigoCam.setColumns(10);

		JLabel lblExtenso = new JLabel("Extens\u00E3o");
		lblExtenso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblExtenso.setBounds(12, 449, 56, 16);
		aba1.add(lblExtenso);

		comboBoxExtensoes.setModel(new DefaultComboBoxModel<Object>(
				new String[] { ".jpg", ".bmp", ".png", ".bitmap" }));
		comboBoxExtensoes.setSelectedItem(null);
		comboBoxExtensoes.setBounds(119, 446, 116, 22);
		aba1.add(comboBoxExtensoes);

		JPanel aba2 = new JPanel();
		tabbedPane.addTab("Copiar", null, aba2, null);
		aba2.setLayout(null);

		JLabel label = new JLabel("TIVIT JBT");
		label.setForeground(Color.RED);
		label.setFont(new Font("SansSerif", Font.PLAIN, 40));
		label.setBounds(131, 0, 177, 52);
		aba2.add(label);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setToolTipText("teste");
		panel_4.setBorder(new TitledBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Copie e cole o CPF", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		panel_4.setBounds(0, 81, 434, 313);
		aba2.add(panel_4);

		JScrollPane scrollPaneCopia = new JScrollPane();
		scrollPaneCopia.setBounds(12, 24, 410, 308);
		panel_4.add(scrollPaneCopia);

		JTextArea textAreaCopia = new JTextArea();
		textAreaCopia.setLineWrap(true);
		scrollPaneCopia.setViewportView(textAreaCopia);

		JLabel label_1 = new JLabel("TI EM A\u00C7\u00C3O");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		label_1.setBounds(162, 42, 116, 26);
		aba2.add(label_1);

		textField_Origem = new JTextField();
		textField_Origem.setEditable(false);
		textField_Origem.setBounds(64, 407, 253, 22);
		aba2.add(textField_Origem);
		textField_Origem.setColumns(10);

		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrigem.setBounds(10, 407, 56, 16);
		aba2.add(lblOrigem);

		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDestino.setBounds(8, 444, 56, 16);
		aba2.add(lblDestino);

		textField_Destino = new JTextField();
		textField_Destino.setEditable(false);
		textField_Destino.setBounds(64, 442, 253, 22);
		aba2.add(textField_Destino);
		textField_Destino.setColumns(10);

		JButton btnSelecionar_Ori = new JButton("Selecionar");
		btnSelecionar_Ori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_Origem.setText(cp.botaoSelecionarOri());

			}
		});
		btnSelecionar_Ori.setBounds(324, 407, 97, 25);
		aba2.add(btnSelecionar_Ori);

		JButton btnSelecionar_Dest = new JButton("Selecionar");
		btnSelecionar_Dest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_Destino.setText(cp.botaoSelecionardesti());
			}
		});
		btnSelecionar_Dest.setBounds(324, 441, 97, 25);
		aba2.add(btnSelecionar_Dest);

		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cp.botaoCopiar(textAreaCopia, comboBoxExtensoesCopy
						.getSelectedItem().toString());

			}
		});
		btnCopiar.setBounds(249, 477, 78, 25);
		aba2.add(btnCopiar);

		JButton btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAreaCopia.setText("");
				textField_Origem.setText("");
				textField_Destino.setText("");
				comboBoxExtensoesCopy.setSelectedItem(null);

			}
		});
		btnLimpar_1.setBounds(343, 477, 78, 25);
		aba2.add(btnLimpar_1);

		JLabel lblExtenso_1 = new JLabel("Extens\u00E3o");
		lblExtenso_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExtenso_1.setBounds(10, 481, 69, 16);
		aba2.add(lblExtenso_1);

		comboBoxExtensoesCopy.setModel(new DefaultComboBoxModel<Object>(
				new String[] { ".jpg", ".bmp", ".png", ".bitmap" }));
		comboBoxExtensoesCopy.setSelectedItem(null);
		comboBoxExtensoesCopy.setBounds(74, 478, 116, 22);
		aba2.add(comboBoxExtensoesCopy);
		
		JPanel aba3 = new JPanel();
		tabbedPane.addTab("Sobre", null, aba3, null);
		aba3.setLayout(null);
		
		JTextArea txtrDesenvolvedoresRaylison = new JTextArea();
		txtrDesenvolvedoresRaylison.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrDesenvolvedoresRaylison.setBackground(UIManager.getColor("Button.background"));
		txtrDesenvolvedoresRaylison.setForeground(Color.BLACK);
		txtrDesenvolvedoresRaylison.setEditable(false);
		txtrDesenvolvedoresRaylison.setText("Aplica\u00E7\u00E3o desenvolvida com o intuito de agilizar o processo de cadatro para novos colaboradores realizado pelo RH.\r\n\r\nFun\u00E7\u00E3o: 1 - Realizar a renomia\u00E7\u00E3o em massa de arquivos fotograficos.\r\n             2 - Realizar a copia de arquivos em grandes quantidades, de                    um diretorio a outro.\r\n\r\n\r\nDesenvolvedor: Raylison Nunes , Alex Barbosa.\r\nCoordenador:  Alex Barbosa.\r\n\r\n\r\nInicio do projeto: Julho/2016 \r\n\r\n\r\n\r\n\r\n\r\n                                           Vers\u00E3o: 1.9");
		txtrDesenvolvedoresRaylison.setLineWrap(true);
		txtrDesenvolvedoresRaylison.setBounds(10, 11, 415, 491);
		aba3.add(txtrDesenvolvedoresRaylison);

	}
}
