package br.com.fiap.tds.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exemplo02 {

	//Ler o arquivo e exibir os dados
	public static void main(String[] args) {
		
		try {
			//Criar o fluxo de entrada de dados (input stream)
			FileReader inputStream = new FileReader("exemplo01.txt");
			//Instanciar um objeto para ler o arquivo
			BufferedReader arquivo = new BufferedReader(inputStream);
			
			//Ler as linhas do arquivo texto
			String linha;
			while ((linha = arquivo.readLine()) != null) {
				System.out.println(linha);
			}
			
			//Fecha o stream e o arquivo
			inputStream.close();
			arquivo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main
}//classe
