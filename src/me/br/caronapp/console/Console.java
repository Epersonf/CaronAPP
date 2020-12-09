package me.br.caronapp.console;

import java.util.Scanner;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.carona.Campus;
import me.br.caronapp.carona.Carona;
import me.br.caronapp.carona.PontosDeEncontro;
import me.br.caronapp.carona.Rota.Sentido;
import me.br.caronapp.console.util.ListarCaronas;
import me.br.caronapp.console.util.Lobby;
import me.br.caronapp.console.util.LoginRegistro;
import me.br.caronapp.usuario.Usuario;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class Console {
	
	public enum Stage {
		/* COMANDOS INICIAIS */
		LOGIN_REGISTRO,
		LOGIN,
		REGISTRO,
		/* COMANDOS LOGADO */
		LOBBY,
		LISTAR_CARONAS,
		HOST_CARONA,
		ENTRAR_CARONA,
		DESLOGAR,
		/* ADMINISTRADOR */		
		;
	}
	
	private Scanner scan;
	private Stage stage;
	private Usuario usuario;
	
	public Console() {
		scan = new Scanner(System.in);
		stage = Stage.LOGIN_REGISTRO;
		usuario = null;
	}
	
	public boolean draw() {		
		switch (stage) {
		case LOGIN_REGISTRO:
			LoginRegistro.loginRegistro(this);
			break;
		case LOGIN:
			LoginRegistro.login(this);
			break;
		case REGISTRO:
			LoginRegistro.registro(this);
			break;
		/*COMANDOS LOGADO*/
		case LOBBY:
			Lobby.draw(this);
			break;
		case LISTAR_CARONAS:
			ListarCaronas.draw(this);
			break;
		case HOST_CARONA:
			break;
		case ENTRAR_CARONA:
			break;
		case DESLOGAR:
			usuario = null;
			stage = Stage.LOGIN_REGISTRO;
			break;
		/*  */
		default:
			System.out.println("Finalizando console...");
			scan.close();
			break;
		}
		
		
		return true;
	}
	
	public Scanner getScanner() {
		return this.scan;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setUser(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isAdm() {
		return usuario.isAdm();
	}
}
