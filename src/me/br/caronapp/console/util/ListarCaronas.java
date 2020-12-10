package me.br.caronapp.console.util;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.carona.Rota.Sentido;
import me.br.caronapp.console.Console;
import me.br.caronapp.console.Console.Stage;

public class ListarCaronas {
	public static void draw(Console console) {
		System.out.println("Deseja ir ou voltar? (1 - ir / 2 - voltar)");
		mostrarCaronas((console.getScanner().nextInt() == 1) ? Sentido.IDA : Sentido.VOLTA);
		console.setStage(Stage.LOBBY);
	}
	
	public static void mostrarCaronas(Sentido sentido) {
		boolean printou = false;
		for (int i = 0; i < Auxiliar.caronasAtivas.size(); i++) {
			if (Auxiliar.caronasAtivas.get(i).getRota().getSentido() != sentido) continue;
			printou = true;
			System.out.println(Auxiliar.caronasAtivas.get(i).getHost().getName());
		}

		if (!printou)
			System.out.println("Sem caronas ativas no momento...");
	}
}
