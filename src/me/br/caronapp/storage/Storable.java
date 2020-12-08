package me.br.caronapp.storage;

import java.util.ArrayList;

import me.br.caronapp.carona.Carona;
import me.br.caronapp.usuario.Usuario;

/*
 * Author: Sérgio Ricardo
 */

public interface Storable {

	public void salva(ArrayList<Usuario> listaUsuarios, ArrayList<Carona> listaCaronas);
	
	public void carrega(ArrayList<Usuario> listaUsuarios, ArrayList<Carona> listaCaronas);

}
