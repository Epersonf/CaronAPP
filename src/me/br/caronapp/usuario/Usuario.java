package me.br.caronapp.usuario;

import java.io.Serializable;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class Usuario implements Comparable<Usuario>, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String username;
	private String cpf;
	private String senha;
	private boolean adm;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAdm() {
		return adm;
	}

	public Usuario(String username, String name, String cpf, String senha) {
		this.username = username;
		this.name = name;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public boolean podeLogar(String username, String senha) {
		if (!username.equalsIgnoreCase(this.username)) return false;
		return this.senha.equals(senha);
	}
	
	@Override
	public int compareTo(Usuario o) {
		return o.getUsername().compareTo(this.getUsername());
	}
	
	public boolean equals(Usuario o) {
		return o.getUsername().equalsIgnoreCase(o.getName());
	}
}
