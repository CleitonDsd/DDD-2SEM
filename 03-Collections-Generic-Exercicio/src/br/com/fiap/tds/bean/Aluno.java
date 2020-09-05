package br.com.fiap.tds.bean;

import java.util.List;

public class Aluno {

	private int rm;

	private String nome;

	private int idade;

	private List<Float> notas;

	public Aluno() {
	}

	public Aluno(int rm, String nome, int idade, List<Float> notas) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.idade = idade;
		this.notas = notas;
	}

	/**
	 * Calcula a média de notas do aluno
	 * 
	 * @return média de notas
	 */
	public float getMedia() {
		float total = 0;
		for (Float nota : notas) {
			total += nota;
		}
		return total / notas.size();
	}

	@Override
	public String toString() {
		return "RM: " + rm + ",nome: " + nome + ",idade: " + idade + ",notas: " + notas;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Float> getNotas() {
		return notas;
	}

	public void setNotas(List<Float> notas) {
		this.notas = notas;
	}
}
