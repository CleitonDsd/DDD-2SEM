package br.com.fiap.tds.exercicio08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	// Obs. Uma solu��o melhor � ordenar o vetor para determinar os valores iguais.
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		// Criar uma lista
		List<Character> lista = new ArrayList<Character>();

		// Loop -> ler os valores da lista
		for (int i = 0; i < 30; i++) {
			System.out.println("Digite o " + (i + 1) + " caractere:");
			lista.add(leitor.next().charAt(0)); // L� uma string, mas armazena somente o primeiro char
		}

		// Lista auxiliar para armazenar os valores iguais
		List<Character> iguais = new ArrayList<Character>();

		// Loop -> verificar se existe valores iguais (percorre cada posi��o da lista e
		// valida se a lista possui valor igual)
		for (int i = 0; i < lista.size(); i++) {
			// Valor que ser� validado se possui igual no vetor
			char c = lista.get(i);
			// Verifica se "c" existe em alguma posi��o na lista que n�o seja ele mesmo e se
			// o c j� est� na lista de iguais
			if ((lista.indexOf(c) != i || lista.lastIndexOf(c) != i) && !iguais.contains(c)) {
				iguais.add(c);
			}
		}

		// Exibe os valores do vetor
		for (char c : lista) {
			System.out.print(c + " ");
		}

		// Exibe a qtd de valores iguais encontrados
		System.out.println("\n\nValores iguais: " + iguais.size());
		// Exibe os valore iguais encontrados
		for (char c : iguais) {
			System.out.println(c);
		}

		leitor.close();
	}

}