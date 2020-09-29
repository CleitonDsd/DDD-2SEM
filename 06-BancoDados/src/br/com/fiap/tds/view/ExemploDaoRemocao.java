package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.exception.FuncionarioNaoEncontradoException;

public class ExemploDaoRemocao {

	public static void main(String[] args) {
		//Instanciar o FuncionarioDao
		FuncionarioDao dao = new FuncionarioDao();
		
		//Ler o código
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
		
		try {
			//Chamar o método remover do dao
			dao.remover(codigo);
			
			System.out.println("Funcionário removido!");
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println("Funcionário não encontrado");
			//e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Erro..");
			e.printStackTrace();
		}
		
	}
	
}