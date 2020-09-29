package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fiap.tds.factory.ConnectionFactory;

public class ExemploPesquisa {
	
	public static void main(String[] args) {
		
		try {
			//Obter a conexão
			Connection conexao = ConnectionFactory.getConnection();
			
			//Criar o objeto para executar comandos Sql no banco
			Statement stmt = conexao.createStatement();
			
			//Realizar a pesquisa de todos os funcionários
			ResultSet resultado = stmt.executeQuery("SELECT * FROM TDS_TB_FUNCIONARIO");
			
			//Percorrer todos os registros encontrados
			while(resultado.next()) {
				//Recuperar os dados das colunas
				int codigo = resultado.getInt("CD_FUNCIONARIO");
				String nome = resultado.getString("NM_FUNCIONARIO");
				double salario = resultado.getDouble("VL_SALARIO");
				boolean ativo = resultado.getBoolean("ST_ATIVO");
				String email = resultado.getString("DS_EMAIL");
				String data = resultado.getString("DT_CONTRATACAO");
				
				System.out.println(codigo + " " + nome + " " + 
									salario + " " + ativo + " " + email + " " + data);
			}
			
			stmt.close();
			conexao.close();
			
		} catch(ClassNotFoundException e) {
			System.out.println("Driver do banco não encontrado!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar o executar o comando no banco");
			e.printStackTrace();
		}
	}

}
