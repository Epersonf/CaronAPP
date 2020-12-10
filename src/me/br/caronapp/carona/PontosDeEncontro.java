package me.br.caronapp.carona;

/*
 * Author: Sérgio Ricardo
 */

public enum PontosDeEncontro {

	//TODO: corrigir coordenadas.
	
	PRAIAVERMELHA(1, 1, "Praia Vermelha"),
	GRAGOATA(2, 2, "Gragoata"),
	VALONGUINHO(3, 3, "Valonguinho"),
	IACS(4, 4, "Iacs"),
	DIREITO(5, 5, "Direito"),
	REITORIA(6, 6, "Reitoria");
	
	private float latitude;
	private float longitude;
	private String nome;
	
	PontosDeEncontro(float latitude, float longitude, String nome) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
}
