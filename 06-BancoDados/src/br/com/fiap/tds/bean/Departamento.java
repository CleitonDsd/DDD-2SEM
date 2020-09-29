package br.com.fiap.tds.bean;

//IMPLEMENTAR A CLASSE E O DAO COM O 
//CRUD (Cadastrar, Listar e Pesquisar com codigo, Atualizar e Remover)

public class Departamento {

	private int codigo;
	
	private String nome;
	
	private String dataCriacao;
	
	private String dataCadastro;
	
	private boolean ativo;
	
	public Departamento() {}
	
	public Departamento(String nome, String dataCriacao, boolean ativo) {
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.ativo = ativo;
	}

	public Departamento(int codigo, String nome, String dataCriacao, String dataCadastro, boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return nome + "\nCódigo: " + codigo + "\nData Criação: " 
				+ dataCriacao + "\nData Cadastro: " + dataCadastro + "\nAtivo: " + ativo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
