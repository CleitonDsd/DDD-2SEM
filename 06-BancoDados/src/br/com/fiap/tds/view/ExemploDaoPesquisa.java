package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.dao.FuncionarioDao;

public class ExemploDaoPesquisa {

	public static void main(String[] args) {
		//Instanciar o FuncionarioDao
		FuncionarioDao dao = new FuncionarioDao();
		
		//Ler o código da pesquisa
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
		
		try {
			//Utilizar o método pesquisar
			Funcionario funcionario = dao.pesquisar(codigo);
			
			//Validar se encontrou um resultado
			//Exibir o resultado
			if (funcionario != null)
				JOptionPane.showMessageDialog(null, funcionario);
			else
				JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro..");
			e.printStackTrace();
		}
		
	}//main
	
}//classe