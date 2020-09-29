package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.exception.DepartamentoNaoEncontradoException;
import br.com.fiap.tds.factory.ConnectionFactory;

/**
 * Realiza as operações na tabela TDS_TB_DEPARTAMENTO
 * @author Thiago Yamamoto
 * @version 1.0
 */
public class DepartamentoDao {

	/**
	 * Cadastra um departamento 
	 * @param departamento
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void cadastrar(Departamento departamento) throws ClassNotFoundException, SQLException {
		
		Connection conexao = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO TDS_TB_DEPARTAMENTO "
			+ " (CD_DEPARTAMENTO, NM_DEPARTAMENTO, DT_CRIACAO, DT_CADASTRO, ST_ATIVO) VALUES "
			+ " (SQ_TDS_TB_DEPARTAMENTO.NEXTVAL, ?, ?, SYSDATE, ? )");
		
		stmt.setString(1, departamento.getNome());
		stmt.setString(2, departamento.getDataCriacao());
		stmt.setBoolean(3, departamento.isAtivo());
		
		stmt.executeUpdate();
		
		stmt.close();
		conexao.close();
	}
	
	/**
	 * Pesquisar um departamento pela PK
	 * @param id
	 * @return Departamento
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Departamento pesquisar(int id) throws ClassNotFoundException, SQLException {
		
		Connection conexao = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = conexao.prepareStatement(
				"SELECT * FROM TDS_TB_DEPARTAMENTO WHERE CD_DEPARTAMENTO = ?");
		
		stmt.setInt(1, id);
		
		ResultSet resultado = stmt.executeQuery();
		
		Departamento departamento = null;
		
		if (resultado.next()) {
			departamento = parse(resultado);
		}
		
		stmt.close();
		conexao.close();
		
		return departamento;
	}
	
	/**
	 * Retorna todos os departamentos cadastrados
	 * @return List<Departamento>
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Departamento> listar() throws ClassNotFoundException, SQLException{
		
		Connection conexao = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM TDS_TB_DEPARTAMENTO");
		
		ResultSet resultado = stmt.executeQuery();
		
		List<Departamento> lista = new ArrayList<Departamento>();
		
		while (resultado.next()) {
			//Departamento departamento = parse(resultado);
			//lista.add(departamento);
			lista.add(parse(resultado));
		}
		
		stmt.close();
		conexao.close();
		
		return lista;
		
	}
	
	/**
	 * Remove o departamento pela PK
	 * @param id
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws DepartamentoNaoEncontradoException 
	 */
	public void remover(int id) throws ClassNotFoundException, SQLException, DepartamentoNaoEncontradoException {
		
		Connection conexao = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = conexao
			.prepareStatement("DELETE FROM TDS_TB_DEPARTAMENTO WHERE CD_DEPARTAMENTO = ?");
		
		stmt.setInt(1, id);
		
		int linhas = stmt.executeUpdate();
		
		stmt.close();
		conexao.close();

		if (linhas == 0)
			throw new DepartamentoNaoEncontradoException();
		
	}
	
	/**
	 * Atualiza um departamento
	 * @param departamento
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws DepartamentoNaoEncontradoException 
	 */
	public void atualizar(Departamento departamento) throws ClassNotFoundException, SQLException, DepartamentoNaoEncontradoException {
		
		Connection conexao = ConnectionFactory.getConnection();
	
		PreparedStatement stmt = conexao.prepareStatement("UPDATE TDS_TB_DEPARTAMENTO "
				+ "SET NM_DEPARTAMENTO = ?, DT_CRIACAO = ?, ST_ATIVO = ? WHERE CD_DEPARTAMENTO = ?");
		
		stmt.setString(1, departamento.getNome());
		stmt.setString(2, departamento.getDataCriacao());
		stmt.setBoolean(3, departamento.isAtivo());
		stmt.setInt(4, departamento.getCodigo());
		
		int linhas = stmt.executeUpdate();

		stmt.close();
		conexao.close();
		
		if (linhas == 0)
			throw new DepartamentoNaoEncontradoException();
		
	}
	
	/**
	 * Recupera um departamento de um ResultSet
	 * @param resultado
	 * @return Departamento
	 * @throws SQLException 
	 */
	private Departamento parse(ResultSet resultado) throws SQLException {
		int codigo = resultado.getInt("CD_DEPARTAMENTO");
		String nome = resultado.getString("NM_DEPARTAMENTO");
		String dataCriacao = resultado.getString("DT_CRIACAO");
		String dataCadastro = resultado.getString("DT_CADASTRO");
		boolean ativo = resultado.getBoolean("ST_ATIVO");
		
		Departamento departamento = new Departamento(codigo, nome, dataCriacao, dataCadastro, ativo);
		return departamento;
	}
	
}
