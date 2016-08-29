import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactador {
   
   //Constantes
   static final int TAMANHO_BUFFER = 4096; // 4kb
   
   //método para compactar arquivo
   public static void compactarParaZip(String arqSaida,String diretorio,final String extensao)
throws IOException{
       int cont;
       byte[] dados = new byte[TAMANHO_BUFFER];
                   
       BufferedInputStream origem = null;
       FileInputStream streamDeEntrada = null;
       FileOutputStream destino = null;
       ZipOutputStream saida = null;
       ZipEntry entry = null;
       
       FileFilter filter = new FileFilter() {
    	    public boolean accept(File file) {
    	        return file.getName().endsWith(extensao);
    	    }
    	};
    	
    	File dir = new File(diretorio);
    	File[] files = dir.listFiles(filter);
       
       try {
            destino = new FileOutputStream(new File(arqSaida));
            saida = new ZipOutputStream(new BufferedOutputStream(destino));
            File file = new File(diretorio+files[0].getName());
            streamDeEntrada = new FileInputStream(file);
            origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
            entry = new ZipEntry(file.getName());
            saida.putNextEntry(entry);
                       
            while((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
                saida.write(dados, 0, cont);
            }
            origem.close();
            saida.close();
        } catch(IOException e) {
            throw new IOException(e.getMessage());
        }
   }
}
