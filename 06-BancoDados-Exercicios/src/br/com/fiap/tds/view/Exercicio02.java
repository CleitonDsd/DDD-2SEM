package br.com.fiap.tds.view;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.fiap.tds.factory.ConnectionFactory;

public class Exercicio02 {

	public static void main(String[] args) {
		
		try {
		//Connectar no banco
		Connection conexao = ConnectionFactory.getConnection();
		Statement stmt = conexao.createStatement();
		
		//Criar o output stream para escrever no banco
		FileWriter outputStream = new FileWriter("alunos-export.cvs");
		PrintWriter arquivo = new PrintWriter(outputStream);
		
		//Ler os alunos cadastrados no banco de dados
		ResultSet resultado = stmt.executeQuery("SELECT * FROM TDS_TB_ALUNO");
		
		//Escrever o cabeçalho do arquivo
		arquivo.println("RM;Nome;Ativo;Nota1;Nota2");
		
		//Percorrer todos os registros encontrados no banco
		while(resultado.next()) {
			int rm = resultado.getInt("RM");
			String nome = resultado.getString("NOME");
			boolean ativo = resultado.getBoolean("ATIVO");
			float nota1 = resultado.getFloat("NOTA1");
			float nota2 = resultado.getFloat("NOTA2");
			
			//Escreve os dados no arquivo
			arquivo.println(rm + ";" + nome + ";" + ativo + ";" + nota1 + ";" + nota2);
			
		}			
		
		System.out.println("Dados exportados!");
		
		stmt.close();
		conexao.close();
		arquivo.close();
		outputStream.close();
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro...");
		}
		
	}//main
	
}//classe
