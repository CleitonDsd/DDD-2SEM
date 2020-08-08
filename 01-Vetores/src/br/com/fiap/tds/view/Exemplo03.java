package br.com.fiap.tds.view;

import br.com.fiap.tds.bean.Boletim;
import br.com.fiap.tds.bean.Disciplina;

public class Exemplo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instanciar uma classe Boletim com o nome e um vetor com 9 posições
		Boletim boletim = new Boletim("Joaozinho", new Disciplina[9]);

		// Recupera o vetor de disciplina do boletim
		Disciplina[] vetor = boletim.getDisciplinas();

		// Atribuir algumas disciplinas no vetor
		vetor[0] = new Disciplina("Web", 10);
		vetor[1] = new Disciplina("Banco de Dados", 9.5f);

		// Setou o vetor de disciplina no boletim
		boletim.setDisciplinas(vetor);

		// Exibir o nome e a nota da disciplina da primeira posição do boletim
		System.out.println(boletim.getNome() + " " + boletim.getDisciplinas()[0].getNome() + " "
				+ boletim.getDisciplinas()[0].getNota());

		// Exibir as disciplinas do boletim
		for (Disciplina item : boletim.getDisciplinas()) {
			if (item != null)
				System.out.println(item.getNome() + " " + item.getNota());
		}
	}

}
