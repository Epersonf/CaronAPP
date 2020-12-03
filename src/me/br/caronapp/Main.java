package me.br.caronapp;

import me.br.caronapp.console.Console;
import me.br.caronapp.threads.TimeUpdater;

public class Main {
	private static TimeUpdater updater;
	public static TimeUpdater getTimeUpdater() {
		return updater;
	}
	
	public static void main(String[] args) {
		Console console = new Console();
		
		updater = new TimeUpdater();
		updater.start();
		
		while(console.draw()) {
			System.out.println("---------------------");
		}
		
		updater.stopThread();
	}
}
