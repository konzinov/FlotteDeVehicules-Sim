package flottevehicules.model;

public class Sortie extends Place {
	private int numSortie;

	private String libSortie;

	public Sortie() {
		super();
	}

	public Sortie(int n, Point nP, int numSortie, String libSortie) {
		super(n, nP);
		this.numSortie = numSortie;
		this.libSortie = libSortie;
	}

	public int getNumSortie() {
		return numSortie;
	}

	public void setNumSortie(int numSortie) {
		this.numSortie = numSortie;
	}

	public String getLibSortie() {
		return libSortie;
	}

	public void setLibSortie(String libSortie) {
		this.libSortie = libSortie;
	}

	@Override
	public String toString() {
		//return this.getLocalisation().getX()+" "+ this.getLocalisation().getY();
		return this.libSortie;
	}

}
