package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.exception.FuncionarioNaoEncontradoException;
import br.com.fiap.tds.factory.ConnectionFactory;

/**
 * Classe responsável por acessar o banco de dados
 * Realiza as operações básicas (CRUD) para o funcionário
 * @author Thiago Yamamoto
 *
 */
public class FuncionarioDao {

	/**
	 * Pesquisar por parte do nome do funcionário
	 * @param nome Parte do nome do funcionário
	 * @return List<Funcionario> lista de funcionário
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Funcionario> pesquisar(String nome) throws ClassNotFoundException, SQLException{
		//Obter a conexão
		Connection conexao = ConnectionFactory.getConnection();
		
		//Criar a query
		PreparedStatement stmt = conexao
			.prepareStatement("SELECT * FROM TDS_TB_FUNCIONARIO WHERE NM_FUNCIONARIO LIKE ?");
		
		//Setar o parâmetro na query
		stmt.setString(1, "%" +  nome + "%");
		
		//Executar a query
		ResultSet resultado = stmt.executeQuery();
		
		//Criar a lista de funcionários
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		//Percorrer os resultados para recuperar os funcionários
		while (resultado.next()) {
			Funcionario funcionario = parse(resultado);
			//Adicionar o funcionário na lista
			lista.add(funcionario);
		}
		//Fechar
		stmt.close();
		conexao.close();
		
		//Retornar a lista
		return lista;
	}
	
	/**
	 * Remove um funcionário do banco de dados
	 * @param codigo Código do funcionário
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FuncionarioNaoEncontradoException 
	 */
	public void remover(int codigo) 
				throws ClassNotFoundException, SQLException, FuncionarioNaoEncontradoException {
		//Obter a conexão com o banco 
		Connection conexao = ConnectionFactory.getConnection();
		
		//Criar a query para remover
		PreparedStatement stmt = conexao.
				prepareStatement("DELETE FROM TDS_TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?"); 
		
		//Colocar o codigo na query
		stmt.setInt(1, codigo);
		
		//Executar a query
		int qtd = stmt.executeUpdate();
		
		//Valida se removeu alguma linha no banco de dados
		if (qtd == 0)
			throw new FuncionarioNaoEncontradoException();
		
		//Fechar
		stmt.close();
		conexao.close();
		
	}
	
	/**
	 * Atualiza os dados de um funcionário no banco de dados
	 * @param funcionario
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FuncionarioNaoEncontradoException 
	 */
	public void atualizar(Funcionario funcionario) 
					throws ClassNotFoundException, SQLException, FuncionarioNaoEncontradoException {
		//Pesquisar para ver se o usuário existe
		Funcionario busca = pesquisar(funcionario.getCodigo());
		
		//Não encontrou o funcionário
		if (busca == null) {
			throw new FuncionarioNaoEncontradoException();
		} 
		
		//Obter a conexão com o banco de dados
		Connection conexao = ConnectionFactory.getConnection();
		
		//Criar a query para executar no banco
		PreparedStatement stmt = conexao.prepareStatement("UPDATE TDS_TB_FUNCIONARIO SET"
			+ " NM_FUNCIONARIO = ?, DS_EMAIL = ?, VL_SALARIO = ?, ST_ATIVO = ?, DT_CONTRATACAO = ?"
			+ " WHERE CD_FUNCIONARIO = ?");
		
		//Colocar os valores na query
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getEmail());
		stmt.setDouble(3, funcionario.getSalario());
		stmt.setBoolean(4, funcionario.isAtivo());
		stmt.setString(5, funcionario.getDataContratacao());
		
		stmt.setInt(6, funcionario.getCodigo());
		
		//Executar a query
		stmt.executeUpdate();
		
		//Fechar
		stmt.close();
		conexao.close();
	}
	
	/**
	 * Cadastra um funcionário no banco de dados
	 * @param funcionario
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void cadastrar(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		//Conexão com o banco de dados
		Connection conexao = ConnectionFactory.getConnection();
		
		//Cria a query para executar no banco
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO TDS_TB_FUNCIONARIO"
			+ " (CD_FUNCIONARIO, NM_FUNCIONARIO, DS_EMAIL, VL_SALARIO, ST_ATIVO, DT_CONTRATACAO, CD_DEPARTAMENTO) VALUES"
			+ " (SQ_TDS_TB_FUNCIONARIO.NEXTVAL, ?, ?, ?, ?, ?, ?)");
		
		//Coloca os valores na query
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getEmail());
		stmt.setDouble(3, funcionario.getSalario());
		stmt.setBoolean(4, funcionario.isAtivo());
		stmt.setString(5, funcionario.getDataContratacao());
		stmt.setInt(6, funcionario.getDepartamento().getCodigo());
		
		//Executar a query
		stmt.executeUpdate();
		
		//Fechar
		stmt.close();
		conexao.close();
	}
	
	/**
	 * Pequisa um funcionário pela chave primária
	 * @param codigo
	 * @return Funcionario Objeto funcionário ou null, caso não encontre
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Funcionario pesquisar(int codigo) throws ClassNotFoundException, SQLException {
		//Obter a conexão com o banco
		Connection conexao = ConnectionFactory.getConnection();
		
		//Criar o PreparedStatement
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT * FROM TDS_TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?");
		
		//Setar o código do funcionário na query
		stmt.setInt(1, codigo);
		
		//Obter o resultado da pesquisa
		ResultSet resultado = stmt.executeQuery();
		
		Funcionario funcionario = null;
		
		//Verificar se encontrou resultado
		if (resultado.next()) {
			//Instanciar um funcionário
			funcionario = parse(resultado);
		}
		
		//Fechar
		stmt.close();
		conexao.close();

		//Retornar null ou o funcionário
		return funcionario;
	}
	
	//Criar um método interno (private) que recebe um ResultSet e retorna um funcionário
	//Será utilizado em pesquisas (pesquisar por código, listar, pesquisar por nome...)
	private Funcionario parse(ResultSet resultado) throws SQLException {
		
		//Obter os dados dos campos (colunas)
		int codigo = resultado.getInt("CD_FUNCIONARIO");
		String nome = resultado.getString("NM_FUNCIONARIO");
		String email = resultado.getString("DS_EMAIL");
		boolean ativo = resultado.getBoolean("ST_ATIVO");
		String data = resultado.getString("DT_CONTRATACAO");
		double salario = resultado.getDouble("VL_SALARIO");
		
		//Instanciar um funcionário com os dados
		Funcionario funcionario = new Funcionario(codigo, nome, email, salario, ativo, data);
		
		//Retornar o funcionário
		return funcionario;
	}
	
	/**
	 * Recupera todos os funcionários cadastrados
	 * @return List<Funcionario> Lista de funcionários
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Funcionario> listar() throws ClassNotFoundException, SQLException{
		//Criar uma lista de funcionário
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		//Obter a conexão com o banco
		Connection conexao = ConnectionFactory.getConnection();
		
		//Criar um Statement ou PreparedStatement
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM TDS_TB_FUNCIONARIO");
		
		//Obter o resultado da pesquisa -> ResultSet
		ResultSet resultado = stmt.executeQuery();
		
		//Percorrer o result set (todos os registros)
		while(resultado.next()) {
			
			//Instanciar um funcionário com os dados
			Funcionario funcionario = parse(resultado);
			
			//Adicionar o funcionário na lista
			lista.add(funcionario);
		}
		
		//Fechar
		stmt.close();
		conexao.close();
		
		//Retornar lista
		return lista;
	}
	
}//classe