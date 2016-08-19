package renomeia.com.negocios;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Botoes {

	public void botaoRenomeia(JTextArea textArea, String codigo) {

		String diretorio = new String();
		JFileChooser fc = new JFileChooser();
		// restringe a amostra a diretorios apenas
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int res = fc.showOpenDialog(null);
		
		if(textArea.getName()== null){
			JOptionPane.showMessageDialog(null, "Favor inserir algum código e CPF!");		
			
		}

		if (res == JFileChooser.APPROVE_OPTION) {

			diretorio = fc.getSelectedFile().getAbsolutePath();

		} else
			JOptionPane.showMessageDialog(null, " Diretorio não selecionado");

		ArrayList<String> antigo = new ArrayList<String>();
		ArrayList<String> novo = new ArrayList<String>();
		ArrayList<String> falhasLog = new ArrayList<String>();
		String separaLinhas[] = textArea.getText().split("\n");

		for (int i = 0; i < separaLinhas.length; i++) {
			String aux[] = separaLinhas[i].split("	");
			for (int j = 0; j < aux.length; j++) {
				if (j % 2 == 0)
					antigo.add(aux[j]);
				else
					novo.add(aux[j]);
			}
		}

		int ok = 0, falhas = 0;
		for (int cont = 0; cont < antigo.size(); cont++) {

			File fAntigo = new File(diretorio.toString() + codigo
					+ antigo.get(cont) + ".bmp");
			File fNovo = new File(diretorio.toString() + "\\" + novo.get(cont)
					+ ".bmp");

			if (fAntigo.renameTo(fNovo)) {
				ok++;
			} else {
				falhas++;
				falhasLog.add(antigo.get(cont));
			}

		}
		int confirm = JOptionPane.showConfirmDialog(null, "CONCLUIDO\nEXITO: "
				+ ok + "  Nao encontradas: " + falhas
				+ "\n\nDeseja ver o relatorio de erros?:", null,
				JOptionPane.YES_OPTION);

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
