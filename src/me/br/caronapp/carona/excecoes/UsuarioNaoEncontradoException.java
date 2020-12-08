package me.br.caronapp.carona.excecoes;

public class UsuarioNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException() {
		super("Não foi possível completar a operação. Usuário não encontrado.");
	}
	
}
