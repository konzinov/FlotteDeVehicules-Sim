package flottevehicules.vue;

import flottevehicules.model.Anneau;
import flottevehicules.model.Entree;
import flottevehicules.model.Sortie;

import javax.swing.*;
import java.util.List;

public class Combo {

	public static Carte carte = new Carte(1000, 800);

	public static DefaultComboBoxModel<Entree> comboEntree;

	public static DefaultComboBoxModel<Sortie> comboSortie;

	public static List<Anneau> anneaux;

	public static DefaultComboBoxModel<Entree> initEntreesCombo() {
		if (comboEntree != null) {
			return comboEntree;
		}

		comboEntree = new DefaultComboBoxModel<>(carte.entrees.toArray(new Entree[0]));
		return comboEntree;
	}

	public static DefaultComboBoxModel<Sortie> initSortiesCombo() {
		if (comboSortie != null) {
			return comboSortie;
		}

		comboSortie = new DefaultComboBoxModel<>(carte.sorties.toArray(new Sortie[0]));
		return comboSortie;
	}

	public static List<Anneau> getAnneaux() {
		return carte.anneaux;
	}
}
