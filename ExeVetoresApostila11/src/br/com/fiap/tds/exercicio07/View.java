package br.com.fiap.tds.exercicio07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		// Criar a lista
		List<Double> lista = new ArrayList<Double>();

		// Loop -> ler os n�meros
		for (int i = 0; i < 16; i++) {
			System.out.println("Digite o " + (i + 1) + " n�mero");
			lista.add(leitor.nextDouble());
		}

		// Loop -> exibe a lista
		System.out.println("Lista original");
		System.out.print("[");
		for (int i = 0; i < lista.size(); i++) {
			// Identifica se n�o � o �ltimo n�mero para n�o colocar a virgula
			if (i != lista.size() - 1)
				System.out.print(lista.get(i) + ", ");
			else
				System.out.print(lista.get(i));
		}
		System.out.print("]");

		// Lista auxiliar para armazenar os 8 primeiros n�meros
		List<Double> aux = new ArrayList<Double>();

		// Loop -> armazena os 8 primeiros n�meros no vetor auxiliar e coloca os valores
		// das 8 �ltimas posi��es nas primeiras
		for (int i = 0; i < 8; i++) {
			aux.add(lista.get(i));
			lista.set(i, lista.get(i + 8));
		}

		// Loop -> utiliza o vetor auxiliar para colocar os primeiros n�meros nas
		// ultimas posi��es
		for (int i = 0; i < 8; i++) {
			lista.set(i + 8, aux.get(i));
		}

		// Loop -> exibe a lista final
		System.out.println("\nLista final");
		System.out.print("[");
		for (int i = 0; i < lista.size(); i++) {
			// Identifica se n�o � o �ltimo n�mero para n�o colocar a virgula
			if (i != lista.size() - 1)
				System.out.print(lista.get(i) + ", ");
			else
				System.out.print(lista.get(i));
		}
		System.out.print("]");

		leitor.close();
	}

}