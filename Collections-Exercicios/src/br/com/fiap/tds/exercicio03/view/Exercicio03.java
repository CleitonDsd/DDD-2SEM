package br.com.fiap.tds.exercicio03.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Criar um mapa (chave = UF, valores = DDDs)
		Map<String, Set<Integer>> mapa = new HashMap<String, Set<Integer>>();

		int opcao;
		do {

			// Ler a opção desejada
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n1-Adicionar \n2-Consultar \n3-Sair"));

			switch (opcao) {
			case 1:
				// Ler o estado
				String estado = JOptionPane.showInputDialog("Digite o estado (Sigla)");
				// Loop -> Ler os ddds até o usuário
				int op; // escolha se vai cadastrar mais ddds
				// Verifica se o estado já está mapeado
				Set<Integer> conjunto;
				if (mapa.containsKey(estado)) {
					conjunto = mapa.get(estado); // armazena os ddds no conjunto do estado
				} else {
					conjunto = new HashSet<Integer>(); // armazena os ddds em um novo conjunto
				}
				do {
					int ddd = Integer.parseInt(JOptionPane.showInputDialog("Digite o DDD"));
					conjunto.add(ddd); // armazena o ddd no conjunto
					op = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais um DDD?");
				} while (op == JOptionPane.YES_OPTION);
				// Adicionar o mapeamento
				mapa.put(estado, conjunto);
				break;
			case 2:
				// Ler o estado
				estado = JOptionPane.showInputDialog("Digite o estado (Sigla)");
				// Valida se o estado está cadastrado
				if (mapa.containsKey(estado)) {
					System.out.println(mapa.get(estado));
				} else {
					System.out.println("Estado não encontrado");
				}
				break;
			case 3:
				System.out.println("Obrigado! Volte sempre!");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}

		} while (opcao != 3);
	}// main
}// classe