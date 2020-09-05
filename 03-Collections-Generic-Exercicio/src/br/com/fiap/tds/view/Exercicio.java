package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Aluno;

public class Exercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Estrutura de dados para armazenar os alunos (rm, aluno)
		Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();

		// Lê os alunos
		do {
			int rm = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM"));
			String nome = JOptionPane.showInputDialog("Digite o nome");
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));

			// Notas do aluno
			List<Float> notas = new ArrayList<Float>();

			do {
				float nota = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota do aluno"));
				notas.add(nota); // adiciona a nota do aluno na lista
			} while (JOptionPane.showConfirmDialog(null, "Deseja adicionar mais notas?") == JOptionPane.YES_OPTION);

			// Instancia o aluno
			Aluno aluno = new Aluno(rm, nome, idade, notas);
			// Adiciona o aluno no mapa
			alunos.put(rm, aluno);

		} while (JOptionPane.showConfirmDialog(null, "Deseja adicionar mais um aluno?") == JOptionPane.YES_OPTION);

		int totalIdade = 0;
		int maiorIdade = 0;
		int menorIdade = 0;
		float totalNotas = 0;

		// Percorre os alunos através da chave (rm) para calcular os valores
		for (Integer rm : alunos.keySet()) {
			Aluno aluno = alunos.get(rm); // recupera o aluno do mapa através da chave
			totalNotas += aluno.getMedia();
			totalIdade += aluno.getIdade();

			if (maiorIdade < aluno.getIdade()) {
				maiorIdade = aluno.getIdade();
			}

			if (menorIdade > aluno.getIdade() || menorIdade == 0) {
				menorIdade = aluno.getIdade();
			}
		}

		// Exibe os dados:
		JOptionPane.showMessageDialog(null,
				"Total de alunos: " + alunos.size() + "\nMédia de notas: " + totalNotas / alunos.size()
						+ "\nMédia de idades: " + totalIdade / alunos.size() + "\nMaior idade: " + maiorIdade
						+ "\nMenor idade: " + menorIdade);

		// Opção do menu
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(
					"1 - Consultar aluno por RM \n2 - Exibir alunos \n3 - Nomes e médias \n4 - Nomes e idades \n5 - Médias acima de 6 \n6 - Excluir meno que média 3 \n7 - Excluir por RM \n8 - Sair"));

			switch (op) {
			case 1:
				// Exibir os dados de um aluno pesquisando pelo RM
				int rm = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM"));
				if (alunos.containsKey(rm))
					JOptionPane.showMessageDialog(null, alunos.get(rm));
				else
					JOptionPane.showMessageDialog(null, "Aluno não encontrado");
				break;
			case 2:
				// Exibir todos os RM e nomes dos alunos
				for (Aluno aluno : alunos.values()) {
					JOptionPane.showMessageDialog(null, aluno.getRm() + " - " + aluno.getNome());
				}
				break;
			case 3:
				// Exibir o nome e médias dos alunos em ordem crescente
				// Recupera os valores do mapa em uma lista
				List<Aluno> lista = new ArrayList<Aluno>(alunos.values());

				// Ordena a lista de acordo com o método compare
				Collections.sort(lista, new Comparator<Aluno>() {
					@Override
					public int compare(Aluno o1, Aluno o2) {
						return Math.round(o1.getMedia() - o2.getMedia());
					}
				});

				for (Aluno aluno : lista) {
					JOptionPane.showMessageDialog(null, aluno.getNome() + " - " + aluno.getMedia());
				}

				break;
			case 4:
				// Exibir o nome e idades dos alunos em ordem crescente
				// Recupera os valores do mapa em uma lista
				lista = new ArrayList<Aluno>(alunos.values());

				// Ordena a lista de acordo com o método compare
				Collections.sort(lista, new Comparator<Aluno>() {
					@Override
					public int compare(Aluno o1, Aluno o2) {
						return o1.getIdade() - o2.getIdade();
					}
				});

				for (Aluno aluno : lista) {
					JOptionPane.showMessageDialog(null, aluno.getNome() + " - " + aluno.getIdade());
				}
				break;
			case 5:
				// Imprimir alunos com média acima de 6
				for (Aluno aluno : alunos.values()) {
					if (aluno.getMedia() > 6)
						JOptionPane.showMessageDialog(null, aluno);
				}
				break;
			case 6:
				// Remover alunos com média menor que 3
				Set<Integer> chaves = new HashSet<Integer>();
				for (int codigo : alunos.keySet()) {
					if (alunos.get(codigo).getMedia() < 3)
						chaves.add(codigo);
				}
				for (Integer i : chaves) {
					alunos.remove(i);
				}
				break;
			case 7:
				// Remover o aluno pelo RM
				rm = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM"));
				alunos.remove(rm);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Obrigado!");
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}

		} while (op != 8);

	}// main

}// classe