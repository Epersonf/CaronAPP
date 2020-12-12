package me.br.caronapp.console.util;

import java.util.ArrayList;

import me.br.caronapp.carona.Carona;
import me.br.caronapp.carona.Carona.Estado;
import me.br.caronapp.carona.excecoes.UsuarioNaoEncontradoException;
import me.br.caronapp.console.Console;
import me.br.caronapp.console.Console.Stage;

/*
 * Implementado por Eperson Cardoso Mayrink Xavier Filho
 * Modificado por: Sergio Ricardo
 * */

public class CaronaManager {
	public static void verCorridas(Console console) {
		ArrayList<Carona> caronas = console.getUser().getCaronas();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		System.out.println("Caronas nas quais voce eh dono:");
		for (int i = 0; i < caronas.size(); i++) {
			if (!caronas.get(i).getHost().equals(console.getUser())) {
				indexes.add(i);
				continue;
			}
			System.out.println(caronas.get(i).getID() + " - " 
								+ caronas.get(i).getHost().getName() + " - " 
								+ caronas.get(i).toString());
		}
		System.out.println("Caronas nas quais voce eh passageiro:");
		for (int i = 0; i < indexes.size(); i++) {
			Carona c = caronas.get(indexes.get(i));
			System.out.println(c.getID() + " - " + c.getHost().getName() + " - " + c.toString());
		}
		
		System.out.println("Digite um ID de carona: ");
		Carona toCheck = console.getUser().getPeloId(console.getScanner().nextInt());
		if (toCheck != null)
			verOpcoesCorrida(toCheck, console);
		else
			System.out.println("Carona nao encontrada...");
		
		console.setStage(Stage.LOBBY);
	}
	
	private static void verOpcoesCorrida(Carona carona, Console console) {
		if (carona == null) {
			System.out.println("Carona nao encontrada...");
			return;
		}
		
		if (console.getUser().equals(carona.getHost())) {
			switch (carona.getEstado()) {
			case AGUARDANDO:
				System.out.println("Vai partir agora? (1 - sim / 0 - nao)");
				if (console.getScanner().nextInt() != 0)
					carona.setEstado(Estado.FECHADO);
				break;
			case FECHADO:
				System.out.println("Ja chegou no ponto? Deseja finalizar? (1 - sim / 0 - nao)");
				if (console.getScanner().nextInt() != 0)
					carona.setEstado(Estado.FINALIZADO);
				break;
			default:
				System.out.println("Sem opções disponíveis...");
				break;
			}
		} else {
			switch (carona.getEstado()) {
			case ABERTO:
				System.out.println("Deseja sair dessa corrida? (1 - sim / 0 - nao)");
				if (console.getScanner().nextInt() == 0) break;
				try {
					carona.removePassageiro(console.getUser());
				} catch (UsuarioNaoEncontradoException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Sem opções disponíveis...");
				break;
			}
		}
	}
}
