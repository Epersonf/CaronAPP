package me.br.caronapp.console.util;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.carona.Carona.Estado;
import me.br.caronapp.carona.Rota.Sentido;
import me.br.caronapp.console.Console;
import me.br.caronapp.console.Console.Stage;

/*
 * Author: Eperson Cardoso Mayrink Xavier Filho
 * Modificado por Sérgio Ricardo
 */

public class ListarCaronas {
	public static boolean draw(Console console) {
		boolean caronas;
		System.out.println("Deseja ir ou voltar? (1 - Ir / 2 - Voltar)");
		caronas = mostrarCaronas((console.getScanner().nextInt() == 1) ? Sentido.IDA : Sentido.VOLTA);
		console.setStage(Stage.LOBBY);
		return caronas;
		
	}
	
	public static boolean mostrarCaronas(Sentido sentido) {
		boolean caronas = false;
		for (int i = 0; i < Auxiliar.caronasAtivas.size(); i++) {
			if (Auxiliar.caronasAtivas.get(i).getEstado() == Estado.ABERTO) {
				if (Auxiliar.caronasAtivas.get(i).getRota().getSentido() != sentido) {
					System.out.println(Auxiliar.caronasAtivas.get(i).getID() + " "
										+ Auxiliar.caronasAtivas.get(i).getHost().getName() + " "
										+ ((Auxiliar.caronasAtivas.get(i).getRota().getSentido() == Sentido.IDA) ?
										Auxiliar.caronasAtivas.get(i).getRota().getDestino().getPontoDeEncontro().getNome()
										: Auxiliar.caronasAtivas.get(i).getRota().getOrigem().getPontoDeEncontro().getNome()));
					caronas = true;
				}
			}
		}

		if (!caronas)
			System.out.println("Sem caronas ativas no momento...");
		return caronas;
	}
}
