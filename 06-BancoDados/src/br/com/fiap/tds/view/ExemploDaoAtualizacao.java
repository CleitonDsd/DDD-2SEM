package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.exception.FuncionarioNaoEncontradoException;

public class ExemploDaoAtualizacao {

	public static void main(String[] args) {
		
		//Instanciar o FuncionarioDao
		FuncionarioDao dao = new FuncionarioDao();
		
		//Ler os dados do funcionário
		String nome = JOptionPane.showInputDialog("Digite o nome");
		String email = JOptionPane.showInputDialog("Digite o e-mail");
		String data = JOptionPane.showInputDialog("Digite a data de nascimento");
		double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário"));
		boolean ativo = JOptionPane.showConfirmDialog(null, "Funcionário ativo?") == JOptionPane.YES_OPTION;
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
		
		//Instanciar o objeto com os dados
		Funcionario funcionario = new Funcionario(codigo, nome, email, salario, ativo, data);
		
		try {

			//Chamar o método atualizar do DAO
			dao.atualizar(funcionario);
			
			System.out.println("Funcionário atualizado!");
			
		}catch(FuncionarioNaoEncontradoException e) {
			System.out.println("Código do funcionário inválido");
		}catch(Exception e ) {
			System.out.println("Erro..");
			e.printStackTrace();
		}
		
	}//main
	
}//classe