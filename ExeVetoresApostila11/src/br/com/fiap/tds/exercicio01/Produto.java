package br.com.fiap.tds.exercicio01;

public class Produto {
	
	//atributos
	private int quantidade;

	private double preco;

	// em %
	private double desconto;
	
	//Construtores
	public Produto() {
		
	}
	
	public Produto(int quantidade, double preco, double desconto) {
		super();
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	
	//Getters and Setters
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
}
