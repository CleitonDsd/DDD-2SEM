package br.com.fiap.tds.bean;

/***
 * 
 * @author Cleiton Dsd'
 * @version 1.0
 */
public class ContaCorrente extends Conta {

	/**
	 * Inicializa uma conta corrente com o número da agencia, número da conta com
	 * dígito e o saldo
	 * 
	 * @param agencia número da agencia
	 * @param numero  número da conta com dígito
	 * @param saldo   saldo da conta
	 */
	public ContaCorrente(int agencia, String numero, double saldo) {
		super(agencia, numero);
		this.saldo = saldo;
	}

	/**
	 * Exibe as movimentações da conta corrente
	 * 
	 * @param dias dias de movimentação da conta, a partir da data atual
	 */
	public void exibirExtrato(int dias) {

	}

	/**
	 * @return saldo da conta corrente
	 */
	public double getSaldo() {
		return saldo;
	}

}