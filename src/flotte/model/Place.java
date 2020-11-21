package flotte.model;

public class Place extends Thread {
	private int numPlace;

	private Point localisation;

	private boolean statut = true;

	public Place(int n, Point nP) {
		localisation = new Point(nP.getLibPoint(), nP.getX(), nP.getY());
		numPlace = n;
	}

	public Place() {
		super();
	}

	public int getNumPlace() {
		return numPlace;
	}

	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}

	public Point getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Point localisation) {
		this.localisation = localisation;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public synchronized void reserver() throws InterruptedException {
		while (!statut) {
			wait();
		}
		statut = false;
		Thread.sleep(1000);
	}

	public synchronized void liberer() {
		statut = true;
		notifyAll();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
