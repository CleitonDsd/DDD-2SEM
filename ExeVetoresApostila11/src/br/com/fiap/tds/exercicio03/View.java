package br.com.fiap.tds.exercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		// Ler a quantidade de alunos
		System.out.println("Digite a qtd de alunos");
		int qtd = leitor.nextInt();

		// Criar uma lista de alunos
		List<Aluno> alunos = new ArrayList<Aluno>();

		// Loop -> Ler o nome e as notas do aluno
		for (int i = 0; i < qtd; i++) {
			System.out.println("Digite o nome do aluno");
			String nome = leitor.next();

			// Criar uma lista com as notas do aluno
			List<Float> notas = new ArrayList<Float>();

			for (int j = 0; j < 3; j++) {

				System.out.println("Digite a nota " + (j + 1) + " do aluno");
				notas.add(leitor.nextFloat());

			}

			// Criar um aluno e adicionar no vetor
			alunos.add(new Aluno());

		}

		// Variável que armazena a maior nota do primeiro aluno da lista
		float maiorNota = alunos.get(0).recuperarMaiorNota();

		// Loop -> identificar o aluno com a maior nota
		for (int i = 1; i < alunos.size(); i++) {
			if (maiorNota < alunos.get(i).recuperarMaiorNota()) {
				maiorNota = alunos.get(i).recuperarMaiorNota();
			}
		}

		List<String> nomes = new ArrayList<String>();
		for (Aluno a : alunos) {
			if (a.recuperarMaiorNota() == maiorNota) {
				nomes.add(a.getNome());
			}
		}

		// Informar o aluno com a maior nota
		System.out.println("Maior nota " + maiorNota);
		for (String nome : nomes) {
			if (nome != null)
				System.out.println(nome);
		}

		leitor.close();
	}

}