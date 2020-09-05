package br.com.fiap.tds.view;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exemplo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Criar um mapa
		Map<String, String> mapa = new HashMap<String, String>();

		// Adicionar valores no mapa
		// (Chave, Valor)
		mapa.put("SP", "São Paulo");
		mapa.put("AM", "Manaus");
		mapa.put("PE", "Recife");

		// Recuperar os valores
		System.out.println("Valor da chave PE: " + mapa.get("PE"));

		mapa.put("SP", "Rio de Janeiro"); // Altera o valor

		System.out.println("Valor da chave SP: " + mapa.get("SP"));

		// Verificar se existe uma chave
		System.out.println("Existe a chave MG: " + mapa.containsKey("MG"));

		// Verificar se existe um valor
		System.out.println("Existe o valor Recife: " + mapa.containsValue("Recife"));

		// Exibir a quantidade de mapeamentos
		System.out.println("Quantidade: " + mapa.size());

		// Verificar se o mapa está vazio
		System.out.println("Mapa vazio: " + mapa.isEmpty());

		// Remover um mapeamento
		mapa.remove("SP");
		System.out.println(mapa.get("SP")); // retorna null

		// Recuperar todas as chaves
		Set<String> chaves = mapa.keySet();
		for (Object chave : chaves) {
			System.out.println("Chave: " + chave + " - " + mapa.get(chave));
		}

		// Recuperar todos os valores
		Collection<String> valores = mapa.values();
		for (Object valor : valores) {
			System.out.println("Valores: " + valor);
		}
	}

}
