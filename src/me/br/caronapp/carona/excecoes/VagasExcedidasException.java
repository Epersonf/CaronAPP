package me.br.caronapp.carona.excecoes;

public class VagasExcedidasException extends Exception {
	
	/**
	 * Author: Sérgio Ricardo
	 */
	private static final long serialVersionUID = 1L;

	public VagasExcedidasException() {
		super("Operação excede o número limite de vagas.");
	}

}
