package br.com.fiap.tds.exercicio02.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.tds.exercicio02.bean.Aluno;

public class Exercicio02 {
	public static void main(String[] args) {
		// Cria uma lista de alunos
		List<Aluno> lista = new ArrayList<Aluno>();

		// Ler a quantidade de alunos (precisa converter a String para int)
		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a qtd de alunos"));

		// Percorre a qtd de vezes informado
		for (int i = 0; i < qtd; i++) {
			// L� o nome
			String nome = JOptionPane.showInputDialog("Digite o nome do aluno");
			// L� a idade do aluno
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));

			// Lista de notas do aluno
			List<Float> notas = new ArrayList<Float>();

			String op; // Vari�vel que armazena a op��o do usu�rio

			// Loop para ler as notas do aluno
			do {
				// L� a nota
				float nota = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota"));
				// Adiciona a nota na lista de notas
				notas.add(nota);
				// L� se vai adicionar mais uma nota
				op = JOptionPane.showInputDialog("Deseja inserir mais uma nota? S/N");
			} while (op.equals("S"));

			// Inserir o aluno na lista
			lista.add(new Aluno(nome, idade, notas));
			// Aluno aluno = new Aluno(nome, idade,notas);
			// lista.add(aluno);

		} // for

		int maiorIdade = 0; // armazena a maior idade
		int menorIdade = lista.get(0).getIdade(); // armazena a menor idade
		float somaMedias = 0; // soma das m�dias dos alunos
		int somaIdades = 0; // soma das idades dos alunos
		// Processar os dados - Percorre a lista de alunos
		for (Aluno item : lista) {
			somaIdades += item.getIdade(); // adiciona a idade no somat�rio
			somaMedias += item.getMedia(); // adiciona a m�dia no somat�rio

			if (maiorIdade < item.getIdade()) // valida se a idade � maior
				maiorIdade = item.getIdade();

			if (menorIdade > item.getIdade()) // valida se a idade � menor
				menorIdade = item.getIdade();
		}

		System.out.println(lista); // Imprime a lista

		// Exibir o resultado
		System.out.println("Total de aluno: " + lista.size());
		System.out.println("M�dia geral de notas: " + somaMedias / lista.size());
		System.out.println("M�dia geral de idade: " + somaIdades / lista.size());
		System.out.println("Maior idade: " + maiorIdade);
		System.out.println("Menor idade: " + menorIdade);

		/*
		 * i) Imprimir os nomes e m�dias de todos os alunos ii) Imprimir apenas os nomes
		 * dos alunos que possuem m�dia acima de 6.0 iii) Imprimir apenas os nomes dos
		 * alunos que possuem idade acima de 30 anos iv) Excluir os alunos com m�dias
		 * menores que 3.0 v) Sair do sistema
		 */

		int op = Integer.parseInt(JOptionPane.showInputDialog("Escolha a op��o: " + "\n 1-Nomes e m�dias"
				+ "\n 2-Alunos acima de 6 " + "\n 3-Alunos acima de 30 anos "
				+ "\n 4-Excluir alunos com m�dia menor que 3 " + "\n 5-Sair"));

		while (op != 5) {

			switch (op) {
			case 1:
				System.out.println("Nomes e m�dias:");
				for (Aluno aluno : lista) {
					System.out.println(aluno.getNome() + " " + aluno.getMedia());
				}
				break;
			case 2:
				System.out.println("Alunos com m�dia acima de 6");
				for (Aluno aluno : lista) {
					if (aluno.getMedia() > 6)
						System.out.println(aluno.getNome());
				}
				break;
			case 3:
				System.out.println("Alunos acima de 30 anos");
				for (Aluno aluno : lista) {
					if (aluno.getIdade() > 30)
						System.out.println(aluno.getNome());
				}
				break;
			case 4:
				System.out.println("Remove alunos com m�dia menor que 3");
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getMedia() < 3) {
						lista.remove(i);
						i--;
					}
				}
				break;
			default:
				System.out.println("Op��o inv�lida");
			}// switch

			op = Integer.parseInt(JOptionPane.showInputDialog("Escolha a op��o: " + "\n 1-Nomes e m�dias"
					+ "\n 2-Alunos acima de 6 " + "\n 3-Alunos acima de 30 anos "
					+ "\n 4-Excluir alunos com m�dia menor que 3 " + "\n 5-Sair"));

		} // while //CTRL + SHIFT + F - Formata o c�digo

		System.out.println("Saindo do sistema...");

	}// main

}// classe