package br.com.fiap.tds.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Crie um programa em Java para ler um arquivo texto, 
 * onde cada linha contém dois números inteiros separados por vírgula. 
 * Este programa deve utilizar o arquivo de entrada citado acima para gerar 
 * um arquivo com 3 campos, sendo o terceiro o valor da soma dos outros dois citados 
 * anteriormente.
 */
public class Exercicio02 {

	public static void main(String[] args) {
		
		try {
			//Ler o arquivo numeros.txt
			FileReader inputStream = new FileReader("numeros.txt");
			BufferedReader arquivoLeitura = new BufferedReader(inputStream);
			
			//Gerar o arquivo calculo.txt
			FileWriter outputStream = new FileWriter("calculo.txt");
			PrintWriter arquivoEscrita = new PrintWriter(outputStream);
			
			//Ler as linhas do arquivo e escrever o resultado
			String linha;
			
			while ((linha = arquivoLeitura.readLine()) != null) {
				//Separar os números através da ","
				String[] numeros = linha.split(",");
				//Conveter as string em número
				int n1 = Integer.parseInt(numeros[0]);
				int n2 = Integer.parseInt(numeros[1]);
				
				int soma = n1 + n2;
				
				arquivoEscrita.println(n1 +  "," + n2 + "," + soma);
			}
			
			System.out.println("Calculos realizados!");
					
			//Fechar os recursos
			arquivoLeitura.close();
			inputStream.close();
			arquivoEscrita.close();
			outputStream.close();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}//main
}//classe
