package me.br.caronapp.carona;

/*
 * Author: Sérgio Ricardo
 */

public class Posicao {

	private float latitude;
	private float longitude;
	private String nomeRua;
	private int numero;
	private String cep;
	
	public Posicao(float latitude, float longitude, String nomeRua, int numero, String cep) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.nomeRua = nomeRua;
		this.numero = numero;
		this.cep = cep;
	}
	
	public Posicao(float latitude, float longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
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

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(float longitude) {
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

	
	
}
