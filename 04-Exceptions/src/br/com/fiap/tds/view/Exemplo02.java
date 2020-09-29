package br.com.fiap.tds.view;

import java.util.Scanner;

import br.com.fiap.tds.bean.Disciplina;
import br.com.fiap.tds.exception.FaltasMaiorQueAulasException;
import br.com.fiap.tds.exception.QuantidadeInvalidaException;

public class Exemplo02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean ok;
		
		do {
			try { 
				ok = true;
				
				//Ler a quantidade de aulas
				System.out.println("Digite a qtd de aulas:");
				float aulas = sc.nextFloat();
				
				//Ler a quantidade de faltas
				System.out.println("Digite a qtd de faltas:");
				int faltas = sc.nextInt();
				
				//Instanciar a classe Disciplina
				Disciplina disciplina = new Disciplina();			
				
				//Chamar o método de calcular % de faltas
				float porcentage = disciplina.calcularPorcentagemFaltas(aulas, faltas);
				
				System.out.println("Porcentagem de faltas: " + porcentage);
			} catch(FaltasMaiorQueAulasException | QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
				ok = false;
				e.printStackTrace();
			} catch(Exception e) {
				ok = false;	
			} finally {
				sc.close();
			}
		}while(!ok);
		
	}//main
	
}//classe
