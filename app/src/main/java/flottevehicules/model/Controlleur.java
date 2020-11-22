package flottevehicules.model;

import flottevehicules.vue.Param;

public class Controlleur implements Runnable {
	public Boite boiteInfo = new Boite();

	public Thread t;

	boolean enpause;

	boolean stop;

	public boolean VerifierDispo() {
		if (Flotte.getNb_vehicule_dispo() > 0)
			return true;
		else
			return false;
	}

	public void run() {
		boiteInfo.start();
		while (!t.interrupted()) {
			synchronized (Param.demandes) {

				for (Demande d : Param.demandes) {


					if (!d.isTraite()) {
						System.out.println(d.getE().getLibEntree() + " " + d.getS().getLibSortie());
						int pos = Flotte.verifierDispo();
						System.out.println(pos);
						while (pos == -1) {
							pos = Flotte.verifierDispo();
							System.out.println("Pas de dispo pour demande " + d.getE().getLibEntree() + " " + d.getS().getLibSortie());
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						Flotte.voitures.get(pos).setStatut(false);
						Flotte.voitures.get(pos).calculerCourtChemin(d.getE(), d.getS());

						//Flotte.voitures.set(pos, new Vehicule(pos+1,null,true,null));
						if (Flotte.voitures.get(pos).t.isAlive()) {
							//
							System.out.println("THREAD VIVANT");
							Flotte.voitures.get(pos).t.stop();
							Flotte.voitures.set(pos, null);
							Flotte.voitures.set(pos, new Vehicule(pos + 1, null, false, null));
							Flotte.voitures.get(pos).calculerCourtChemin(d.getE(), d.getS());
							Flotte.setNb_vehicule_dispo(Flotte.getNb_vehicule_dispo() - 1);
							Flotte.voitures.get(pos).t.start();
						} else {
							System.out.println("THREAD TERMINE");
							//	Flotte.voitures.set(pos, new Vehicule(pos+1, null, true, null));
							Flotte.voitures.get(pos).t.stop();
							Flotte.voitures.set(pos, null);
							Flotte.voitures.set(pos, new Vehicule(pos + 1, null, false, null));
							Flotte.voitures.get(pos).calculerCourtChemin(d.getE(), d.getS());
							Flotte.setNb_vehicule_dispo(Flotte.getNb_vehicule_dispo() - 1);
							Flotte.voitures.get(pos).start();
						}

						d.setTraite(true);

					}
				}
			}
		}

	}

	public Controlleur() {
		enpause = false;
		stop = false;
		t = new Thread(this);
	}

	public void start() {
		t = new Thread(this);
		t.start();
	}

	public synchronized void arreter() {
		stop = true;
		enpause = false;
		notify();
	}

	public synchronized void pauser() {
		enpause = true;
	}

	public synchronized void reprendre() {
		enpause = false;
		notify();
	}
}
