package flotte.model;

import flotte.vue.Param;

public class Boite extends Thread {

	public static boolean signaleurs[];

	private int taille;

	public void run() {
		while (isAlive()) {
			Param.vLibre.setText("Libre : " + Flotte.getNb_vehicule_dispo());
		}
	}
}
