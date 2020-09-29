package br.com.fiap.tds.view;

import java.util.List;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.dao.FuncionarioDao;

public class ExemploDaoListagem {

	public static void main(String[] args) {
		//Instanciar o Funcionario Dao
		FuncionarioDao dao = new FuncionarioDao();
		
		try {
			//Chamar o método listar, armazendo a lista 
			List<Funcionario> lista = dao.listar();
			
			//Percorrer a lista e exibir os dados do funcionário
			for(Funcionario f : lista) {
				System.out.println(f);
			}
			
		}catch(Exception e) {
			System.out.println("Erro..");
			e.printStackTrace();
		}
		
	}
	
}
