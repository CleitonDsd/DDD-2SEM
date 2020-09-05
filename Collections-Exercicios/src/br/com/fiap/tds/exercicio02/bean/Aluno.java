package br.com.fiap.tds.exercicio02.bean;

import java.util.List;

public class Aluno {

	private String nome;

	private int idade;

	private List<Float> notas;

	public Aluno() {
	}

	public Aluno(String nome, int idade, List<Float> notas) {
		this.nome = nome;
		this.idade = idade;
		this.notas = notas;
	}

	// Método que retorna a média do aluno
	public float getMedia() {
		float total = 0; // variável que armezena a soma das notas
		for (float item : notas) { // percorre todas as notas da lista
			// float nota = (Float) item; //transforma o Object em um float
			total += item; // Soma as notas
		}
		return total / notas.size(); // Retorna a média
	}

	// Método que define o que será exibido quando o objeto é impresso
	@Override
	public String toString() {
		return nome + ", Idade: " + idade + ", Notas: " + notas;
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