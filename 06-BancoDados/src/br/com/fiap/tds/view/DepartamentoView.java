package br.com.fiap.tds.view;

import java.util.List;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.dao.DepartamentoDao;

public class DepartamentoView {

	public static void main(String[] args) {
		//Testar os métodos de CRUD do departamento DAO
		
		//Instanciar o Departamento DAO
		DepartamentoDao dao = new DepartamentoDao();
		
		//Instanciar um departamento
		Departamento departamento = new Departamento("RH", "10/10/2020", true);
		
		try {
		
			//Cadastro
			dao.cadastrar(departamento);
			System.out.println("Departamento registrado!");
			
			//Pesquisar por código
			Departamento busca = dao.pesquisar(1);
			System.out.println(busca);
			
			//Atualização
			departamento = new Departamento(1,  "Financeiro", "10/10/1999", null, false);
			dao.atualizar(departamento);
			System.out.println("Departamento atualizado!");
			
			//Listagem
			System.out.println("Listagem");
			List<Departamento> lista = dao.listar();
			for(Departamento item : lista) {
				System.out.println(item);
			}
			
			//Remoção
			dao.remover(1);
			System.out.println("Departamento removido!");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
