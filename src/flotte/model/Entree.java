package flotte.model;

public class Entree extends Place {
	private int numEntree;
	private String libEntree;
    public static int nbPassagerAtt;
    
    

	public Entree() {
		super();
	}

	public Entree(int n, Point nP, int numEntree, String libEntree) {
		super(n, nP);
		this.numEntree = numEntree;
		this.libEntree = libEntree;
	}

	public int getNumEntree() {
		return numEntree;
	}

	public void setNumEntree(int numEntree) {
		this.numEntree = numEntree;
	}

	public String getLibEntree() {
		return libEntree;
	}

	public void setLibEntree(String libEntree) {
		this.libEntree = libEntree;
	} 
	
	@Override
	public String toString(){
	//	return this.getLocalisation().getX()+" "+ this.getLocalisation().getY();
		return this.libEntree;
	}

}
