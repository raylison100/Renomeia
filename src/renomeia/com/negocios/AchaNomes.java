package renomeia.com.negocios;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AchaNomes {
	
	
	
	ArrayList<String>  dados = new ArrayList<String>();
	String diretorio = new String();
	
	public void botaoSelecionarDestino() {

		
		JFileChooser fc = new JFileChooser();
		int res = 0;
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		res = fc.showOpenDialog(null);
		if (res == JFileChooser.APPROVE_OPTION) {

			diretorio = fc.getSelectedFile().getAbsolutePath();

		} else {
			
			JOptionPane.showMessageDialog(null, " Diretorio n�o selecionado");
		}
				
		
		File raiz = new File(diretorio);
		for(File f: raiz.listFiles()) {
			if(f.isFile()) {
			   dados.add(f.getName());
			}
		}
		
		
}	
		

	public String getDestino(){
		
		
	return diretorio;	
	
	}
	
	
	public ArrayList<String> gettDados(){
		return dados;
	}
	
	
	
	
	
}
