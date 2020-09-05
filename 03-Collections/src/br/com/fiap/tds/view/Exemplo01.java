package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

public class Exemplo01 {

	public static void main(String[] args) {

		// Declara e inicializa uma lista
		List<String> alunos = new ArrayList<String>();

		// Adicionar alunos na lista
		alunos.add("Lucas");
		alunos.add("Carlos");

		// Adicionar um aluno em uma posição específica
		alunos.add(0, "Aline");

		// Sobrescreve o elemento do index informado
		alunos.set(0, "Alison");

		// Exibir todos os elementos da lista
		System.out.println("FOR NORMAL:");
		for (int i = 0; i < alunos.size(); i++) {
			System.out.print(alunos.get(i) + " ");
		}

		System.out.println("\nFOREACH:");
		// declaração da variável que recebe cada um dos itens da lista : a coleção
		for (String item : alunos) {
			System.out.print(item + " ");
		}

		// Recupera a primeira posição do objeto "Carlos" na lista
		System.out.println("\nPrimeira ocorrência do Carlos na lista: " + alunos.indexOf("Carlos"));

		// Obter parte de uma lista (primeiro inclui, segundo exclui)
		List<String> grupo = alunos.subList(1, 3);

		// Exibir os integrantes do grupo
		System.out.println("Integrantes do grupo");
		for (String aluno : grupo) {
			System.out.println(aluno);
		}

		// Recuperar um elemento da lista pelo index
		System.out.println("\nPosição 1: " + alunos.get(1));

		// Exibir a quantidade de alunos na lista
		System.out.println("Qtd de alunos: " + alunos.size());

		// Remove o Carlos da lista
		alunos.remove("Carlos");
		// Remove pelo index
		alunos.remove(0);

		// Valida se a lista contém o Carlos
		if (alunos.contains("Carlos")) {
			System.out.println("Carlos está na lista");
		} else {
			System.out.println("Carlos não está na lista");
		}

		// Remove todos os elementos da lista
		alunos.clear();

		// Valida se a lista está vazia
		if (alunos.isEmpty()) {
			System.out.println("A lista está vazia");
		} else {
			System.out.println("A lista contém elementos");
		}

		// Transforma uma lista em um vetor
		Object[] vetor = alunos.toArray();
	}
}
