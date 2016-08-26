import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class AtualizadorHorario extends Thread {
	
    private JLabel hr;
    private volatile boolean stop = false;
    
    public JLabel getHr() {
    	return hr;
    }
    
    public void setHr(JLabel hr) {
    	this.hr = hr;
    }
	public AtualizadorHorario(JLabel hora) {
        this.hr = hora;
    }
	
	public AtualizadorHorario() {
    }
    
    @Override
    public void run() {
            while (!stop) {
                Date d = new Date();
                StringBuffer data = new StringBuffer();
                SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
                data.append(sdfData.format(d));
                data.append(" - ");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                this.hr.setText(data.toString()+sdf.format(d));
                this.hr.revalidate();   
            }       
           try {
                Thread.sleep(1000);
          }
          catch (InterruptedException ex) {
            System.out.println("Problema na atualização da data/hora");
            ex.printStackTrace();
        }
    }

	public void parar(){
		this.stop = true;
	}
	
	}