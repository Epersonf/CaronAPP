package me.br.caronapp;

import me.br.caronapp.console.Console;
import me.br.caronapp.storage.*;
import me.br.caronapp.threads.TimeUpdater;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class Main {
	private static TimeUpdater updater;
	public static TimeUpdater getTimeUpdater() {
		return updater;
	}
	
	public static void main(String[] args) {
		Console console = new Console();
		Storable storage = new StorageManager();
		storage.carrega(Auxiliar.usuarios, Auxiliar.caronasAtivas);
		
		updater = new TimeUpdater();
		updater.start();
		
		while(console.draw()) {
			System.out.println("---------------------");
		}
		
		updater.stopThread();
		storage.salva(Auxiliar.usuarios, Auxiliar.caronasAtivas);
	}
}
