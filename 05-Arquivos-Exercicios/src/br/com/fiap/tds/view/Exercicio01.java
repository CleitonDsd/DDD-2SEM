package br.com.fiap.tds.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Crie um programa em Java para ler um arquivo texto e escrever apenas os 
 * caracteres alfabéticos(letras) e o espaço para um arquivo de destino. 
 * Números e caracteres especiais devem ser desconsiderados.
 */

public class Exercicio01 {

	public static void main(String[] args) {
		
		try {
			//Ler o arquivo
			FileReader inputStream = new FileReader("entrada.txt");
			BufferedReader arquivoLeitura = new BufferedReader(inputStream);
			
			//Escrever o arquivo
			FileWriter outputStream = new FileWriter("saida.txt");
			PrintWriter arquivoEscrita = new PrintWriter(outputStream);
			
			String linha;
			
			//Percorrer todas as linhas
			while((linha = arquivoLeitura.readLine()) != null) {
				//Escrever no arquivo o texto sem os caracteres especiais e números
				arquivoEscrita.println(linha.replaceAll("[^A-z ]", ""));
			}
			
			//Fechar os recursos
			arquivoLeitura.close();
			inputStream.close();
			arquivoEscrita.close();
			outputStream.close();
			
			System.out.println("Arquivo processado!");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		/*
		String texto = "asdfasdf 283402sdfa(sdfé";
		
		//Validar se o texto contem somente caracteres A-z
		boolean ok = texto.matches("[A-z]*");
		
		System.out.println("Contem somente letras: " + ok);
		
		//Substituir os caracteres especiais e números por ""
		texto = texto.replaceAll("[^A-z ]", "");
		
		System.out.println(texto);
		*/
		
	}
	
}
