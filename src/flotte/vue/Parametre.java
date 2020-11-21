package flotte.vue;

import javax.swing.*;
import java.awt.*;

public class Parametre extends JPanel {
	GridBagLayout gridBagLayout = new GridBagLayout();

	GridBagConstraints gridBagConstraints = new GridBagConstraints();

	JLabel src = new JLabel("Depart");

	JComboBox comboDepart = new JComboBox();

	JComboBox comboArrivee = new JComboBox();

	JLabel dest = new JLabel("Destination");

	JLabel labnom = new JLabel("Nom");

	JTextField nom = new JTextField();

	GridBagConstraints gbc = new GridBagConstraints();

	public Parametre() {
		setLayout(gridBagLayout);
		comboDepart.setModel(Combo.getComboEntree());
		comboArrivee.setModel(Combo.getComboSortie());
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		add(labnom, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 10;
		gridBagConstraints.gridheight = 5;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		add(nom, gridBagConstraints);
	}
}
