package me.br.caronapp.carona;

/*
 * Author: S�rgio Ricardo
 */

public class Campus extends Posicao {

	private PontosDeEncontro pontoDeEncontro;
	
	public Campus(PontosDeEncontro pontoDeEncontro) {
		super(pontoDeEncontro.getLatitude(), pontoDeEncontro.getLongitude());
		this.pontoDeEncontro = pontoDeEncontro;
	}

	public PontosDeEncontro getPontoDeEncontro() {
		return pontoDeEncontro;
	}

}
