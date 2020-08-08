package br.com.fiap.tds.exercicio02;

import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		// Ler a quantidade números
		System.out.println("Digite a quantidade de números: ");
		int quantidade = scan.nextInt();

		// Vetor de números com a quantidade informada pelo usuário
		int vetor[] = new int[quantidade];

		// Loop -> Ler os números
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o " + (i + 1) + "° número: ");
			vetor[i] = scan.nextInt();
		}

		int maior = vetor[0];
		// Loop -> Verificar o maior número
		for (int i = 1; i < vetor.length; i++) {
			if (maior < vetor[i]) {
				maior = vetor[i];
			}
		}
		// Exibir o maior número
		System.out.println("Maior número é: " + maior);

		scan.close();
	}

}
