package br.com.fiap.tds.exercicio01;

import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		// Ler a quantidade de produtos
		System.out.println("Digite a quantidade de produtos: ");
		int posicoes = scan.nextInt();

		// Declarar o vetor de produtos com quantidade informada
		Produto[] vetor = new Produto[posicoes];
		/*
		 * Loop -> Para ler todos os dados do ptoduyo, instanciar o produto e adicionar
		 * no vetor
		 */
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o preço R$: ");
			double preco = scan.nextDouble();

			System.out.println("Digite a quantidade: ");
			int quantidade = scan.nextInt();

			System.out.println("Digite o desconto (%): ");
			double desconto = scan.nextDouble();

			Produto produto = new Produto(quantidade, preco, desconto);

			// adiciona o objeto produto no vetor
			vetor[i] = produto;
		}

		// variável para armazenar o valor total
		double valorTotal = 0;

		// Loop -> para calcular o valor total
		for (Produto produto : vetor) {
			System.out.println("Preço (R$): " + produto.getPreco() + "\nQuantidade: " + produto.getQuantidade()
					+ "\nDesconto (%): " + produto.getDesconto());
			valorTotal += produto.getPreco() * produto.getQuantidade() * (100 - produto.getDesconto()) / 100;
			System.out.println("___________________");
		}
		// Exibir o valor total
		System.out.println("Valor Total (R$): " + valorTotal);
		scan.close();
	}

}
