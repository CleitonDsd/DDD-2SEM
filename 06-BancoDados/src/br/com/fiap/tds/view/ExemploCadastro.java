package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fiap.tds.factory.ConnectionFactory;

public class ExemploCadastro {

	public static void main(String[] args) {
		
		try {
			
			Connection conexao = ConnectionFactory.getConnection();
			
			//Criar o objeto para executar um comando SQL
			Statement stmt = conexao.createStatement();
			
			//Executar um comando de insert (retorna a qtd de linhas afetadas)
			int qtd = stmt.executeUpdate("INSERT INTO TDS_TB_FUNCIONARIO"
					+ " (CD_FUNCIONARIO, NM_FUNCIONARIO, DS_EMAIL, VL_SALARIO, ST_ATIVO, DT_CONTRATACAO)"
					+ " VALUES (SQ_TDS_TB_FUNCIONARIO.NEXTVAL, 'Allen', 'allen@fiap.com.br',"
					+ " 10000, 8, '10/10/2000')");
			
			System.out.println("Funcionário registrado! " + qtd);
			
			//Fechar a conexão
			stmt.close();
			conexao.close();
			
		}catch(ClassNotFoundException e) {
			System.out.println("Driver do banco não encontrado!");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Erro ao conectar no banco");
			e.printStackTrace();
		}
		
	}//main
	
}//classe