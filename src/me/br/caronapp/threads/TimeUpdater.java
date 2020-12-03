package me.br.caronapp.threads;

import me.br.caronapp.Auxiliar;

public class TimeUpdater extends Thread {
	private boolean stop;
	
	public TimeUpdater() {
		stop = false;
	}
	
	public void run() {
		try {
			System.out.println("Executando...");
			Thread.sleep(500);
			Auxiliar.updateTime();
			if (!stop) run();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public void stopThread() {
		stop = true;
	}
	
}
