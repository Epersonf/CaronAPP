package me.br.caronapp;

import java.util.ArrayList;

import me.br.caronapp.carona.Carona;
import me.br.caronapp.carona.excecoes.UsuarioNaoEncontradoException;
import me.br.caronapp.usuario.Usuario;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class Auxiliar {
	public static ArrayList<Carona> caronasAtivas = new ArrayList<Carona>();
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	/* Carona */
	
	public static void criarCarona(Carona c) {
		caronasAtivas.add(c);
	}
	
	public static void removerCarona(Carona c) {
		caronasAtivas.remove(c);
	}
	
	public static void removerCarona(int id) {
		if (id < 0 || id >= caronasAtivas.size()) return;
		caronasAtivas.remove(id);
	}
	
	public static void removerPassageiro(String username, int caronaId) throws UsuarioNaoEncontradoException {
		if (caronaId < 0 || caronaId >= caronasAtivas.size()) return;
		caronasAtivas.get(caronaId).removePassageiro(username);
	}
	
	/* Login e registro */
	public static Usuario logar(String username, String senha) {
		for (Usuario u : usuarios) 
			if (u.podeLogar(username, senha)) return u;
		return null;
	}
	
	public static Usuario register(String username, String name, String cpf, String senha) {
		if (existe(username)) return null;
		Usuario u = new Usuario(username, name, cpf, senha);
		usuarios.add(u);
		return u;
	}
	
	public static boolean existe(String username) {
		for (Usuario u : usuarios)
			if (username.equalsIgnoreCase(u.getUsername())) return true;
		return false;
	}
	
	/* Atualizacao de tempo */
	
	public static void updateTime() {
		for (Carona c : caronasAtivas) {
			c.atualiza();
		}
	}
}
