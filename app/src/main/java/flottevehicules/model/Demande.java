package flottevehicules.model;

public class Demande {

	private String nom;

	private Entree e;

	private Sortie s;

	private boolean traite;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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


	public boolean isTraite() {
		return traite;
	}

	public void setTraite(boolean traite) {
		this.traite = traite;
	}

	public Demande(String nom, Entree e, Sortie s, Boolean traite) {
		super();
		this.nom = nom;
		this.e = e;
		this.s = s;
		this.traite = traite;
	}

	public Demande() {

	}
}
