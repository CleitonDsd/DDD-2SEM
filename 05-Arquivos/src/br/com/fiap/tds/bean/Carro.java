package br.com.fiap.tds.bean;

public class Carro {

	private String modelo;
	
	private int ano;
	
	private String marca;

	public Carro(String modelo, int ano, String marca) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		//StringBuffer exemplo = new StringBuffer();
		//exemplo.append("Modelo: ").append(modelo);
		//return exemplo.toString();
		return "Modelo: "  + modelo + " Ano: " + ano + " Marca: " + marca;
	}
	
	public Carro() {}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
