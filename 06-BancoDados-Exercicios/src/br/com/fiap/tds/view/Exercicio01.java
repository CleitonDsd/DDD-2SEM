package br.com.fiap.tds.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fiap.tds.factory.ConnectionFactory;

public class Exercicio01 {

	public static void main(String[] args) {
		
		try {
			//Ler o arquivo alunos.cvs
			FileReader inputStream = new FileReader("alunos.cvs");
			BufferedReader arquivo = new BufferedReader(inputStream);
			
			String linha;
			
			//Conexão com banco
			Connection conexao = ConnectionFactory.getConnection();
			//Objeto que executa comandos no banco
			Statement stmt = conexao.createStatement();
			
			//Percorrer todas as linhas do arquivo
			while ((linha = arquivo.readLine()) != null) {
				//Validou se não é a linha de título
				if (linha.indexOf("RM") == -1) {
					//Separar os dados do aluno (linha)
					String[] vetor = linha.split(";");
					//Inserir no banco o aluno
					stmt.executeUpdate("INSERT INTO TDS_TB_ALUNO (ID, RM, NOME, ATIVO, NOTA1, NOTA2) "
							+ "VALUES (SQ_TDS_TB_ALUNO.NEXTVAL," + vetor[0] + ",'" + vetor[1] + "'," 
							+ (vetor[2].equals("true")?1:0) + "," + vetor[3] + "," + vetor[4]+ ")");
				}
				//Ternário -> (condicao?true:false)
			}
			
			System.out.println("Dados importados!");
			
			stmt.close();
			conexao.close();
			arquivo.close();
			inputStream.close();
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Erro ao ler o arquivo");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver do banco não encontrado");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao conectar ou executar o comando no banco");
		}
		
		
	}//main
	
}//classe