package FileReader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Arquivo {

	FileReader fileReader = null;
	BufferedReader bufferedReader = null;
	
	///testando o git mais uma vez
	//teste 3
	//Ler arquivo
	//quarta vez
	//quinta vez
	//sexta vez
	//setima vez
	//oitava vez cccc
	public void lerArquivo(String caminho){
		
		try {
			fileReader = new FileReader(caminho);
			bufferedReader = new BufferedReader(fileReader);
			String line;
			
			while((line = bufferedReader.readLine()) != null){
				
				//System.out.println(line);
				
			}
			fileReader.close();
			System.out.println("Final");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void listarDiretorio(String caminhoDiretorio){
		
		File file = new File(caminhoDiretorio);
		File dirFile[] = file.listFiles();
		for(int i = 0; i < dirFile.length; i++){
			File f = dirFile[i];
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getName());
		}
	}
	
	public void unzip(){
		
		int buffer = 2048;
		BufferedOutputStream dest = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Temp\\CFGMML\\CFGMML-RNC145-10.145.240.8-20170424070012.zip");
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			ZipEntry entry;
			while((entry = zis.getNextEntry()) != null){
				System.out.println("Extracting: " + entry);
				int count;
				byte data[] = new byte[buffer];
				//Write files to the disk
				FileOutputStream fos = new FileOutputStream("C:\\Temp\\CFGMML\\" + entry.getName());
				dest = new BufferedOutputStream(fos,  buffer);
				while((count = zis.read(data, 0, buffer)) != 1){
					
					dest.write(data, 0, count);
					
				}
				dest.flush();
				dest.close();
				System.out.println(entry);
			}
			zis.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
