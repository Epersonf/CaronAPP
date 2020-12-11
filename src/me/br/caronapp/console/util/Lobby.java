package me.br.caronapp.console.util;

import me.br.caronapp.console.Console;
import me.br.caronapp.console.Console.Stage;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class Lobby {
	public static void draw(Console console) {
		System.out.println("1 - Listar caronas\n2 - Host carona\n3 - Entrar carona\n4 - Deslogar\n5 - Ver minhas corridas\n6 - Halt");
		int next = console.getScanner().nextInt();
		switch (next) {
			case 1:
				console.setStage(Stage.LISTAR_CARONAS);
				break;
			case 2:
				console.setStage(Stage.HOST_CARONA);
				break;
			case 3:
				console.setStage(Stage.ENTRAR_CARONA);
				break;
			case 4:
				console.setStage(Stage.DESLOGAR);
				break;
			case 5:
				console.setStage(Stage.VER_CORRIDAS);
				break;
			default:
				console.setStage(Stage.HALT);
				break;
		}
	}
}
