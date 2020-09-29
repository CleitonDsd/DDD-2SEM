package br.com.fiap.tds.exception;

public class FaltasMaiorQueAulasException extends Exception {

	public FaltasMaiorQueAulasException() {
		super("Faltas devem ser menor do que as aulas");
	}
	
	public FaltasMaiorQueAulasException(String mensagem) {
		super(mensagem);
	}
	
}
