package FileReader;

public class Main {

	public static void main(String[] args) {
		
		//Tempo no inicio
		Long start = System.currentTimeMillis();
		
		Arquivo arquivo = new Arquivo();
		String caminho = "C:\\Temp\\CFGMML\\CFGMML-RNC145-10.145.240.8-20170424070012.txt";
		String dir = "C:\\Temp\\CFGMML";
		arquivo.unzip();
		//arquivo.listarDiretorio(dir);
		//arquivo.lerArquivo(caminho);
		
		//Tempo no final e imprime tempo de execução
		Long finish = System.currentTimeMillis();
		System.out.println(finish - start + " ms");

	}

}
