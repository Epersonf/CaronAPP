package me.br.caronapp.carona.excecoes;

public class VagasExcedidasException extends Exception {
	
	/**
	 * Author: S�rgio Ricardo
	 */
	private static final long serialVersionUID = 1L;

	public VagasExcedidasException() {
		super("Opera��o excede o n�mero limite de vagas.");
	}

}
