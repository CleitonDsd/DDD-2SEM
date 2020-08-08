package br.com.fiap.tds.bean;

public class Boletim {
	
	private String nome;

	// Vetor de disciplina
	private Disciplina[] disciplinas;

	public Boletim(String nome, Disciplina[] disciplinas) {
		super();
		this.nome = nome;
		this.disciplinas = disciplinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina[] getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Disciplina[] disciplinas) {
		this.disciplinas = disciplinas;
	}
}
