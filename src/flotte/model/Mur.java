package flotte.model;

public class Mur {

	private Entree e;

	private Sortie s;

	private double longeur;


	public Mur(Entree e, Sortie s, double longeur) {
		super();
		this.e = e;
		this.s = s;
		this.longeur = longeur;
	}

	public Entree getE() {
		return e;
	}

	public void setE(Entree e) {
		this.e = e;
	}

	public Sortie getS() {
		return s;
	}

	public void setS(Sortie s) {
		this.s = s;
	}

	public double getLongeur() {
		return longeur;
	}

	public void setLongeur(double longeur) {
		this.longeur = longeur;
	}


}
