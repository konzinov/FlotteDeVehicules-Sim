package flottevehicules.model;


import java.util.ArrayList;
import java.util.List;

public class Trajectoire {

	private int distance;

	private List<Place> trajet = new ArrayList<>();

	public Trajectoire() {

	}

	public Trajectoire(int distance, List<Place> trajet) {
		super();
		this.distance = distance;
		this.trajet = trajet;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<Place> getTrajet() {
		return trajet;
	}


	public void setTrajet(List<Place> trajet) {
		this.trajet = trajet;
	}
}
