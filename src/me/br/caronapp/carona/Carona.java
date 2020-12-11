package me.br.caronapp.carona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import me.br.caronapp.usuario.Usuario;
import me.br.caronapp.carona.excecoes.*;

/*
 * Author: Sérgio Ricardo
 * Modificado por Eperson Filho
 */

public class Carona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int serial = 0;
	
	public enum Estado {ABERTO, AGUARDANDO, FECHADO, FINALIZADO};	// ABERTO: Aceita guests.
	 																// AGUARDANDO, FECHADO e FINALIZADO: Não aceita guests.
	
	private Usuario host;
	private ArrayList<Usuario> guests = new ArrayList<Usuario>();
	private int maximoGuests;
	private Calendar dataHora;
	private Rota rota;
	private Estado estado;
	
	private int id;
	
	public Carona(Usuario host, int maximoGuests, Calendar dataHora, Rota rota) {
		super();
		this.host = host;
		this.maximoGuests = maximoGuests;
		this.dataHora = dataHora;
		this.rota = rota;
		this.estado = Estado.ABERTO;
		
		serial++;
		this.id = serial;
	}
	
	public void adicionaPassageiro(Usuario user) throws VagasExcedidasException {
		if (estado == Estado.ABERTO) {
			if (getVagasPreenchidas() < maximoGuests) {
				guests.add(user);
				if (getVagasPreenchidas() == maximoGuests) {
					setEstado(Estado.FECHADO);
				}
				user.addCarona(this);
			} else {
				throw new VagasExcedidasException();
			}
		}
	}
	
	public void removePassageiro(Usuario user) throws UsuarioNaoEncontradoException {
		if (!guests.remove(user)) throw new UsuarioNaoEncontradoException();
		else
			user.cancelaCarona(this);
	}
	
	public void removePassageiro(String username) throws UsuarioNaoEncontradoException {
		for (Usuario u : guests) if (u.getUsername().equalsIgnoreCase(username)) {removePassageiro(u);return;}
		throw new UsuarioNaoEncontradoException();
	}
	
	public void atualiza() {
		//TODO: implementar método.
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
		this.estado = estado;
		if (this.estado.equals(Estado.FINALIZADO))
			this.finaliza();
	}
	
	private void finaliza() {
		host.finalizaCarona(this);
		for (int i = 0; i < guests.size(); i++)
			guests.get(i).finalizaCarona(this);
	}
	
	public int getID() {
		return id;
	}
	
}
