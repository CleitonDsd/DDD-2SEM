package br.com.fiap.tds.bean;

/**
 * 
 * @author Cleiton Dsd'
 * @version 1.0
 */
public class Conta {

	private int agencia;

	private String numero;

	/**
	 * Armazena o saldo da conta
	 */
	protected double saldo;

	/**
	 * Inicializa uma conta vazia
	 */
	public Conta() {
	}

	/**
	 * Inicializa uma conta com o número da agencia e da conta
	 * 
	 * @param agencia número da agencia
	 * @param numero  número da conta, com dígito
	 */
	public Conta(int agencia, String numero) {
		this.setAgencia(agencia);
		this.setNumero(numero);
	}

	/**
	 * @return número da agencia
	 */
	public int getAgencia() {
		return agencia;
	}

	/**
	 * @param agencia número da agencia
	 */
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	/**
	 * @return número da conta, com dígito
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero número da conta com dígito
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

}