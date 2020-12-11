package me.br.caronapp.console.util;

import me.br.caronapp.Auxiliar;
import me.br.caronapp.console.Console;
import me.br.caronapp.console.Console.Stage;
import me.br.caronapp.usuario.Usuario;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class LoginRegistro {
	public static void loginRegistro(Console console) {
		System.out.println("Decida o que fazer:\n1 - Login\n2 - Registrar");
		int i = console.getScanner().nextInt();
		console.setStage((i == 1) ? Stage.LOGIN : Stage.REGISTRO);
	}
	
	public static void login(Console console) {
		String [] parameters = usernamePassword(console, false);
		Usuario user = Auxiliar.logar(parameters[0], parameters[1]);
		if (user == null) {System.out.println("Falha ao logar...");console.setStage(Stage.LOGIN_REGISTRO);return;}
		console.setUser(user);
		console.setStage(Stage.LOBBY);
	}
	
	public static void registro(Console console) {
		String[] parameters = usernamePassword(console, true);
		Usuario user = Auxiliar.register(parameters[0], parameters[2], parameters[3], parameters[1]);
		if (user == null) {System.out.println("Falha ao registrar...");console.setStage(Stage.LOGIN_REGISTRO);return;}
		console.setUser(user);
		console.setStage(Stage.LOBBY);
	}
	
	public static String[] usernamePassword(Console console, boolean register) {
		String[] user = new String[(!register) ? 2 : 4];
		System.out.println("Digite seu usuario: ");
		user[0] = console.getScanner().next();
		System.out.println("Digite sua senha: ");
		user[1] = console.getScanner().next();
		if (register) {
			System.out.println("Digite seu nome: ");
			user[2] = console.getScanner().next();
			System.out.println("Digite seu CPF: ");
			user[3] = console.getScanner().next();
		}
		return user;
	}
}
