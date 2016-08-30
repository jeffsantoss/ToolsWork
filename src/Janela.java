import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

import org.w3c.dom.stylesheets.LinkStyle;

import net.miginfocom.swing.MigLayout;

public class Janela extends JFrame implements KeyListener, ActionListener{
	
	private ImageIcon imgfundo	= new ImageIcon(getClass().getResource("/Icons/Layout.png"));
	private ArrayList<JButton> listButtons 	= new ArrayList<JButton>();
	private ArrayList<JPanel> listPanel	= new ArrayList<JPanel>();
	private JComboBox Planilhas,links;
	private	JLabel lblfundo = new JLabel(imgfundo);
	private JLabel lblhora 	= new JLabel();
	private JLabel lblIntro = new JLabel("<html>Sr. operador(a)  "+ System.getProperty("user.name") 
	+" , essa ferramenta irá te proporcionar maior praticidade para executar "
	+"suas aplicações. Bom trabalho!</html>");
	
	public Janela(int x, int y)
	{
		super("Ferramenta Auxiliar - Help Desk v1.1 Developer by Jeff S");
		new Comando("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"cmd /c C:\\ToolsWork\\script\\IniPart.exe");
		setContentPane(new JPanel());
		setLayout(null);
		setResizable(false);
		OrganizarJanela();
		setVisible(true);
		setMinimumSize(new Dimension(x,y));
		setLocationRelativeTo(null);
		URL url = this.getClass().getResource("/Icons/icoJanela.png");  
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);  
		this.setIconImage(iconeTitulo);
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					int test = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar a aplicação?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(test == JOptionPane.YES_OPTION){
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							new Comando("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"cmd /c C:\\ToolsWork\\script\\delPart.exe");
								setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}			else if(test == JOptionPane.NO_OPTION)
										setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);		
					}
				}
			);
	}
	

	public void PainelIntro(){
		listPanel.add(new JPanel(new MigLayout()));
		listPanel.get(0).setBorder(BorderFactory.createLoweredSoftBevelBorder());
		listPanel.get(0).setBounds(0, 0, 805, 65);
					lblIntro.setFont(new Font("Dialog", Font.BOLD, 12));
					listPanel.get(0).add(lblIntro);
						listButtons.add(new JButton("Iniciar"));
						listButtons.add(new JButton("Encerrar"));
									listPanel.get(0).add(listButtons.get(0),"grow");
									listPanel.get(0).add(listButtons.get(1),"wrap");
	}

	
	public void PainelSustentacao(){
		listPanel.add(new JPanel(new MigLayout()));
		listPanel.get(1).setBorder(BorderFactory.createTitledBorder("Sustentar"));
		listPanel.get(1).setBounds(0, 63, 805, 60);
		
		listButtons.add(new JButton("Retaguarda"));
			listButtons.add(new JButton("Teste de Conexão"));
				listButtons.add(new JButton("Controle de Usuários"));
					listButtons.add(new JButton("Senhas Lojas"));
						listButtons.add(new JButton("Gerar BD"));
							listButtons.add(new JButton("Controlar Atendimento"));
		
		listPanel.get(1).add(listButtons.get(2),"gap unrelated");
		listPanel.get(1).add(listButtons.get(3),"gap unrelated");
		listPanel.get(1).add(listButtons.get(4),"gap unrelated");
		listPanel.get(1).add(listButtons.get(5),"gap unrelated");
		listPanel.get(1).add(listButtons.get(6),"gap unrelated");
		listPanel.get(1).add(listButtons.get(7),"gap unrelated");
	}
	
	public void PainelComunic(){
		listPanel.add(new JPanel(new MigLayout()));
				listPanel.get(2).setBorder(BorderFactory.createTitledBorder("Comunicação Interna"));
					listPanel.get(2).setBounds(0,400, 255, 60);
		
		listButtons.add(new JButton("Windows Mail"));
			listButtons.add(new JButton("Spark"));
	
		listPanel.get(2).add(listButtons.get(8),"gap unrelated");
			listPanel.get(2).add(listButtons.get(9),"gap unrelated");
	}
	
	@SuppressWarnings("unchecked")
	public void PanelLinks(){
		links = new JComboBox();
		links.addItem("Intranet");
		links.addItem("CTF");
		links.addItem("Central");
		links.addItem("Site Pmenos");
		links.addItem("Cosmos NET");
		links.addItem("IE - Internet Explorer");
		links.addItem("WebEmail Zimbra");
   		
		listPanel.add(new JPanel(new MigLayout()));
			listPanel.get(3).setBorder(BorderFactory.createTitledBorder("Link(s)"));
				listPanel.get(3).setBounds(260, 400, 230, 60);
		
		listButtons.add(new JButton("Entrar"));
			listPanel.get(3).add(links);
				listPanel.get(3).add(listButtons.get(10));
	}


	public void PanelDocuments(){
		Planilhas = new JComboBox();
			Planilhas.addItem("Planilha lojas");
				Planilhas.addItem("Ramais Matriz");
					Planilhas.addItem("Relação de Ofertas");
				
		
		listPanel.add(new JPanel(new MigLayout()));
			listPanel.get(4).setBorder(BorderFactory.createTitledBorder("Documentos"));
				listPanel.get(4).setBounds(495, 400, 335, 60);
		
		listButtons.add(new JButton("Entrar"));
			listButtons.add(new JButton("Manuais"));
		
		listPanel.get(4).add(Planilhas);
			listPanel.get(4).add(listButtons.get(11));
				listPanel.get(4).add(listButtons.get(12),"gap unrelated");
	}
	
	
	
	public void OrganizarJanela() {
		PainelIntro();
			PainelSustentacao();
				PainelComunic();
					PanelLinks();
						PanelDocuments();
							ToolTipText();
		
		lblfundo.setBounds(0, 0, 800, 500);
		
			for(int i=0; i<listPanel.size();i++){
				listPanel.get(i).setOpaque(false);
			}
				for(int i=0;i<listPanel.size();i++){
					add(listPanel.get(i));
				}
			
		add(lblfundo);
		DesabilitarBotoes();
	}
	
	public void ToolTipText(){
		listButtons.get(0).setToolTipText("<html>Clique aqui para começar sua diária de trabalho!"
										  +"<br>Seja bem vindo. - Atalho F1</html>");	
		listButtons.get(1).setToolTipText("Clique aqui para encerrar - Atalho F2");	
		listButtons.get(2).setToolTipText("Abrir Cosmos Retaguarda - Atalho F3");;	
		listButtons.get(3).setToolTipText("Abrir teste de conexão - Atalho F4");;
		listButtons.get(4).setToolTipText("Abrir o AD - Atalho F5");;
		listButtons.get(5).setToolTipText("Abrir Senhas Lojas - Atalho F6");	
		listButtons.get(6).setToolTipText("Gerar bancos v7 & v15 - Atalho F7");
		listButtons.get(7).setToolTipText("Abrir aplicações para controlar todas suas ligações - Atalho F8)");
		listButtons.get(8).setToolTipText("Abrir Windows Email - Atalho F9");
		listButtons.get(9).setToolTipText("Abrir Spark~Messenger interno - Atalho F10");
		listButtons.get(10).setToolTipText("Escolha o site ao lado e clique aqui - Atalho F11");
		listButtons.get(11).setToolTipText("Escolha o documento/planilha ao lado e clique aqui - Atalho F12");
		listButtons.get(12).setToolTipText("Abrir memorandos de FL & Retarguarda");
		
			for(int i=0;i<listButtons.size();i++){
				listButtons.get(i).addActionListener(this);
				listButtons.get(i).addKeyListener(this);
				listButtons.get(i).setFont(new Font("Times New Roman", Font.BOLD, 11));
				listButtons.get(i).setBackground(Color.WHITE);
			}
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getSource() == listButtons.get(0)){
			HabilitarBotoes();
	}	else if(act.getSource() == listButtons.get(1)){
			DesabilitarBotoes();
	}	else if(act.getSource() == listButtons.get(2)){
			new Comando("cmd /c C:\\CosmosNET\\bin\\CosmosRtNET.exe");	
	}	else if(act.getSource() == listButtons.get(3)){
			new Comando("rundll32 SHELL32.DLL,ShellExec_RunDLL "+ "cmd /c \"K:\\CentralDeServicos\\Teste lojas v4\"  ");
	}	else if(act.getSource() == listButtons.get(4)){
			new Comando("rundll32 SHELL32.DLL,ShellExec_RunDLL "+ "cmd /c K:\\CentralDeServicos\\Admin_AD_v7.3.exe");
	}	else if(act.getSource() == listButtons.get(5)){
			new Comando("cmd /c \"K:\\CentralDeServicos\\senhaslojas\\Senhas Lojas.kdbx\"  ");
	}	else if(act.getSource() == listButtons.get(6)){
			new JanelaCreatedBD(450, 300);	
	}	else if(act.getSource() == listButtons.get(7)){
			AcessoControleAtendimento();
	}	else if(act.getSource() == listButtons.get(8)){
			new Comando("cmd /c C:\\progra~1\\Window~1\\WinMail.exe");
	}	else if(act.getSource() == listButtons.get(9)){
			new Comando("cmd /c K:\\CentralDeServicos\\Spark\\Spark.exe");
	}	else if(act.getSource() == listButtons.get(10)){
			AcessoLinks();
	}	else if(act.getSource() == listButtons.get(11)){
			AcessoPlanilhas();
	}	else if(act.getSource() == listButtons.get(12)){
			new Comando("cmd /c explorer C:\\ToolsWork\\Memorandos\\");
	}	
	}

	
	public void AcessoLinks(){
		JOptionPane.showMessageDialog(null, "<html>O browser aberto serÃ¡ o padrÃ£o da sua mÃ¡quina pra alterar<br>"
										+ "vÃ¡ em Painel Controle -> Propriedades de Internet -> Definir Programas -> Definir Programas padrÃ£o da internet</html>");
		if(links.getSelectedIndex() == 0)
			new Comando("cmd /c C:\\ToolsWork\\Links\\urlIntranet.url");
			else if (links.getSelectedIndex() == 1)
				new Comando("cmd /c C:\\ToolsWork\\Links\\urlCTF.url");
				else if (links.getSelectedIndex() == 2)
					new Comando("cmd /c C:\\ToolsWork\\Links\\urlCentral.url");
					else if (links.getSelectedIndex() == 3)
						new Comando("cmd /c C:\\ToolsWork\\Links\\urlPMENOS.url");
						else if (links.getSelectedIndex() == 4)
							new Comando("cmd /c C:\\ToolsWork\\Links\\urlCosmosNET.url");
								else if (links.getSelectedIndex() == 5)
									new Comando("cmd /c C:\\progra~1\\Intern~1\\iexplore.exe");
										else if (links.getSelectedIndex() == 6)
									new Comando("cmd /c C:\\ToolsWork\\Links\\urlZimbra.url");
	}
	
	public void AcessoPlanilhas(){
		if(Planilhas.getSelectedIndex() == 0)
			new Comando("cmd /c \"C:\\Program Files\\LibreOffice 4\\program\\scalc.exe\" K:\\Tecnologia\\TAB076_Planilha_Pague_Menos.xls");
			else if (Planilhas.getSelectedIndex() == 1)
				new Comando("cmd /c \"C:\\Program Files\\LibreOffice 4\\program\\scalc.exe\" \"K:\\CentralDeServicos\\Ramais Matriz.ods\" ");
				else if (Planilhas.getSelectedIndex() == 2)
					new Comando("cmd /c \"C:\\Program Files\\LibreOffice 4\\program\\scalc.exe\" \"K:\\CentralDeServicos\\Relação de Ofertas.xls\"");
	}
	
	public void AcessoControleAtendimento()
	{
		new Comando("rundll32 SHELL32.DLL,ShellExec_RunDLL " + "cmd /c C:\\ToolsWork\\Control\\ControlCalls.exe");
		//new Comando("cmd /c explorer \"C:\\ToolsWork\\script\\Registro de Atendimento\"  ");

	}
	
	@Override
	public void keyPressed(KeyEvent evt) {
	if(evt.getKeyCode() == KeyEvent.VK_F1)
		HabilitarBotoes();
		else if(evt.getKeyCode() == KeyEvent.VK_F2)
			DesabilitarBotoes();
				else if(evt.getKeyCode() == KeyEvent.VK_F3)
					new Comando("cmd /c C:\\CosmosNET\\bin\\CosmosRtNET.exe");	
					else if(evt.getKeyCode() == KeyEvent.VK_F4)
						new Comando("rundll32 SHELL32.DLL,ShellExec_RunDLL "+ "cmd /c \"K:\\CentralDeServicos\\Teste lojas v4\"  ");
						else if(evt.getKeyCode() == KeyEvent.VK_F5)
							new Comando("rundll32 SHELL32.DLL,ShellExec_RunDLL "+ "cmd /c K:\\CentralDeServicos\\Admin_AD_v7.3.exe");
							else if(evt.getKeyCode() == KeyEvent.VK_F6)
								new Comando("cmd /c \"K:\\CentralDeServicos\\senhaslojas\\Senhas Lojas.kdbx\"  ");
								else if(evt.getKeyCode() == KeyEvent.VK_F7)
									new JanelaCreatedBD(450, 300);	
									else if(evt.getKeyCode() == KeyEvent.VK_F8)
										AcessoControleAtendimento();
										else if(evt.getKeyCode() == KeyEvent.VK_F9)
											new Comando("cmd /c C:\\progra~1\\Window~1\\WinMail.exe");
											else if(evt.getKeyCode() == KeyEvent.VK_F10)
												new Comando("cmd /c K:\\CentralDeServicos\\Spark\\Spark.exe");
												else if(evt.getKeyCode() == KeyEvent.VK_F11)
													AcessoLinks();
													else if(evt.getKeyCode() == KeyEvent.VK_F12)
														AcessoPlanilhas();
	}


	@Override
	public void keyReleased(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_F1)
		{
			HabilitarBotoes();
		}
				
	}



	@Override
	public void keyTyped(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_F1)
		{
			HabilitarBotoes();
		}
			
	}
	
	public void HabilitarBotoes(){
		
			for(int i=0;i<listButtons.size();i++){
				if(i == 0)
					listButtons.get(i).setEnabled(false);
					else
						listButtons.get(i).setEnabled(true);
			}
			
			links.setEnabled(true);
			Planilhas.setEnabled(true);
			this.mostrarHora(true);
	}
	
	public void DesabilitarBotoes(){
		
			for(int i=0;i<listButtons.size();i++) {
				if(i == 0)
					listButtons.get(i).setEnabled(true);
					else
						listButtons.get(i).setEnabled(false);
			}
			
		links.setEnabled(false);
		Planilhas.setEnabled(false);
		this.mostrarHora(false);
	}
	
	public void mostrarHora(boolean mostrar) 
	{		
		AtualizadorHorario ah = new AtualizadorHorario();
		Thread th = ah;
		listPanel.get(0).add(lblhora,"cell 1 1");
		lblhora.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblhora.setForeground(Color.BLACK);
		
		if(mostrar == true) {
			ah.setHr(lblhora);
				th.start();
		}
			else {
			ah.parar();
				listPanel.get(0).remove(3);
		}
	}
	
		
}

