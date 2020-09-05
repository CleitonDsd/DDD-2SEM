package br.com.fiap.tds.exercicio05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leitor = new Scanner(System.in);

		// Ler a qtd de números que será informado
		System.out.println("Digite a qtd de números");
		int qtd = leitor.nextInt();

		// Criar a lista
		List<Double> lista = new ArrayList<Double>();

		// Loop -> ler os números
		for (int i = 0; i < qtd; i++) {
			System.out.println("Digite o número " + (i + 1));
			lista.add(leitor.nextDouble());
		}

		// Loop -> para exibir a sequencia na ordem contrária
		for (int i = lista.size() - 1; i >= 0; i--) {
			System.out.println(lista.get(i));
		}

		leitor.close();
	}

}