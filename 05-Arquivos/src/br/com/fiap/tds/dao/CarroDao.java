package br.com.fiap.tds.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Carro;

/**
 * Classe responsável por gravar e ler os carros de uma fonte de dados (arquivo)
 * @author Thiago Yamamoto
 */
public class CarroDao {
	
	/**
	 * Grava um carro no arquivo (valores separados por "," - virgula)
	 * @param carro Objeto carro
	 */
	public void gravar(Carro carro) throws IOException {
		//true no construtor -> para escrever no final do arquivo, sem sobrescrever
		FileWriter outputStream = new FileWriter("carros.txt", true);
		PrintWriter arquivo = new PrintWriter(outputStream);
		arquivo.println(carro.getModelo() + "," + carro.getAno() + "," + carro.getMarca());
		
		outputStream.close();
		arquivo.close();
	}
	
	/**
	 * Lê todos os carros do arquivo
	 * @return List<Carro> lista de carros
	 * @throws FileNotFoundException 
	 */
	public List<Carro> ler() throws FileNotFoundException, IOException {
		FileReader inputStream = new FileReader("carros.txt");
		BufferedReader arquivo = new BufferedReader(inputStream);
		
		String linha;
		
		//Lista que armazena todos os carros do arquivo
		List<Carro> lista = new ArrayList<Carro>();
		
		while ((linha = arquivo.readLine()) != null) {
			//Separar as strings através da virgula
			String[] vetor = linha.split(",");
			//Cria o objeto carro
			Carro carro = new Carro(vetor[0], Integer.parseInt(vetor[1]), vetor[2]);
			lista.add(carro);
		}
		
		//Fechar
		arquivo.close();
		inputStream.close();
		
		return lista; //retorna a lista de carros
	}
	
}



