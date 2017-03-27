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

import renomeia.com.negocios.AchaNomes;
import renomeia.com.negocios.Copiar;
import renomeia.com.negocios.Deletar;
import renomeia.com.negocios.Recorta;
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
import javax.swing.ScrollPaneConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

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
	private Recorta cr = new Recorta();
	private Deletar dl = new Deletar();
	private Renomeia ren = new Renomeia();
	private AchaNomes acn = new AchaNomes();
	private JTextField textFieldEndereço;
	private JTextField textFieldFiltro;


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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/IMAGENS/teste2.png")));
		setTitle("Renomeador de imagens em lotes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 440, 572);
		contentPane.add(tabbedPane);
		
				JPanel renomeia = new JPanel();
				tabbedPane.addTab("Renomear", new ImageIcon(TelaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")), renomeia, null);
				renomeia.setLayout(null);
				
						JButton btnRenomear = new JButton("RENOMEAR");
						btnRenomear.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
						btnRenomear.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								ren.botaoRenomeia(textArea, textFieldCodigoCam.getText(),
										comboBoxExtensoes.getSelectedItem().toString());

							}
						});
						btnRenomear.setBounds(185, 498, 109, 25);
						renomeia.add(btnRenomear);
						
								JPanel panel_1 = new JPanel();
								panel_1.setToolTipText("teste");
								panel_1.setBorder(new TitledBorder(new TitledBorder(UIManager
										.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
										TitledBorder.TOP, null, new Color(0, 0, 0)),
										"Copie e cole o c\u00F3digo e o CPF", TitledBorder.LEADING,
										TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_1.setBounds(0, 90, 434, 329);
								renomeia.add(panel_1);
								panel_1.setLayout(null);
								
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(12, 22, 410, 296);
										panel_1.add(scrollPane);
										
												textArea = new JTextArea();
												textArea.setLineWrap(true);
												scrollPane.setViewportView(textArea);
												
														JButton btnLimpar = new JButton("LIMPAR");
														btnLimpar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
														btnLimpar.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent arg0) {

																textArea.setText("");
																comboBoxExtensoes.setSelectedItem(null);
															}
														});
														btnLimpar.setBounds(304, 498, 110, 25);
														renomeia.add(btnLimpar);
														
																JLabel lblTiEmAo = new JLabel("TI EM A\u00C7\u00C3O");
																lblTiEmAo.setForeground(Color.BLUE);
																lblTiEmAo.setFont(new Font("Cordia New", Font.BOLD, 25));
																lblTiEmAo.setBounds(214, 25, 103, 26);
																renomeia.add(lblTiEmAo);
																
																		JLabel lblCodigoDaCamera = new JLabel("Codigo da c\u00E2mera");
																		lblCodigoDaCamera.setFont(new Font("Tahoma", Font.PLAIN, 13));
																		lblCodigoDaCamera.setBounds(10, 436, 104, 23);
																		renomeia.add(lblCodigoDaCamera);
																		
																				textFieldCodigoCam = new JTextField();
																				textFieldCodigoCam.setBounds(121, 437, 116, 22);
																				renomeia.add(textFieldCodigoCam);
																				textFieldCodigoCam.setColumns(10);
																				
																						JLabel lblExtenso = new JLabel("Extens\u00E3o");
																						lblExtenso.setFont(new Font("Tahoma", Font.PLAIN, 13));
																						lblExtenso.setBounds(10, 470, 56, 16);
																						renomeia.add(lblExtenso);
																						
																								comboBoxExtensoes.setModel(new DefaultComboBoxModel<Object>(
																										new String[] { ".jpg", ".bmp", ".png", ".bitmap","" }));
																								comboBoxExtensoes.setSelectedItem(null);
																								comboBoxExtensoes.setBounds(121, 470, 116, 22);
																								renomeia.add(comboBoxExtensoes);
																								
																								JLabel label = new JLabel("");
																								label.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/IMAGENS/teste2.png")));
																								label.setBounds(129, 5, 75, 79);
																								renomeia.add(label);

		JPanel Transferir = new JPanel();
		tabbedPane.addTab("Transferir", new ImageIcon(TelaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")), Transferir, null);
		Transferir.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setToolTipText("teste");
		panel_4.setBorder(new TitledBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Copie e cole o CPF", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		panel_4.setBounds(0, 90, 434, 262);
		Transferir.add(panel_4);

		JScrollPane scrollPaneCopia = new JScrollPane();
		scrollPaneCopia.setBounds(12, 22, 410, 229);
		panel_4.add(scrollPaneCopia);

		JTextArea textAreaCopia = new JTextArea();
		textAreaCopia.setLineWrap(true);
		scrollPaneCopia.setViewportView(textAreaCopia);

		JLabel label_1 = new JLabel("TI EM A\u00C7\u00C3O");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Cordia New", Font.BOLD, 25));
		label_1.setBounds(214, 25, 103, 26);
		Transferir.add(label_1);

		textField_Origem = new JTextField();
		textField_Origem.setEditable(false);
		textField_Origem.setBounds(76, 363, 217, 22);
		Transferir.add(textField_Origem);
		textField_Origem.setColumns(10);

		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrigem.setBounds(10, 363, 56, 16);
		Transferir.add(lblOrigem);

		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDestino.setBounds(10, 400, 56, 16);
		Transferir.add(lblDestino);

		textField_Destino = new JTextField();
		textField_Destino.setEditable(false);
		textField_Destino.setBounds(76, 399, 217, 22);
		Transferir.add(textField_Destino);
		textField_Destino.setColumns(10);

		JButton btnSelecionar_Ori = new JButton("Selecionar");
		btnSelecionar_Ori.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		btnSelecionar_Ori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_Origem.setText(cp.botaoSelecionarOri());

			}
		});
		btnSelecionar_Ori.setBounds(303, 363, 114, 25);
		Transferir.add(btnSelecionar_Ori);

		JButton btnSelecionar_Dest = new JButton("Selecionar");
		btnSelecionar_Dest.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		btnSelecionar_Dest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_Destino.setText(cp.botaoSelecionardesti());
			}
		});
		btnSelecionar_Dest.setBounds(303, 398, 110, 25);
		Transferir.add(btnSelecionar_Dest);

		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(comboBoxExtensoesCopy.getSelectedItem() == null ){
					
					
					cp.botaoCopiar(textAreaCopia,"");
					
				}else{
								
				cp.botaoCopiar(textAreaCopia, comboBoxExtensoesCopy
						.getSelectedItem().toString());

				}
			}
		});
		btnCopiar.setBounds(10, 498, 87, 25);
		Transferir.add(btnCopiar);

		JButton btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAreaCopia.setText("");
				textField_Origem.setText("");
				textField_Destino.setText("");
				comboBoxExtensoesCopy.setSelectedItem(null);

			}
		});
		btnLimpar_1.setBounds(220, 498, 87, 25);
		Transferir.add(btnLimpar_1);

		JLabel lblExtenso_1 = new JLabel("Extens\u00E3o");
		lblExtenso_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExtenso_1.setBounds(10, 443, 69, 16);
		Transferir.add(lblExtenso_1);
		comboBoxExtensoesCopy.setToolTipText("");

		comboBoxExtensoesCopy.setModel(new DefaultComboBoxModel<Object>(new String[] {".jpg", ".bmp", ".png", ".bitmap"}));
		comboBoxExtensoesCopy.setSelectedItem(null);
		comboBoxExtensoesCopy.setBounds(76, 442, 116, 22);
		Transferir.add(comboBoxExtensoesCopy);
		
				JLabel lblNeobpo = new JLabel("");
				lblNeobpo.setBounds(129, 5, 75, 79);
				Transferir.add(lblNeobpo);
				lblNeobpo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/IMAGENS/teste2.png")));
				lblNeobpo.setForeground(Color.BLUE);
				lblNeobpo.setFont(new Font("SansSerif", Font.PLAIN, 35));
				
				JButton btnRecortar = new JButton("Recortar");
				btnRecortar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(comboBoxExtensoesCopy.getSelectedItem() == null ){							
							
							cr.botaoRecorta(textAreaCopia,"");							
						}else{
										
						    cr.botaoRecorta(textAreaCopia, comboBoxExtensoesCopy
								.getSelectedItem().toString());
						}
												
					}
				});
				btnRecortar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
				btnRecortar.setBounds(107, 499, 103, 23);
				Transferir.add(btnRecortar);
				
				JButton btnDeletar = new JButton("Deletar");
				btnDeletar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
				btnDeletar.setBounds(317, 499, 103, 23);
				Transferir.add(btnDeletar);
		
		JPanel Recupera = new JPanel();
		tabbedPane.addTab("Acha Nomes", new ImageIcon(TelaPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/ListView.gif")), Recupera, null);
		Recupera.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Editar depois", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 204, 435, 309);
		Recupera.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 27, 415, 282);
		panel.add(scrollPane_1);
		
		JTextArea textAreaAcharNomes = new JTextArea();
		textAreaAcharNomes.setEditable(false);
		textAreaAcharNomes.setLineWrap(true);
		scrollPane_1.setViewportView(textAreaAcharNomes);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndereo.setBounds(10, 111, 70, 26);
		Recupera.add(lblEndereo);
		
		textFieldEndereço = new JTextField();
		textFieldEndereço.setBounds(74, 116, 224, 20);
		Recupera.add(textFieldEndereço);
		textFieldEndereço.setColumns(10);
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
				textAreaAcharNomes.setText("");
				acn.botaoSelecionarDestino();				
				textFieldEndereço.setText(acn.getDestino());
				System.out.println(textFieldFiltro.getText());
				acn.filtro(textFieldFiltro.getText(), textAreaAcharNomes);
						
			}
		});
		
		
		
		
		btnLocalizar.setBounds(308, 115, 95, 23);
		Recupera.add(btnLocalizar);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFiltro.setBounds(10, 162, 46, 20);
		Recupera.add(lblFiltro);
		
		textFieldFiltro = new JTextField();
		textFieldFiltro.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				
				textAreaAcharNomes.setText("");
				textFieldEndereço.setText(acn.getDestino());
				System.out.println(textFieldFiltro.getText());
				acn.filtro(textFieldFiltro.getText(), textAreaAcharNomes);
			}
		});
		
	
		
		textFieldFiltro.setBounds(53, 164, 140, 20);
		Recupera.add(textFieldFiltro);
		textFieldFiltro.setColumns(10);
		
		JLabel lblTiEmAo_1 = new JLabel("TI EM A\u00C7\u00C3O");
		lblTiEmAo_1.setForeground(Color.BLUE);
		lblTiEmAo_1.setFont(new Font("Cordia New", Font.BOLD, 25));
		lblTiEmAo_1.setBounds(214, 25, 103, 26);
		Recupera.add(lblTiEmAo_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/IMAGENS/teste2.png")));
		label_2.setBounds(129, 5, 75, 79);
		Recupera.add(label_2);
		
		JPanel Sobre = new JPanel();
		tabbedPane.addTab("Sobre", new ImageIcon(TelaPrincipal.class.getResource("/com/sun/java/swing/plaf/motif/icons/Inform.gif")), Sobre, null);
		Sobre.setLayout(null);
		
		JTextArea txtrDesenvolvedoresRaylison = new JTextArea();
		txtrDesenvolvedoresRaylison.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrDesenvolvedoresRaylison.setBackground(UIManager.getColor("Button.background"));
		txtrDesenvolvedoresRaylison.setForeground(Color.BLACK);
		txtrDesenvolvedoresRaylison.setEditable(false);
		txtrDesenvolvedoresRaylison.setText("Aplica\u00E7\u00E3o desenvolvida com o intuito de agilizar o processo de cadatro para novos colaboradores realizado pelo RH.\r\n\r\nFun\u00E7\u00E3o: 1 - Realizar a renomia\u00E7\u00E3o em massa de arquivos fotograficos.\r\n             2 - Realizar a copia de arquivos em grandes quantidades, de                    um diretorio a outro.\r\n\r\n\r\nDesenvolvedor: Raylison Nunes , Alex Barbosa.\r\nCoordenador:  Alex Barbosa.\r\n\r\n\r\nInicio do projeto: Julho/2016 \r\n\r\n\r\n\r\n\r\n\r\n                                           Vers\u00E3o: 3.0");
		txtrDesenvolvedoresRaylison.setLineWrap(true);
		txtrDesenvolvedoresRaylison.setBounds(10, 11, 415, 491);
		Sobre.add(txtrDesenvolvedoresRaylison);

	}
}
