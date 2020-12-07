package me.br.caronapp.storage;

import java.util.ArrayList;

import me.br.caronapp.usuario.Usuario;

public interface Storable {

	public void salvaUsuarios(ArrayList<Usuario> usuarios);
	
	public ArrayList<Usuario> carregaUsuarios();
	
}
