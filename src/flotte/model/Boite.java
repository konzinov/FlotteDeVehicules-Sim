package flotte.model;

import flotte.vue.Param;

public  class Boite extends Thread{
	
	public  static boolean signaleurs[];
	private int taille;
	
	public void run(){
		while(isAlive()){
		/*for(int i=0;i<signaleurs.length;i++){
			if(signaleurs[i]==false){
				Vehicule v = new Vehicule(i+1, null, true, null);
				System.out.println("REINSTANCIEEEE");
				Flotte.voitures.remove(i);
				Flotte.voitures.add(i, v);
			}
			
		}*/
		Param.vLibre.setText("Libre : "+Flotte.getNb_vehicule_dispo());
		}
	}
	
	

}
