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
 * Author: S�rgio Ricardo
 */

public class HostJoin {

	public static void host(Console console) {
		int sentido = 0;
		int numeroDePassageiros = 0;
		Campus campus;
		Posicao posicao;
		Calendar calendar = Calendar.getInstance();
		
		do {
			System.out.println("Insira a quantidade de passageiros:");
			numeroDePassageiros = definirPassageiros(console);
		} while (numeroDePassageiros < 1 || numeroDePassageiros > 4);
		
		do {
			System.out.println("Insira a data e a hora da carona que deseja criar (YYYY MM DD hh mm):");
			calendar = definirData(console);
		} while (calendar == null);
		
		do {
			System.out.println("1 - Sentido UFF\n2 - Saindo da UFF");
			sentido = selecionarSentido(console);
		} while (sentido != 1 && sentido != 2);
		
		do {
			System.out.println("Escolha o local de " + ((sentido == 1) ? "destino:" : "partida:"));
			campus = selecionarCampus(console);
		} while (campus == null);
		
		do {
			System.out.println("Entre com as informa��es do local de " + ((sentido == 1) ? "partida:" : "destino:"));
			posicao = definirPosicao(console);
		} while (posicao == null);
		
		Rota rota = (sentido == 1) ? new Rota(posicao, campus) : new Rota(campus, posicao);
	
		Auxiliar.criarCarona(new Carona(console.getUser(), numeroDePassageiros, calendar, rota));
		
		console.setStage(Stage.LOBBY);
	}
	
	public static void join(Console console) {
		Carona carona;
		if(ListarCaronas.draw(console)) {
			do {
				System.out.println("Entre com a ID da carona que deseja participar:");
				carona = selecionarCarona(console);
			} while (carona == null);
		}
		console.setStage(Stage.LOBBY);
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
			console.setStage(Stage.LOBBY);
			console.getScanner().next();
			return null;
		}
	}
	
	public static Posicao definirPosicao(Console console) {
		double latitude;
		double longitude;
		String nome;
		int numero;
		String cep;
		
		try {
		System.out.println("Latitude: ");
			latitude = console.getScanner().nextDouble();
		System.out.println("Longitude: ");
			longitude = console.getScanner().nextDouble();
		System.out.println("Nome da Rua: ");
			nome = console.getScanner().next();
		System.out.println("N�mero: ");
			numero = console.getScanner().nextInt();
		System.out.println("Cep: ");
			cep = console.getScanner().next();
		} catch (Exception e) {
			System.out.println("Valor inv�lido...");
			console.getScanner().next();
			return null;
		}
		
		return new Posicao(latitude, longitude, nome, numero, cep);
	}
	
	public static Calendar definirData(Console console) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.set(console.getScanner().nextInt(), 
						console.getScanner().nextInt()-1, 
						console.getScanner().nextInt(), 
						console.getScanner().nextInt(), 
						console.getScanner().nextInt(), 
						00);
		} catch (Exception e) {
			System.out.println("Data inv�lida...");
			console.getScanner().next();
			return null;
		}
		return calendar;
	}
	
	public static int definirPassageiros(Console console) {
		int numeroDePassageiros;
		try {
			numeroDePassageiros = console.getScanner().nextInt();
			if (numeroDePassageiros < 1 || numeroDePassageiros > 4) System.out.println("Quantidade inv�lida...");
		} catch (Exception e) {
			System.out.println("Quantidade inv�lida...");
			console.getScanner().next();
			return -1;
		}
		return numeroDePassageiros;
	}
	
	public static int selecionarSentido(Console console) {
		int sentido;
		try {
			sentido = console.getScanner().nextInt();
			if (sentido != 1 && sentido != 2) System.out.println("Sentido inv�lido...");
		} catch (Exception e) {
			System.out.println("Sentido inv�lido...");
			console.getScanner().next();
			return -1;
		}
		return sentido;
	}
	
	public static Carona selecionarCarona(Console console) {
		try {
			int id = console.getScanner().nextInt();
			for (Carona carona : Auxiliar.caronasAtivas) {
				if (carona.getID() == id) {
					System.out.println("Registro de participa��o efetuado com sucesso!");
					return carona;
				}
			}
		} catch (Exception e) {
			System.out.println("ID inv�lida...");
			console.getScanner().next();
			return null;
		}
		System.out.println("ID inv�lida...");
		return null;
	}
}
