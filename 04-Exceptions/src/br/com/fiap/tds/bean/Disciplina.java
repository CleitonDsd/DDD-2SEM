package br.com.fiap.tds.bean;

import br.com.fiap.tds.exception.FaltasMaiorQueAulasException;
import br.com.fiap.tds.exception.QuantidadeInvalidaException;

public class Disciplina {

	public float calcularPorcentagemFaltas(float aulas, int faltas)
			throws FaltasMaiorQueAulasException, QuantidadeInvalidaException {

		/*
		 * Quando o método lança a exception (throw) o fluxo da excecução é direcionado
		 * para a classe que chamou o método
		 */

		// A qtd de faltas deve ser menor que a qtd de aulas
		if (faltas > aulas) {
			throw new FaltasMaiorQueAulasException("Falta deve ser menor de que as aulas");
		}
		// A qtd de aulas deve ser maior do que zero e as faltas deve ser maior ou igual
		// 0
		if (aulas <= 0 || faltas < 0) {
			throw new QuantidadeInvalidaException("Aulas e Faltas devem ser maior que 0");
		}
		return faltas / aulas * 100;
	}

}