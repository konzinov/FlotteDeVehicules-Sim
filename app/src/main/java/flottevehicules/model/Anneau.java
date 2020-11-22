package flottevehicules.model;

public class Anneau extends Place {

	private int numAnneau;

	private String libAnneau;

	public Anneau(int n, Point nP, int numAnneau, String libAnneau) {
		super(n, nP);
		this.numAnneau = numAnneau;
		this.libAnneau = libAnneau;
	}

	public Anneau() {
		super();
	}

	public int getNumAnneau() {
		return numAnneau;
	}

	public void setNumAnneau(int numAnneau) {
		this.numAnneau = numAnneau;
	}

	public String getLibAnneau() {
		return libAnneau;
	}

	public void setLibAnneau(String libAnneau) {
		this.libAnneau = libAnneau;
	}


}
