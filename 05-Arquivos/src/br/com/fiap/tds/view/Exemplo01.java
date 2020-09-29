package br.com.fiap.tds.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exemplo01 {

	//Gravar informações em um arquivo
	public static void main(String[] args) {
		
		try {
			//Criar um fluxo de saída de dados (output stream)
			FileWriter output = new FileWriter("exemplo01.txt");
			//Instanciar um objeto para escrever no arquivo
			PrintWriter arquivo = new PrintWriter(output);
			
			//Escrever no arquivo
			arquivo.print("Exemplo de escrita em arquivo");
			
			System.out.println("Gravando no arquivo..");
			
			//Fechar o arquivo e o stream
			arquivo.close();
			output.close();			
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
	}//main
	
}//classe