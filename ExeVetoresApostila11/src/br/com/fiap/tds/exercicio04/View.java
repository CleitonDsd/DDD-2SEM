package br.com.fiap.tds.exercicio04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitor = new Scanner(System.in);

		// Ler a quantidade de pessoas
		System.out.println("Digite a quantidade de pessoas");
		int qtd = leitor.nextInt();

		// Criar a lista
		List<Integer> lista = new ArrayList<Integer>();

		// Loop -> ler a idade das pessoas
		for (int i = 0; i < qtd; i++) {
			System.out.println("Digite a idade da pessoa " + (i + 1));
			lista.add(leitor.nextInt());
		}

		// Criar a vari�vel de eleitores obrigat�rios
		int obrigatorios = 0;

		// Loop -> determinar a classe eleitoral e somar o nr de eleitores obrigat�rios
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) < 16) {
				System.out.println("Pessoa " + (i + 1) + ": N�o eleitor");
			} else if (lista.get(i) >= 18 && lista.get(i) <= 65) {
				System.out.println("Pessoa " + (i + 1) + " : Eleitor obrigat�rio");
				obrigatorios++;
			} else {
				System.out.println("Pessoa " + (i + 1) + " : Eleitor facultativo");
			}
		}

		// Exibir a qtd de eleitore obrigat�rios
		System.out.println("Total de eleitores obrigat�rios: " + obrigatorios);

		leitor.close();
	}
}