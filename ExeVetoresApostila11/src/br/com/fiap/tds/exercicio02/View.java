package br.com.fiap.tds.exercicio02;

import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		// Ler a quantidade n�meros
		System.out.println("Digite a quantidade de n�meros: ");
		int quantidade = scan.nextInt();

		// Vetor de n�meros com a quantidade informada pelo usu�rio
		int vetor[] = new int[quantidade];

		// Loop -> Ler os n�meros
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o " + (i + 1) + "� n�mero: ");
			vetor[i] = scan.nextInt();
		}

		int maior = vetor[0];
		// Loop -> Verificar o maior n�mero
		for (int i = 1; i < vetor.length; i++) {
			if (maior < vetor[i]) {
				maior = vetor[i];
			}
		}
		// Exibir o maior n�mero
		System.out.println("Maior n�mero �: " + maior);

		scan.close();
	}

}
