package renomeia.com.negocios;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AchaNomes {
	
	private String origem;
	
	public String botaoSelecionarDestino() {

		String diretorio = new String();
		JFileChooser fc = new JFileChooser();
		int res = 0;
		boolean dir = true;
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		res = fc.showOpenDialog(null);
		if (res == JFileChooser.APPROVE_OPTION) {

			diretorio = fc.getSelectedFile().getAbsolutePath();

		} else {
			dir = false;
			JOptionPane.showMessageDialog(null, " Diretorio não selecionado");
		}
		if (dir == true) {
			origem = diretorio;

		}
		
		
		
//		public static void getImgs(String path){
//		    File file = new File(path);
//		    File[] arquivos = file.listFiles();
//
//		    try {
//		        for (File arquivo : arquivos) {
//		            System.out.println(arquivo.getName());
//		        }
//		    }catch (Exception e){
//		        e.printStackTrace();
//		    }
//		}
		

		return diretorio;
	}

}
