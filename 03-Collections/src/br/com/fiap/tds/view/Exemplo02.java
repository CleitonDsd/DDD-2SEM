package br.com.fiap.tds.view;

import java.util.HashSet;
import java.util.Set;

public class Exemplo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List nomes = Arrays.asList(new String[]{"",""});

		// Criar um conjunto (Set)
		Set<String> conjunto = new HashSet<String>();

		// Adicionar valores no conjunto
		conjunto.add("Segunda");
		conjunto.add("Terça");

		conjunto.add("Segunda"); // ignorado

		// Remover um elemento do conjunto
		conjunto.remove("Segunda");

		// Exibir a quantidade de elementos no conjunto
		System.out.println("Quantidade de elementos: " + conjunto.size());

		// Verificar se "Segunda" está no conjunto
		System.out.println("Segunda está no conjunto: " + conjunto.contains("Segunda"));

		// Verificar se o conjunto está vazio
		System.out.println("Conjunto está vazio: " + conjunto.isEmpty());

		// Loop
		for (String item : conjunto) {
			System.out.println(item);
		}

		// Remover todos os elementos do conjunto
		conjunto.clear();

		// Transforma o conjunto no vetor
		Object[] vetor = conjunto.toArray();
	}

}
