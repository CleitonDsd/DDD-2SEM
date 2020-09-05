package br.com.fiap.tds.exercicio07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		// Criar a lista
		List<Double> lista = new ArrayList<Double>();

		// Loop -> ler os números
		for (int i = 0; i < 16; i++) {
			System.out.println("Digite o " + (i + 1) + " número");
			lista.add(leitor.nextDouble());
		}

		// Loop -> exibe a lista
		System.out.println("Lista original");
		System.out.print("[");
		for (int i = 0; i < lista.size(); i++) {
			// Identifica se não é o último número para não colocar a virgula
			if (i != lista.size() - 1)
				System.out.print(lista.get(i) + ", ");
			else
				System.out.print(lista.get(i));
		}
		System.out.print("]");

		// Lista auxiliar para armazenar os 8 primeiros números
		List<Double> aux = new ArrayList<Double>();

		// Loop -> armazena os 8 primeiros números no vetor auxiliar e coloca os valores
		// das 8 últimas posições nas primeiras
		for (int i = 0; i < 8; i++) {
			aux.add(lista.get(i));
			lista.set(i, lista.get(i + 8));
		}

		// Loop -> utiliza o vetor auxiliar para colocar os primeiros números nas
		// ultimas posições
		for (int i = 0; i < 8; i++) {
			lista.set(i + 8, aux.get(i));
		}

		// Loop -> exibe a lista final
		System.out.println("\nLista final");
		System.out.print("[");
		for (int i = 0; i < lista.size(); i++) {
			// Identifica se não é o último número para não colocar a virgula
			if (i != lista.size() - 1)
				System.out.print(lista.get(i) + ", ");
			else
				System.out.print(lista.get(i));
		}
		System.out.print("]");

		leitor.close();
	}

}