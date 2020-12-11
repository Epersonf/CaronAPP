package me.br.caronapp.carona;

import java.io.Serializable;

/*
 * Author: Sérgio Ricardo
 */

public class Posicao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double latitude;
	private double longitude;
	private String nomeRua;
	private int numero;
	private String cep;
	
	public Posicao(double latitude, double longitude, String nomeRua, int numero, String cep) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.nomeRua = nomeRua;
		this.numero = numero;
		this.cep = cep;
	}
	
	public Posicao(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public int getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public PontosDeEncontro getPontoDeEncontro() {
		return null;
	}

	
	
}
