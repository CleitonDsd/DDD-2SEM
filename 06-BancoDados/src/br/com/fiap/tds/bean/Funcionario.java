package br.com.fiap.tds.bean;


/**
 * Classe que representa um funcionário
 * @author Thiago Yamamoto
 *
 */
public class Funcionario {

	private int codigo;
	
	private String nome;
	
	private String email;
	
	private double salario;
	
	private boolean ativo;
	
	private String dataContratacao;
	
	private Departamento departamento;
	
	public Funcionario() {}

	public Funcionario(int codigo, String nome, String email, double salario, boolean ativo, String dataContratacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.salario = salario;
		this.ativo = ativo;
		this.dataContratacao = dataContratacao;
	}
	
	public Funcionario(int codigo, String nome, String email, double salario, 
					boolean ativo, String dataContratacao, Departamento departamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.salario = salario;
		this.ativo = ativo;
		this.dataContratacao = dataContratacao;
		this.departamento = departamento;
	}

	@Override
		public String toString() {
			return codigo + " - " + nome + ", " + email + ", " 
					+ salario + ", " + dataContratacao + ", " + ativo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
