package me.br.caronapp.console.util;

import java.util.Calendar;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.carona.Campus;
import me.br.caronapp.carona.Carona;
import me.br.caronapp.carona.PontosDeEncontro;
import me.br.caronapp.carona.Posicao;
import me.br.caronapp.carona.Rota;
import me.br.caronapp.console.Console;
import me.br.caronapp.console.Console.Stage;

/*
 * Author: Sérgio Ricardo
 */

public class HostJoin {

	public static void host(Console console) {
		int sentido;
		int numeroDePassageiros;
		Campus campus;
		Posicao posicao;
		Calendar calendar = Calendar.getInstance();
		
		System.out.println("Insira a quantidade de passageiros:");
		do {
			numeroDePassageiros = console.getScanner().nextInt();
			if (numeroDePassageiros < 1 || numeroDePassageiros > 4) System.out.println("Quantidade inválida.");
		} while (numeroDePassageiros < 1 || numeroDePassageiros > 4);
		
		System.out.println("Insira a data e a hora da carona que deseja criar (YYYY MM DD hh mm):");
		calendar.set(console.getScanner().nextInt(), 
					console.getScanner().nextInt()-1, 
					console.getScanner().nextInt(), 
					console.getScanner().nextInt(), 
					console.getScanner().nextInt(), 
					00);
		
		System.out.println("1 - Sentido UFF\n2 - Saindo da UFF");
		do { 
			sentido = console.getScanner().nextInt(); 
			if (sentido != 1 && sentido != 2) 
				System.out.println("Sentido inválido.");
		} while (sentido != 1 && sentido != 2);
		
		System.out.println("Escolha o local de " + ((sentido == 1) ? "destino:" : "partida:"));
		campus = selecionarCampus(console);
		
		System.out.println("Entre com as informações do local de " + ((sentido == 1) ? "partida:" : "destino:"));
		posicao = definirPosicao(console);
		
		Rota rota = (sentido == 1) ? new Rota(posicao, campus) : new Rota(campus, posicao);
		
		Auxiliar.criarCarona(new Carona(console.getUser(), numeroDePassageiros, calendar, rota));
		console.setStage(Stage.LOBBY);
	}
	
	public static void join(Console console) {
		
	}
		
	public static Campus selecionarCampus(Console console) {
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
	
	public static Posicao definirPosicao(Console console) {
		System.out.println("Latitude: ");
		float latitude = console.getScanner().nextFloat();
		System.out.println("Longitude: ");
		float longitude = console.getScanner().nextFloat();
		System.out.println("Nome da Rua: ");
		String nome = console.getScanner().next();
		System.out.println("Número: ");
		int numero = console.getScanner().nextInt();
		System.out.println("Cep: ");
		String cep = console.getScanner().next();
		
		return new Posicao(latitude, longitude, nome, numero, cep);
	}
}
