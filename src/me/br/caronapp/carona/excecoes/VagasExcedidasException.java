package me.br.caronapp.carona.excecoes;

public class VagasExcedidasException extends Exception {
	
	public VagasExcedidasException() {
		super("Operação excede o número limite de vagas.");
	}

}
