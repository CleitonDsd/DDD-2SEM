package br.com.fiap.tds.bean;

/***
 * 
 * @author Cleiton Dsd'
 * @version 1.0
 */
public class Livro {

	// Comentário de Linha - não entram no javadoc

	/*
	 * Comentário de Bloco - não entram no javadoc
	 */
	private String titulo;

	private String categoria;

	private int exemplares;

	/**
	 * Cria um livro sem valores
	 */
	public Livro() {
	}

	/**
	 * Cria um livro com valores em seus atributos
	 * 
	 * @param titulo     titulo do livro
	 * @param categoria  categoria do livro
	 * @param exemplares número de exemplares disponíveis na biblioteca
	 */
	public Livro(String titulo, String categoria, int exemplares) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.exemplares = exemplares;
	}

	/**
	 * @return título do livro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo título do livro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return categoria do livro
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria categoria do livro
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return número de exemplares da biblioteca
	 */
	public int getExemplares() {
		return exemplares;
	}

	/**
	 * @param exemplares número de exemplares da biblioteca
	 */
	public void setExemplares(int exemplares) {
		this.exemplares = exemplares;
	}

}