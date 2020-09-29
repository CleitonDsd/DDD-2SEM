package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.dao.FuncionarioDao;

public class ExemploDaoCadastro {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Digite o nome");
		String email = JOptionPane.showInputDialog("Digite o e-mail");
		double salario = Integer.parseInt(JOptionPane.showInputDialog("Digite o salário"));
		boolean ativo = JOptionPane.showConfirmDialog(null, "Ativo?") == JOptionPane.YES_OPTION;
		String data = JOptionPane.showInputDialog("Digite a data de contratação (dd/mm/yyyy)");
		
		//Instanciar um funcionário com os dados
		Funcionario f = new Funcionario(0, nome, email, salario, ativo, data);	
		
		//Instanciar o funcionario DAO
		FuncionarioDao dao = new FuncionarioDao();
		
		try {
			//Chamar o método cadastrar
			dao.cadastrar(f);
			System.out.println("Funcionário cadastrado!");
		} catch(Exception e) {
			System.out.println("Não foi possível cadastrar");
		}
	}
	
}
