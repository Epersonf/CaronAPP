package me.br.caronapp.console;

import java.util.Scanner;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.carona.Campus;
import me.br.caronapp.carona.Carona;
import me.br.caronapp.carona.PontosDeEncontro;
import me.br.caronapp.carona.Rota.Sentido;
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
	
	Scanner scan;
	Stage stage;
	Usuario usuario;
	
	public Console() {
		scan = new Scanner(System.in);
		stage = Stage.LOGIN_REGISTRO;
		usuario = null;
	}
	
	public boolean draw() {
		String[] parameters;
		Usuario user;
		int i;
		
		switch (stage) {
		case LOGIN_REGISTRO:
			System.out.println("Decida o que fazer:\n1 - Login\n2 - Registrar");
			i = scan.nextInt();
			stage = (i == 1) ? Stage.LOGIN : Stage.REGISTRO;
			break;
		case LOGIN:
			parameters = usernamePassword(false);
			user = Auxiliar.logar(parameters[0], parameters[1]);
			if (user == null) {stage = Stage.LOGIN_REGISTRO;break;}
			stage = Stage.LOBBY;
			break;
		case REGISTRO:
			parameters = usernamePassword(true);
			user = Auxiliar.register(parameters[0], parameters[2], parameters[3], parameters[1]);
			if (user == null) {stage = Stage.LOGIN_REGISTRO;break;}
			stage = Stage.LOBBY;
			break;
		/*COMANDOS LOGADO*/
		case LOBBY:
			System.out.println("1 - Listar caronas\n2 - Hostar carona\n3 - Pegar carona");
			break;
		case LISTAR_CARONAS:
			System.out.println("Deseja ir ou voltar? (1 - ir / 2 - voltar)");
			mostrarCaronas((scan.nextInt() == 1) ? Sentido.IDA : Sentido.VOLTA);
			stage = Stage.LOBBY;
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
	
	public String[] usernamePassword(boolean register) {
		String[] user = new String[(!register) ? 2 : 4];
		System.out.println("Digite seu usuario: ");
		user[0] = scan.next();
		System.out.println("Digite sua senha: ");
		user[1] = scan.next();
		if (register) {
			System.out.println("Digite seu nome: ");
			user[2] = scan.next();
			System.out.println("Digite seu CPF: ");
			user[3] = scan.next();
		}
		return user;
	}
	
	public Campus selecionarCampus() {
		try {
			for (int i = 0; i < PontosDeEncontro.values().length; i++) {
				System.out.println(i + " - " + PontosDeEncontro.values()[i].getNome());
			}
			System.out.println("-----------\nDigite o id nome do campus:");
			return new Campus(PontosDeEncontro.values()[scan.nextInt()]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Id invalido...");
			return null;
		}
	}
	
	public void mostrarCaronas(Sentido sentido) {
		for (int i = 0; i < Auxiliar.caronasAtivas.size(); i++) {
			if (Auxiliar.caronasAtivas.get(i).getRota().getSentido() != sentido) continue;
			System.out.println(Auxiliar.caronasAtivas.get(i).getHost().getName());
		}
	}
}
