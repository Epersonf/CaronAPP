package me.br.caronapp.carona;

/*
 * Author: Sérgio Ricardo
 */

public enum PontosDeEncontro {

	//TODO: corrigir coordenadas.
	
	PRAIAVERMELHA(1, 1),
	GRAGOATA(2, 2),
	VALONGUINHO(3, 3),
	IACS(4, 4),
	DIREITO(5, 5),
	REITORIA(6, 6);
	
	private float latitude;
	private float longitude;
	
	PontosDeEncontro(float latitude, float longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
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
