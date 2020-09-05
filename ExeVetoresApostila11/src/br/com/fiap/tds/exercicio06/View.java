package br.com.fiap.tds.exercicio06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		// Ler a quantidade de números
		System.out.println("Digite a quantidade de números");
		int qtd = leitor.nextInt();

		// Criar a lista
		List<Short> lista = new ArrayList<Short>();

		// Loop -> carregar o vetor com os primeiros números ímpares
		for (short i = 1; i < qtd * 2; i += 2) {
			lista.add(i);
		}

		// Loop -> exibir os valores
		for (short x : lista) {
			System.out.println(x);
		}

		leitor.close();
	}

}