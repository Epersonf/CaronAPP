package me.br.caronapp.carona;

/*
 * Author: Sérgio Ricardo
 */

public class Campus extends Posicao {

	private PontosDeEncontro pontoDeEncontro;
	
	public Campus(PontosDeEncontro pontoDeEncontro, float latitude, float longitude) {
		super(pontoDeEncontro.getLatitude(), pontoDeEncontro.getLongitude());
		this.pontoDeEncontro = pontoDeEncontro;
	}

	public PontosDeEncontro getPontoDeEncontro() {
		return pontoDeEncontro;
	}

}
