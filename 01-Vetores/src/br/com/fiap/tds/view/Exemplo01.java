package br.com.fiap.tds.view;

public class Exemplo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declarar um vetor de double
		double[] precos;
		// Inicializar o vetor com 4 posições
		precos = new double[4];

		// Atribuir um valor para a primeira posição do vetor
		precos[0] = 100;

		precos[1] = 200;
		precos[2] = 150;
		precos[3] = 100;

		precos[2] = 400;

		// Exibir o valor da terceira posição do vetor
		System.out.println(precos[2]);

		// Exibir o tamanho do vetor
		System.out.println(precos.length);

		// Exibir os todos os valores armazenados no vetor
		for (int i = 0; i < precos.length; i++) {
			System.out.println(precos[i]);
		}

		System.out.println("FOREACH:");
		// Foreach -> percorre todos as posições do vetor
		for (double item : precos) {
			System.out.println(item);
		}
	}

}
