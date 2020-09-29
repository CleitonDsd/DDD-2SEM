package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

public class Exemplo01 {

	public static void main(String[] args) {

		//Tratamento de exceção
		try {
			//Pode lançar uma exception caso não seja informado um número
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));
			System.out.println("Opçao: " + opcao);
			
			String nome = null;
			
			nome.equals(" ");
			
		} catch(NumberFormatException | ArithmeticException e) {
			System.out.println("Digite um número");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		//Tratamento das exceptions: mais específicas primeiro e as mais genéricas no final
		} catch (Exception  e) {
			System.out.println("Erro..");
			e.printStackTrace();
			
		} finally {
			//Sempre será executado
			System.out.println("Finalizando..");
		}
	}
}