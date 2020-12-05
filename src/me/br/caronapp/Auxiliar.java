package me.br.caronapp;

import java.util.ArrayList;

import me.br.caronapp.carona.Carona;
import me.br.caronapp.usuario.Usuario;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class Auxiliar {
	private static ArrayList<Carona> caronasAtivas = new ArrayList<Carona>();
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
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
	
	public static void removerPassageiro(int userId, int caronaId) {
		
	}
	
	public static void updateTime() {
		for (Carona c : caronasAtivas) {
			//c.updateTime();
		}
	}
}
