import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class JanelaCreatedBD extends JFrame implements ActionListener,ItemListener {
	
	private ArrayList<JButton> listButtonsv15 = new ArrayList<JButton>();
	private ArrayList<JButton> listButtonsv7 = new ArrayList<JButton>();
	private JRadioButton RadioButtonv15,RadioButtonv7;
	private JPanel panelRadio,panelv15,panelv7;
	private ButtonGroup grupBDs;
	private JButton botaoBanco,botaoFTP;
	private String Loja;
	
	
	public JanelaCreatedBD(int x,int y){
		super("Geração de Banco de Dados");
		setContentPane(new JPanel());
		setResizable(false);
		setVisible(true);
		setLayout(null);
		OrganizarRadio();
		OrganizarPainelv15();
		OrganizarPainelv7();
		setMinimumSize(new Dimension(x,y));
		setLocationRelativeTo(null);
		Desabilitar();
			for(int i = 0;i<listButtonsv15.size();i++) {
				listButtonsv15.get(i).addActionListener(this);
				listButtonsv15.get(i).setFont(new Font("Times New Roman", Font.BOLD, 11));
				listButtonsv15.get(i).setBackground(Color.WHITE);
			}
			
			for(int i = 0;i<listButtonsv7.size();i++){
				listButtonsv7.get(i).addActionListener(this);
				listButtonsv7.get(i).setFont(new Font("Times New Roman", Font.BOLD, 11));
				listButtonsv7.get(i).setBackground(Color.WHITE);
			}
	}	
	
	
	public void OrganizarRadio() {
		
		RadioButtonv15 = new JRadioButton("Banco de dados v15");
		RadioButtonv7 = new JRadioButton("Banco de dados v7");
		grupBDs = new ButtonGroup();
		botaoBanco = new JButton("BD Gerados");
		botaoFTP = new JButton("FTP");
		grupBDs.add(RadioButtonv15);
		grupBDs.add(RadioButtonv7);
		panelRadio = new JPanel(new MigLayout());
		panelRadio.setBorder(BorderFactory.createTitledBorder("Escolha a opção"));
		panelRadio.setBounds(0, 0, 500, 60);
		panelRadio.add(RadioButtonv15);
		panelRadio.add(RadioButtonv7);
		panelRadio.add(botaoBanco);
		panelRadio.add(botaoFTP);
		RadioButtonv15.addItemListener(this);
		RadioButtonv7.addItemListener(this);
		botaoBanco.addActionListener(this);
		botaoFTP.addActionListener(this);
		botaoBanco.setFont(new Font("Times New Roman", Font.BOLD, 11));
		botaoBanco.setBackground(Color.WHITE);
		botaoFTP.setFont(new Font("Times New Roman", Font.BOLD, 11));
		botaoFTP.setBackground(Color.WHITE);


		this.add(panelRadio);
	}
	
	public void OrganizarPainelv15() {
		panelv15 = new JPanel(new MigLayout());
		panelv15.setBorder(BorderFactory.createTitledBorder("Banco de dados v15"));
		panelv15.setBounds(0, 77, 700, 80);
		listButtonsv15.add(new JButton("Mover Carga"));
		listButtonsv15.add(new JButton("Config Ini"));
		listButtonsv15.add(new JButton("Manutenção"));
		listButtonsv15.add(new JButton("SegurançaFL"));
		listButtonsv15.add(new JButton("Repara"));
		listButtonsv15.add(new JButton("Compactar Arquivo"));

		panelv15.add(listButtonsv15.get(0),"gapleft 50");
		panelv15.add(listButtonsv15.get(1),"grow");
		panelv15.add(listButtonsv15.get(2),"wrap");
		panelv15.add(listButtonsv15.get(3),"gapleft 50");
		panelv15.add(listButtonsv15.get(4),"grow");
		panelv15.add(listButtonsv15.get(5),"grow");
		this.add(panelv15);
	}
	
	public void OrganizarPainelv7() {
		panelv7 = new JPanel(new MigLayout());
		panelv7.setBorder(BorderFactory.createTitledBorder("Banco de Dados v7"));
		panelv7.setBounds(0, 170, 700, 80);
		listButtonsv7.add(new JButton("Mover Carga"));
		listButtonsv7.add(new JButton("Mover MDB"));
		listButtonsv7.add(new JButton("Config Ini"));
		listButtonsv7.add(new JButton("Segurança FL"));
		listButtonsv7.add(new JButton("Repara"));
		listButtonsv7.add(new JButton("Compactar Arquivo"));
		
		panelv7.add(listButtonsv7.get(0),"gapleft 50");
		panelv7.add(listButtonsv7.get(1),"grow");
		panelv7.add(listButtonsv7.get(2),"wrap");
		panelv7.add(listButtonsv7.get(3),"gapleft 50");
		panelv7.add(listButtonsv7.get(4),"grow");
		panelv7.add(listButtonsv7.get(5),"grow");
		this.add(panelv7);
	}
	
	public void Desabilitar(){
			for(int i=0; i<listButtonsv15.size();i++) {
				listButtonsv15.get(i).setEnabled(false);
			}
			for(int i=0; i<listButtonsv7.size();i++) {
				listButtonsv7.get(i).setEnabled(false);
			}	
			
			botaoFTP.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == listButtonsv15.get(0)){
			MovimentarCargav15();
			listButtonsv15.get(0).setEnabled(false);
		}	else if(e.getSource() == listButtonsv15.get(1)){
			new Comando("cmd /c C:\\Cosmos\\Exe\\ConfigIni -"+ System.getProperty("user.name")+".exe");
		}	else if(e.getSource() == listButtonsv15.get(2)){
			new Comando("cmd /c C:\\Cosmos\\Util\\ManutencaoSistema.exe");
		}	else if(e.getSource() == listButtonsv15.get(3)) {
			new Comando("cmd /c C:\\Cosmos\\Exe\\SegFl.exe");
		}	else if(e.getSource() == listButtonsv15.get(4)) {
			new Comando("cmd /c C:\\Cosmos\\Exe\\Repara.exe");
		}	else if(e.getSource() == listButtonsv15.get(5))	{
				CompactarArquivov15();
				listButtonsv15.get(5).setEnabled(false);
				botaoFTP.setEnabled(true);
		}	
		//v7
		if(e.getSource() == listButtonsv7.get(0)){
			MoverArquivov7();
			listButtonsv7.get(0).setEnabled(false);
		}	else if(e.getSource() == listButtonsv7.get(1)){
			new Comando("cmd /c copy \"C:\\Cosmos\\Estrutura de Versoes\\Estrutura 7.0\\Csmloja.mdb C:\\Cosmos\\Dat\\ \"");
		}	else if(e.getSource() == listButtonsv7.get(3)){
			new Comando("cmd /c C:\\Cosmos\\Exe\\ConfigIni -"+ System.getProperty("user.name")+".exe");
		}  	else if(e.getSource() == listButtonsv7.get(3)) {
			new Comando("cmd /c C:\\Cosmos\\Exe\\SegFl.exe");
		}	else if(e.getSource() == listButtonsv7.get(4)) {
			new Comando("cmd /c C:\\Cosmos\\Exe\\Repara.exe");
		}	else if(e.getSource() == listButtonsv7.get(5))	{
			CompactarArquivov7();
			listButtonsv7.get(5).setEnabled(false);
			botaoFTP.setEnabled(true);
		}
		
		
			if(e.getSource() == botaoBanco){
			new Comando("cmd /c explorer C:\\ToolsWork\\Backup_Bancos\\");
		} 	else if(e.getSource() == botaoFTP) {
			new Comando("cmd /c explorer ftp://"+System.getProperty("user.name")+"@ftpsuporte.pmenos.com.br/ ");
			}
		
}
	
	public void MovimentarCargav15() {	
		Date hoje = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("ddMM");
		
		String Arquivo_Carga = "RF"+Loja+df.format(hoje)+".zip";
	
		new Comando("cmd /c move F:\\Exporta\\"+Arquivo_Carga+" C:\\Cosmos\\Importa");
		// recorta todos os bancos gerados para a pasta Backup - OK
		new Comando("cmd /c move C:\\Cosmos\\Bck\\*.zip C:\\ToolsWork\\Backup_Bancos\\");
		// exclui todas os bancos da pasta "Bck" - OK
		new Comando("cmd /c del C:\\Cosmos\\Bck\\*.bak");
		// copia as cargas do importa para uma pasta de armazenamento de backup das cargas - OK
		new Comando("cmd /c copy C:\\Cosmos\\Importa\\"+Arquivo_Carga+" C:\\ToolsWork\\Cargas_Banco");
	}
	
	public void CompactarArquivov15() {
	
		String arquivoCompactado = "Banco"+Loja+"_versao15.zip";
		// criando zip - vai zipar todos os arquivos .bak - por esse motivo não posso deixar mais de
		// 1 arquivo com essa mesma extensão
		new Comando("cmd /c C:\\progra~1\\WinRAR\\Rar.exe a -ep C:\\Cosmos\\Bck\\"+arquivoCompactado+ " C:\\Cosmos\\Bck\\*.bak");
		JOptionPane.showMessageDialog(null, "Aguarde uns instantes.. Compactando arquivo.");
		// movendo pro backup
		new Comando("cmd /c move C:\\Cosmos\\Bck\\*.zip C:\\ToolsWork\\Backup_Bancos");
		// abrindo pasta pro operador olhar
		new Comando("cmd /c explorer C:\\Cosmos\\Bck\\");
		
		JOptionPane.showMessageDialog(null, "Você concluiu a geração do banco versão 15, cole o arquivo "+arquivoCompactado+" no FTP");
	}
	
	public void MoverArquivov7() {
		Date hoje = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("ddMM");
		
		String Arquivo_Carga = "RF"+Loja+df.format(hoje)+".zip";
		System.out.println(Arquivo_Carga);
		
		new Comando("cmd /c move F:\\Exporta\\"+Arquivo_Carga+".zip "+" C:\\Cosmos\\Importa");
		new Comando("cmd /c copy C:\\Cosmos\\Importa\\"+Arquivo_Carga+" C:\\ToolsWork\\Cargas_Banco");
		new Comando("cmd /c move C:\\Cosmos\\Dat\\*.zip C:\\ToolsWork\\Backup_Bancos\\");
		new Comando("cmd /c del C:\\Cosmos\\Dat\\*.mdb");
	}
	
	public void CompactarArquivov7() {
		String arquivoCompactado = "Banco"+Loja+"_versao7.zip";
		new Comando("cmd /c C:\\progra~1\\WinRAR\\Rar.exe a -ep C:\\Cosmos\\Dat\\"+ arquivoCompactado+"C:\\Cosmos\\Dat\\*.mdb");
		new Comando("cmd /c move C:\\Cosmos\\Dat\\*.zip C:\\ToolsWork\\Backup_Bancos");
		JOptionPane.showMessageDialog(null, "Você concluiu a geração do banco versão 7, cole "+arquivoCompactado+" no FTP");
	}
	
		

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		if(RadioButtonv7.isSelected()){
			Loja = JOptionPane.showInputDialog("Digite a loja: ");
			

			while(Integer.parseInt(Loja) < 0 || Integer.parseInt(Loja) > 1000){
				Loja = JOptionPane.showInputDialog("Digite a loja novamente: ");
			}
			
			int confirm = JOptionPane.showConfirmDialog(null, "Certifique se você gerou a carga corretamente, antes de começar as etapas. Deseja mover o arquivo da loja: " + Loja + "?","Verifique a loja",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(confirm == JOptionPane.NO_OPTION){
				Loja = JOptionPane.showInputDialog("Digite a loja novamente: ");

				while(Integer.parseInt(Loja) < 0 || Integer.parseInt(Loja) > 1000 || Loja.length() != 3){
					JOptionPane.showMessageDialog(null, "Inserção inválida");
					Loja = JOptionPane.showInputDialog("Digite a loja novamente: ");
				}
			}			
			for(int i = 0;i<listButtonsv7.size();i++)
				listButtonsv7.get(i).setEnabled(true);
			

		} else if(RadioButtonv7.isSelected() == false){
			Desabilitar();
		}
		
		if(RadioButtonv15.isSelected()){
			Loja = JOptionPane.showInputDialog("Digite a loja: ");
			
			while(Integer.parseInt(Loja) < 0 || Integer.parseInt(Loja) > 1000 || Loja.length() != 3){
				JOptionPane.showMessageDialog(null, "Inserção inválida");
				Loja = JOptionPane.showInputDialog("Digite a loja novamente: ");
			}
			
			int confirm = JOptionPane.showConfirmDialog(null, "Certifique se você gerou a carga corretamente, antes de começar as etapas. Deseja mover o arquivo da loja: " + Loja + "?","Verifique a loja",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if(confirm == JOptionPane.NO_OPTION){
				Loja = JOptionPane.showInputDialog("Digite a loja novamente: ");

				while(Integer.parseInt(Loja) < 0 || Integer.parseInt(Loja) > 1000 || Loja.length() != 3){
					JOptionPane.showMessageDialog(null, "Inserção inválida");
					Loja = JOptionPane.showInputDialog("Digite a loja novamente: ");
				}
			}
			
			for(int i = 0;i<listButtonsv15.size();i++)
				listButtonsv15.get(i).setEnabled(true);

			
		} 

	
}
	
}
	
