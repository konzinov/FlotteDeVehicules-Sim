package flotte.model;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import flotte.vue.Carte;
import flotte.vue.Menu;
import flotte.vue.Param;

public class Flotte {
private static int Nb_vehicule_flotte=0;
private static int Nb_vehicule_dispo=0;
public static List<Vehicule> voitures = new ArrayList<Vehicule>();
public Flotte()
{
	Nb_vehicule_dispo=5;
	Nb_vehicule_flotte=5;
}
public Flotte(int nb_vehicule_flotte, int nb_vehicule_dispo) {
	super();
	Nb_vehicule_flotte = nb_vehicule_flotte;
	Nb_vehicule_dispo = nb_vehicule_dispo;
}
public static void Ajouter_vehicule()
{
	Nb_vehicule_flotte++;
	Nb_vehicule_dispo++;
	voitures.add(new Vehicule(Nb_vehicule_flotte, null, true, null));
	Carte.voitures.add(new Ellipse2D.Double());
}
public static void Retirer_vehicule()
{
	if(Nb_vehicule_flotte!=0){
	Nb_vehicule_flotte--;
	Nb_vehicule_dispo--;
	voitures.remove(0);
	for(int i = 0;i<voitures.size();i++){
		voitures.get(i).setNumVehicule(i);
	}
	}
	if(!Carte.voitures.isEmpty())
	Carte.voitures.remove(0);
}
public static int getNb_vehicule_flotte() {
	return Nb_vehicule_flotte;
}
public static void setNb_vehicule_flotte(int nb_vehicule_flotte) {
	Nb_vehicule_flotte = nb_vehicule_flotte;
}
public static int getNb_vehicule_dispo() {
	
	return Nb_vehicule_dispo;
}
public static void setNb_vehicule_dispo(int nb_vehicule_dispo) {
	Nb_vehicule_dispo = nb_vehicule_dispo;
}

public static int verifierDispo(){
	Vehicule resultat =  new Vehicule();
	boolean trv=false;
	int pos=0;
	for(Vehicule v : voitures){
		pos++;
		if(v.getStatut()==true){
			resultat =v;
			trv =true;
		
			break;
		}
		
	}
	System.out.println("Depuis Flotte: "+pos);
	if(trv)
		return pos-1;
	else 
		return -1;
	
	
}
}
