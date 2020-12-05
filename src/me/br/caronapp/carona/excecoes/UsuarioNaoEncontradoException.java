package me.br.caronapp.carona.excecoes;

public class UsuarioNaoEncontradoException extends Exception {

	public UsuarioNaoEncontradoException() {
		super("Não foi possível completar a operação. Usuário não encontrado.");
	}
	
}
