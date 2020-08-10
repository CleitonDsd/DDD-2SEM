package br.com.fiap.tds.bean;

/**
 * 
 * @author Cleiton Dsd'
 *
 */
public class Biblioteca {
	/**
	 * Define o nome da biblioteca
	 */
	private String nome;

	/**
	 * Define o endereço da biblioteca, com número e complemento
	 */
	private String endereco;

	/**
	 * Define os livros disponíveis na biblioteca
	 */
	private Livro[] livros;

	/**
	 * Cria uma nova biblioteca sem valores nos atributos
	 */
	public Biblioteca() {
	}

	/**
	 * Cria uma nova biblioteca definindo valores nos atributos
	 * 
	 * @param nome     da biblioteca
	 * @param endereco da biblioteca
	 * @param livros   disponíveis na biblioteca
	 */
	public Biblioteca(String nome, String endereco, Livro[] livros) {
		this.nome = nome;
		this.endereco = endereco;
		this.livros = livros;
	}

	/**
	 * @return retorna o nome da biblioteca
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome nome da biblioteca
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return endereço da biblioteca
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco endereço da biblioteca com número e complemento
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return livros disponíveis na biblioteca
	 */
	public Livro[] getLivros() {
		return livros;
	}

	/**
	 * @param livros livros disponíveis na biblioteca
	 */
	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}

}