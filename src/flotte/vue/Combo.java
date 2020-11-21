package flotte.vue;

import flotte.model.Anneau;
import flotte.model.Entree;
import flotte.model.Sortie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class Combo {
	public static DefaultComboBoxModel<Entree> comboEntree;

	public static DefaultComboBoxModel<Sortie> comboSortie;

	static List<Entree> entrees = new ArrayList<>();

	static List<Sortie> sorties = new ArrayList<>();

	public static Carte clo = new Carte(1000, 800);

	public static DefaultComboBoxModel<Entree> getComboEntree() {

		comboEntree = new DefaultComboBoxModel<Entree>();
		entrees.add(clo.e1);
		entrees.add(clo.e2);
		entrees.add(clo.e3);
		entrees.add(clo.e4);
		entrees.add(clo.e5);
		entrees.add(clo.e6);

		for (Entree entree : entrees) {
			comboEntree.addElement(entree);
		}
		return comboEntree;
	}

	public static void setComboEntree(DefaultComboBoxModel<Entree> comboEntree) {
		Combo.comboEntree = comboEntree;
	}

	public static DefaultComboBoxModel<Sortie> getComboSortie() {
		comboSortie = new DefaultComboBoxModel<Sortie>();
		sorties.add(clo.s1);
		sorties.add(clo.s2);
		sorties.add(clo.s3);
		sorties.add(clo.s4);
		sorties.add(clo.s5);
		sorties.add(clo.s6);
		for (Sortie sortie : sorties) {
			comboSortie.addElement(sortie);
		}
		return comboSortie;
	}

	public static void setComboSortie(DefaultComboBoxModel<Sortie> comboSortie) {
		Combo.comboSortie = comboSortie;
	}

	public static List<Anneau> anneaux = new ArrayList<Anneau>();

	public static List<Anneau> getAnneaux() {
		anneaux.add(clo.a0);
		anneaux.add(clo.a1);
		anneaux.add(clo.a2);
		anneaux.add(clo.a3);
		anneaux.add(clo.a4);
		anneaux.add(clo.a5);
		anneaux.add(clo.a6);
		return anneaux;
	}

	public static void setAnneaux(List<Anneau> anneaux) {
		Combo.anneaux = anneaux;
	}

	public static TableModel demandes;

	public static TableModel getDemandes() {
		Object[][] colonnes = {
				{null, null, null},
				{null, null, null},
				{null, null, null}

		};
		String entete[] = {"NOM", "ENTREE", "SORTIE"};
		demandes = new DefaultTableModel(colonnes, entete);
		return demandes;
	}

	public static void setDemandes(DefaultTableModel demandes) {
		Combo.demandes = demandes;
	}


}
