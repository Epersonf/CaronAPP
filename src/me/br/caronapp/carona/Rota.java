package me.br.caronapp.carona;

/*
 * Author: Sérgio Ricardo
 */

public class Rota {

	public enum Sentido {IDA, VOLTA};
	
	private Posicao origem;
	private Posicao destino;
	private Sentido sentido;
	
	public Rota(Posicao origem, Posicao destino) {
		this.origem = origem;
		this.destino = destino;
		this.sentido = (destino instanceof Campus) ? Sentido.IDA : Sentido.VOLTA;
	}

	public Posicao getOrigem() {
		return origem;
	}

	public Posicao getDestino() {
		return destino;
	}
	
	public Sentido getSentido() {
		return sentido;
	}
	
}
