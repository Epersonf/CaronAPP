package me.br.caronapp.console;

import java.util.Scanner;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.carona.Carona;
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
			System.out.println("Decida o que fazer:\n1 - ");
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
			break;
		case LISTAR_CARONAS:
			for (i = 0; i < Auxiliar.caronasAtivas.size(); i++) {
				System.out.println(Auxiliar.caronasAtivas.get(i).getHost().getName());
			}
			System.out.println("Digite o ID da carona:");
			break;
		case HOST_CARONA:
			break;
		case ENTRAR_CARONA:
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
	
}
