package me.br.caronapp.carona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import me.br.caronapp.usuario.Usuario;
import me.br.caronapp.carona.excecoes.*;

/*
 * Author: S�rgio Ricardo
 */

public class Carona implements Serializable {
	
	 // ABERTO: Aceita guests.
	 // AGUARDANDO, FECHADO e FINALIZADO: N�o aceita guests.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Estado {ABERTO, AGUARDANDO, FECHADO, FINALIZADO};
	
	private Usuario host;
	private ArrayList<Usuario> guests = new ArrayList<Usuario>();
	private int maximoGuests;
	private Calendar dataHora;
	private Rota rota;
	private Estado estado;
	
	public Carona(Usuario host, int maximoGuests, Calendar dataHora, Rota rota) {
		super();
		this.host = host;
		this.maximoGuests = maximoGuests;
		this.dataHora = dataHora;
		this.rota = rota;
		this.estado = Estado.ABERTO;
	}
	
	public void adicionaPassageiro(Usuario user) throws VagasExcedidasException {
		if (getVagasPreenchidas() < maximoGuests) {
			guests.add(user);
		} else {
			throw new VagasExcedidasException();
		}
	}
	
	public void removePassageiro(Usuario user) throws UsuarioNaoEncontradoException {
		if (!guests.remove(user)) throw new UsuarioNaoEncontradoException();
	}
	
	public void removePassageiro(String username) throws UsuarioNaoEncontradoException {
		for (Usuario u : guests) if (u.getUsername().equalsIgnoreCase(username)) {removePassageiro(u);return;}
		throw new UsuarioNaoEncontradoException();
	}
	
	public void atualiza() {
		//TODO: implementar m�todo.
	}
	
	// Getters and Setters
	
	public int getVagasPreenchidas() {
		return guests.size();
	}
	
	public Usuario getHost() {
		return host;
	}

	public int getMaximoGuests() {
		return maximoGuests;
	}

	public void setMaximoGuests(int maximoGuests) {
		this.maximoGuests = maximoGuests;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		
		//TODO: alterar restri��es.
		this.estado = estado;
	}
	
}
