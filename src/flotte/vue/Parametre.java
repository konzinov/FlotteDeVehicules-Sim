package flotte.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import flotte.model.Entree;
import flotte.model.Sortie;

public class Parametre extends JPanel{
	GridBagLayout g = new GridBagLayout();
	GridBagConstraints gc = new GridBagConstraints();
	JButton btnajout = new JButton("Ajouter");
	JButton btnmodifier = new JButton("Modifier");
	JButton btnsupprimer = new JButton("Supprimer");
	JLabel src = new JLabel("Depart");
	JComboBox comboDepart = new JComboBox() ;
	JComboBox comboArrivee =  new JComboBox();
	JLabel dest = new JLabel("Destination"); 
	JLabel labnom = new JLabel("Nom");
	JTextField nom = new  JTextField();
	GridBagConstraints gbc = new GridBagConstraints();
	public Parametre(){
		setLayout(g);
		comboDepart.setModel(Combo.getComboEntree());
		comboArrivee.setModel(Combo.getComboSortie());
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight = 2;
		gc.fill = GridBagConstraints.BOTH;
		add(labnom, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 10;
		gc.gridheight = 5;
		gc.fill = GridBagConstraints.BOTH;
		add(nom, gc);		
				
		
	}
}
