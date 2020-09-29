package br.com.fiap.tds.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por obter as conexões com o banco de dados
 * @author Thiago Yamamoto
 * @version 1.0
 */
public class ConnectionFactory {

	/**
	 * Método que obtem a conexão com o banco de dados
	 * @return Connection - Conexão com o banco de dados
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		//Registrar o driver do banco
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Obter a conexão com o banco de dados
		Connection conexao = DriverManager
				.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "pf0392", "fiap");
		
		return conexao;
	
	}
	
}