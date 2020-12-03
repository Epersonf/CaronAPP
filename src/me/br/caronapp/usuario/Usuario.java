package me.br.caronapp.usuario;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class Usuario implements Comparable<Usuario> {

	private int id;
	private String name;
	private String username;
	private String cpf;
	private String senha;
	
	public int getId() {
		return id;
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

	public Usuario(int id, String username, String name, String cpf, String senha) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public boolean podeLogar(String senha) {
		return this.senha.equals(senha);
	}
	
	@Override
	public int compareTo(Usuario o) {
		return this.getId() - o.getId();
	}
}
