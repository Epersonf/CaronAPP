package me.br.caronapp.threads;

import me.br.caronapp.Auxiliar;

/* Implementado por Eperson Cardoso Mayrink Xavier Filho */

public class TimeUpdater extends Thread {
	private boolean stop;
	
	public TimeUpdater() {
		stop = false;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
			Auxiliar.updateTime();
			if (!stop) run();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public void stopThread() {
		stop = true;
	}
	
}
