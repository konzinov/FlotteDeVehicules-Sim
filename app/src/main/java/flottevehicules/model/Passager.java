package flottevehicules.model;

public class Passager {
	public static int nbPassager;

	private int idPassager;

	private String nom;

	private Boolean statut;

	private Entree src;

	private Sortie dest;


	public Passager(String nom, Boolean statut) {
		nbPassager++;
		this.idPassager = nbPassager;
		this.nom = nom;
		this.statut = statut;
		this.src = null;
		this.dest = null;
	}

	public int getIdPassager() {
		return idPassager;
	}

	public void setIdPassager(int idPassager) {
		this.idPassager = idPassager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public Entree getSrc() {
		return src;
	}

	public void setSrc(Entree src) {
		this.src = src;
	}

	public Sortie getDest() {
		return dest;
	}

	public void setDest(Sortie dest) {
		this.dest = dest;
	}


}
