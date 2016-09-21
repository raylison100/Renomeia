package renomeia.com.negocios;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Renomeia {

	public void botaoRenomeia(JTextArea textArea, String codigo, String extensao) {

		String diretorio = new String();
		JFileChooser fc = new JFileChooser();
		int res = 0;
		boolean dir = true;
		boolean text = true;

		if (textArea.getText() == null || textArea.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Favor inserir algum código e CPF!");
			text = false;
		}
		if (text != false) {

			if (extensao == "") {

				JOptionPane.showMessageDialog(null, "Selecione uma extensão");

			} else {
				// restringe a amostra a diretorios apenas para selecionar o
				// local
				// dos arquivos
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				res = fc.showOpenDialog(null);
			}

			if (res == JFileChooser.APPROVE_OPTION) {

				diretorio = fc.getSelectedFile().getAbsolutePath();

			} else {
				dir = false;
				JOptionPane.showMessageDialog(null,
						" Diretorio não selecionado");
			}

			if (dir == true) {
				ArrayList<String> antigo = new ArrayList<String>();
				ArrayList<String> novo = new ArrayList<String>();
				ArrayList<String> falhasLog = new ArrayList<String>();
				String separaLinhas[] = textArea.getText().toString()
						.split("\n");

				for (int i = 0; i < separaLinhas.length; i++) {
					String aux[] = separaLinhas[i].split("	");
					for (int j = 0; j < aux.length; j++) {
						if (j % 2 == 0)
							antigo.add(aux[j]);
						else
							novo.add(aux[j]);
					}
					aux = null;
				}

				int ok = 0, falhas = 0;
				for (int cont = 0; cont < antigo.size(); cont++) {

					File fAntigo = new File(diretorio.toString() + "\\"
							+ codigo.toString() + antigo.get(cont) + extensao);
					File fNovo = new File(diretorio.toString() + "\\"
							+ novo.get(cont) + extensao);

					if (fAntigo.renameTo(fNovo)) {
						ok++;
					} else {
						falhas++;
						falhasLog.add(antigo.get(cont));
					}

				}

				int confirm = JOptionPane.showConfirmDialog(null,
						"CONCLUIDO\nEXITO: " + ok + "  Nao encontradas: "
								+ falhas
								+ "\n\nDeseja ver o relatorio de erros?:",
						null, JOptionPane.YES_OPTION);

				String temp = new String();
				if (confirm == 0) {
					for (String s : falhasLog) {
						temp += s + "\n";
					}
					textArea.setText(temp);
				} else {
					textArea.setText("");
				}

				falhasLog.clear();

			}
		}

	}

}
