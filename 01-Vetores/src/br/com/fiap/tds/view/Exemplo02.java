package br.com.fiap.tds.view;

public class Exemplo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declarar um vetor de String com os dias da semana
		String[] diasSemana = { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado" };

		/*
		 * String[] diasSemana = new String[7]; diasSemana[0] = "Domingo"; diasSemana[1]
		 * = "Segunda"; diasSemana[2] = "Terça"; diasSemana[3] = "Quarta"; diasSemana[4]
		 * = "Quinta"; diasSemana[5] = "Sexta"; diasSemana[6] = "Sábado";
		 */

		// Exibir o dia da semana da quarta posição
		System.out.println(diasSemana[3]);

		// Exibir o tamanho do vetor
		System.out.println(diasSemana.length);

		// Exibir todos os valores do vetor de dias da semana
		for (int i = 0; i < diasSemana.length; i++) {
			System.out.println(diasSemana[i]);
		}

		System.out.println("FOREACH:");
		// Exibir todos os valores do vetor utilizando o foreach
		for (String dia : diasSemana) {
			System.out.println(dia);
		}
	}

}
