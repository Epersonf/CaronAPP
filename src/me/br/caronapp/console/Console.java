package me.br.caronapp.console;

import java.util.Calendar;
import java.util.Scanner;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.carona.Campus;
import me.br.caronapp.carona.Carona;
import me.br.caronapp.carona.PontosDeEncontro;
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
			System.out.println("1 - Listar caronas\n2 - Hostar carona\n3 - Pegar carona");
			break;
		case LISTAR_CARONAS:
			for (i = 0; i < Auxiliar.caronasAtivas.size(); i++) {
				System.out.println(Auxiliar.caronasAtivas.get(i).getHost().getName());
			}
			stage = Stage.LOBBY;
			break;
		case HOST_CARONA:
			int sentido;
			int numero;
			int idCampus;
			String nomeDaRua;
			
			Calendar calendar = Calendar.getInstance();
			System.out.println("Insira a data e a hora da carona que deseja criar (YYYY MM DD hh mm):");
			calendar.set(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), 00);
			System.out.println("1 - Sentido UFF\n2 - Saindo da UFF");
			do { sentido = scan.nextInt(); } while (sentido != 1 && sentido != 2);
			System.out.println("Escolha o local de " + ((sentido == 1) ? "destino:" : "partida:"));
			for (int j = 0; j<PontosDeEncontro.values().length; j++){
	            System.out.println(j + " - " + PontosDeEncontro.values()[j]);
	        }

			Auxiliar.criarCarona(new Carona(usuario, 0, calendar, null));
			
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
