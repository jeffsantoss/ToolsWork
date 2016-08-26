import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class Comando {
	
	private String caminho;
	
	public Comando(String caminho){
		this.setCaminho(caminho);
		try {
			Runtime.getRuntime().exec(this.getCaminho());
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir a aplicação. Contate o administrador do sistema!");
		}
	}
	
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	
	
	
	
	
	
	
}
