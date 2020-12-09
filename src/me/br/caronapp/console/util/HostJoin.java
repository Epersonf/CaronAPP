package me.br.caronapp.console.util;

import me.br.caronapp.carona.Campus;
import me.br.caronapp.carona.PontosDeEncontro;
import me.br.caronapp.console.Console;

public class HostJoin {

	public static void draw(Console console) {
		
	}
	
	
	public Campus selecionarCampus(Console console) {
		try {
			for (int i = 0; i < PontosDeEncontro.values().length; i++) {
				System.out.println(i + " - " + PontosDeEncontro.values()[i].getNome());
			}
			System.out.println("-----------\nDigite o id nome do campus:");
			return new Campus(PontosDeEncontro.values()[console.getScanner().nextInt()]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Id invalido...");
			return null;
		}
	}
}
