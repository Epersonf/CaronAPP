package me.br.caronapp.carona.excecoes;

public class UsuarioNaoEncontradoException extends Exception {

	/**
	 * Author: S�rgio Ricardo
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException() {
		super("N�o foi poss�vel completar a opera��o. Usu�rio n�o encontrado.");
	}
	
}
