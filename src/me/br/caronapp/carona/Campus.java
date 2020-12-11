package me.br.caronapp.carona;

/*
 * Author: Sérgio Ricardo
 */

public class Campus extends Posicao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PontosDeEncontro pontoDeEncontro;
	
	public Campus(PontosDeEncontro pontoDeEncontro) {
		super(pontoDeEncontro.getLatitude(), pontoDeEncontro.getLongitude());
		this.pontoDeEncontro = pontoDeEncontro;
	}
	
	@Override
	public PontosDeEncontro getPontoDeEncontro() {
		return pontoDeEncontro;
	}

}
