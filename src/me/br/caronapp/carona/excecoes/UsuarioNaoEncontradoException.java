package me.br.caronapp.carona.excecoes;

public class UsuarioNaoEncontradoException extends Exception {

	/**
	 * Author: Sérgio Ricardo
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException() {
		super("Não foi possível completar a operação. Usuário não encontrado.");
	}
	
}
