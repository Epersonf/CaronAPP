package me.br.caronapp.carona;

import java.io.Serializable;

/*
 * Author: Sérgio Ricardo
 */

public enum PontosDeEncontro implements Serializable {
	
	PRAIAVERMELHA(-22.904803478495584, -43.131681335771255, "Praia Vermelha"),
	GRAGOATA(-22.898498551332086, -43.13167245972899, "Gragoata"),
	VALONGUINHO(-22.89728221991382, -43.1249070250538, "Valonguinho"),
	IACS(-22.901133942752896, -43.12780925244254, "Iacs"),
	DIREITO(-22.903288183490385, -43.12584602327215, "Direito"),
	REITORIA(-22.902976868392013, -43.11642074094573, "Reitoria");
	
	private double latitude;
	private double longitude;
	private String nome;
	
	PontosDeEncontro(double latitude, double longitude, String nome) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
