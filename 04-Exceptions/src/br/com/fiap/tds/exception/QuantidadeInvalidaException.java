package br.com.fiap.tds.exception;

public class QuantidadeInvalidaException extends Exception {

	public QuantidadeInvalidaException() {
		super("Quantidade inválida");
	}
	
	public QuantidadeInvalidaException(String mensagem) {
		super(mensagem);
	}
	
}
