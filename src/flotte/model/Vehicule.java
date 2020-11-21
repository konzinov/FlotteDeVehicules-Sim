package flotte.model;

import flotte.vue.Combo;
import flotte.vue.Menu;

import java.util.ArrayList;
import java.util.List;

public class Vehicule implements Runnable {
	public static int nbVehicule;

	private int numVehicule;

	private String couleur;

	private Boolean statut;

	private Trajectoire trajet = new Trajectoire();

	private Trajectoire demandes = new Trajectoire();

	private Point coordonnes;

	public Thread t;

	public Vehicule() {

	}

	public Vehicule(int numVehicule, String couleur, Boolean statut, Point coordonnees) {
		super();
		nbVehicule++;
		this.numVehicule = numVehicule;
		this.couleur = couleur;
		this.statut = statut;
		this.trajet = new Trajectoire();
		this.coordonnes = coordonnees;
		t = new Thread(this);
	}

	public int getNumVehicule() {
		return numVehicule;
	}

	public void setNumVehicule(int numVehicule) {
		this.numVehicule = numVehicule;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public Trajectoire getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajectoire trajet) {
		this.trajet = trajet;
	}


	public Point getCoordonnes() {
		return coordonnes;
	}

	public void setCoordonnes(Point coordonnes) {
		this.coordonnes = coordonnes;
	}

	public void calculerCourtChemin(Entree e, Sortie s) {

		Combo.getAnneaux();
		if (Math.abs(s.getNumSortie() - e.getNumEntree()) == 3) {
			trajet.getTrajet().add(e);
			trajet.getTrajet().add(Combo.anneaux.get(e.getNumPlace() - 6));
			trajet.getTrajet().add(Combo.clo.a0);
			trajet.getTrajet().add(Combo.anneaux.get(s.getNumPlace() - 12));
			trajet.getTrajet().add(s);
		} else {
			int cpt1 = Math.abs(e.getNumEntree() - s.getNumSortie()) + 1;
			int cpt2 = 6 - Math.max(e.getNumEntree(), s.getNumSortie()) + Math.min(e.getNumEntree(), s.getNumSortie()) + 1;
			if (cpt1 < cpt2) {
				trajet.getTrajet().add(e);
				if (s.getNumSortie() > e.getNumEntree()) {
					for (int i = e.getNumEntree(); i <= s.getNumSortie(); i++) {
						trajet.getTrajet().add(Combo.anneaux.get(i));
					}

				} else {
					for (int i = e.getNumEntree(); i >= s.getNumSortie(); i--) {
						trajet.getTrajet().add(Combo.anneaux.get(i));
					}
				}
				trajet.getTrajet().add(s);
			} else {
				trajet.getTrajet().add(e);
				if (s.getNumSortie() > e.getNumEntree()) {
					for (int i = e.getNumEntree(); i >= 1; i--) {
						trajet.getTrajet().add(Combo.anneaux.get(i));
					}
					for (int i = 6; i >= s.getNumSortie(); i--) {
						trajet.getTrajet().add(Combo.anneaux.get(i));
					}


				} else {

					for (int i = e.getNumEntree(); i <= 6; i++) {
						trajet.getTrajet().add(Combo.anneaux.get(i));
					}
					for (int i = 1; i <= s.getNumSortie(); i++) {
						trajet.getTrajet().add(Combo.anneaux.get(i));
					}
				}
				trajet.getTrajet().add(s);
			}
		}

		demandes.setTrajet(ordonnerRessource());
		System.out.println("Vehicule " + this.numVehicule);
		for (Place p : this.demandes.getTrajet()) {
			System.out.print(+p.getNumPlace() + " ");
		}
		System.out.println(" ");
	}

	public void run() {

		for (Place p : demandes.getTrajet()) {
			try {
				Menu.c.placesCarte.get(p.getNumPlace()).reserver();
				System.out.println(numVehicule + " Reserve" + p.getNumPlace());


			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}


		System.out.println(numVehicule + " libere");
		this.seDeplacer();
		System.out.println("Taille à la fin " + demandes.getTrajet().size());
		this.statut = true;
		Flotte.setNb_vehicule_dispo(Flotte.getNb_vehicule_dispo() + 1);


	}

	public void seDeplacer() {
		int cpt = 0;
		int prec = 0;
		for (Place p : trajet.getTrajet()) {
			cpt++;
			System.out.println("Voiture " + this.getNumVehicule() + "parcours " + p.getNumPlace());

			Menu.c.voitures.get(this.numVehicule - 1).setFrame(p.getLocalisation().getX() - 10, p.getLocalisation().getY() - 10, 20, 20);
			Menu.c.repaint();


			if (cpt > 1) {
				Menu.c.placesCarte.get(prec).liberer();

			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//else notify();

			prec = p.getNumPlace();
			System.out.println("Précédent " + prec);
		}
		Menu.c.placesCarte.get(prec).liberer();
		Menu.c.voitures.get(this.numVehicule - 1).setFrame(0, 0, 20, 20);
		Menu.c.repaint();


		/*try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		this.trajet.getTrajet().clear();
		this.demandes.getTrajet().clear();
	}

	public synchronized void recruter() {
		while (!statut) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void start() {
		t.start();
	}

	public List<Place> ordonnerRessource() {
		List<Place> copie = new ArrayList<Place>();
		copie.addAll(trajet.getTrajet());

		List<Place> resultat = new ArrayList<Place>();
		resultat.add(copie.get(0));
		copie.remove(0);
		int iterr = copie.size() - 1;
		for (int i = 0; i < iterr; i++) {
			int min = 0;
			int pos = 0;
			for (int j = 0; j < copie.size() - 1; j++) {
				if (j == 0) min = copie.get(0).getNumPlace();
				if (min > copie.get(j).getNumPlace()) {
					min = copie.get(j).getNumPlace();
					pos = j;

				}

			}
			resultat.add(copie.get(pos));
			copie.remove(pos);
		}
		resultat.add(copie.get(0));
		return resultat;
	}

}

