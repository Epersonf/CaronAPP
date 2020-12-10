package me.br.caronapp.console.util;

import java.util.Calendar;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.carona.Campus;
import me.br.caronapp.carona.Carona;
import me.br.caronapp.carona.PontosDeEncontro;
import me.br.caronapp.console.Console;

public class HostJoin {

	public static void host(Console console) {
		int sentido;
		int numero;
		int idCampus;
		String nomeDaRua;
		
		Calendar calendar = Calendar.getInstance();
		System.out.println("Insira a data e a hora da carona que deseja criar (YYYY MM DD hh mm):");
		calendar.set(console.getScanner().nextInt(), 
					console.getScanner().nextInt(), 
					console.getScanner().nextInt(), 
					console.getScanner().nextInt(), 
					console.getScanner().nextInt(), 
					00);
		System.out.println("1 - Sentido UFF\n2 - Saindo da UFF");
		do { sentido = console.getScanner().nextInt(); } while (sentido != 1 && sentido != 2);
		System.out.println("Escolha o local de " + ((sentido == 1) ? "destino:" : "partida:"));
		for (int j = 0; j<PontosDeEncontro.values().length; j++){
            System.out.println(j + " - " + PontosDeEncontro.values()[j]);
        }

		Auxiliar.criarCarona(new Carona(console.getUser(), 0, calendar, null));
	}
	
	public static void join(Console console) {
		
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
