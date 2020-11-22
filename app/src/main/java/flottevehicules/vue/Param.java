package flottevehicules.vue;


import flottevehicules.model.Boite;
import flottevehicules.model.Controlleur;
import flottevehicules.model.Demande;
import flottevehicules.model.Entree;
import flottevehicules.model.Flotte;
import flottevehicules.model.Sortie;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Param extends javax.swing.JPanel {

	public Param() {
		initComponents();
		entreesComboBox.setModel(Combo.initEntreesCombo());
		sortiesCombox.setModel(Combo.initSortiesCombo());
		this.viderChamp();
		this.buildTableDemandes();
	}

	private void initComponents() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		entreesComboBox = new JComboBox<>();
		sortiesCombox = new JComboBox<>();
		jScrollPane2 = new JScrollPane();

		tableDemandes = new javax.swing.JTable() {
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};

		tableDemandes = new JTable();

		ajouterDemandeButton = new JButton("Ajouter", iconOf("add.png"));
		ajouterDemandeButton.addActionListener(this::ajouterDemandeHandler);

		modifierDemandeButton = new JButton("Modifier", iconOf("application_edit.png"));
		modifierDemandeButton.addActionListener(this::modifierDemandeHandler);

		supprimerDemandeButton = new JButton("Supprimer", iconOf("delete.png"));
		supprimerDemandeButton.addActionListener(this::supprimerDemndeHandler);


		jLabel1.setText("Nom");

		jLabel2.setText("Entree");

		jLabel3.setText("Sortie");

		entreesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

		sortiesCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

		JTableHeader header = tableDemandes.getTableHeader();
		header.setReorderingAllowed(false);
		header.setBackground(Color.white);

		jScrollPane2.setViewportView(tableDemandes);



		//jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flotte/vue/delete.png"))); // NOI18N
		supprimerDemandeButton.setText("Supprimer");

		nom = new JTextField();
		nom.setColumns(10);

		tableDemandes.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				tableDemandesMousePressed(evt);
			}
		});

		JButton btnLancer = new JButton("Lancer");
		btnLancer.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/connect.png"));
		btnLancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlleur.start();
			}
		});

		pauseButton = new JButton("Pause");
		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlleur.pauser();
			}
		});
		pauseButton.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/disconnect.png"));

		reprendreButton = new JButton("Reprendre");
		reprendreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlleur.reprendre();
			}
		});

		arreterButton = new JButton("Arreter");
		arreterButton.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/circle_red.png"));
		arreterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlleur.arreter();
			}
		});

		vTotal = new JLabel("Vehicules : " + Flotte.getNb_vehicule_flotte());

		vLibre = new JLabel("Libre : " + Flotte.getNb_vehicule_dispo());

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Flotte.Ajouter_vehicule();
				Boite.signaleurs = new boolean[Flotte.getNb_vehicule_flotte()];
				vTotal.setText("Vehicules : " + Flotte.getNb_vehicule_flotte());
				vLibre.setText("Libre : " + Flotte.getNb_vehicule_dispo());

			}
		});
		button.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/add.png"));

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flotte.Retirer_vehicule();
				vTotal.setText("Vehicules : " + Flotte.getNb_vehicule_flotte());
				vLibre.setText("Libre : " + Flotte.getNb_vehicule_dispo());

			}
		});
		button_1.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/delete.png"));

		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viderChamp();
			}
		});

		JEditorPane editorPane = new JEditorPane();


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.TRAILING)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addContainerGap(30, Short.MAX_VALUE)
																		.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED))
																.addGroup(layout.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
																		.addGap(8)))
														.addGroup(layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)))
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(entreesComboBox, 0, 186, Short.MAX_VALUE)
														.addComponent(nom, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
														.addComponent(sortiesCombox, Alignment.TRAILING, 0, 186, Short.MAX_VALUE))
												.addGap(56)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(modifierDemandeButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
														.addComponent(supprimerDemandeButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
														.addComponent(ajouterDemandeButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnNouveau))
												.addGap(61))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(button, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
														.addComponent(vLibre, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
														.addComponent(vTotal, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(pauseButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
																.addGap(31)
																.addComponent(arreterButton))
														.addGroup(layout.createSequentialGroup()
																.addComponent(btnLancer, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(reprendreButton)))
												.addGap(18)
												.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
												.addGap(62)))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(entreesComboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup()
												.addComponent(btnNouveau)
												.addGap(18)
												.addComponent(ajouterDemandeButton)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(sortiesCombox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3)
										.addComponent(modifierDemandeButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addComponent(supprimerDemandeButton)
								.addGap(36)
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addGap(50)
												.addComponent(vTotal, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(vLibre, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(button_1))
										.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnLancer)
														.addComponent(reprendreButton))
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(Alignment.TRAILING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(arreterButton)
																.addGap(30))
														.addGroup(layout.createSequentialGroup()
																.addComponent(pauseButton)
																.addGap(22))))
										.addGroup(layout.createSequentialGroup()
												.addComponent(editorPane, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
												.addContainerGap())))
		);
		this.setLayout(layout);
	}

	private void buildTableDemandes() {
		final String[] entetes = {"NOM", "ENTREE", "SORTIE"};
		tableDemandesModel = new DefaultTableModel(entetes, 0);

		tableDemandes.setModel(tableDemandesModel);
		for (final Demande demande : demandes) {
			tableDemandesModel.addRow(new Object[]{demande.getNom(), demande.getE().getLibEntree(), demande.getS().getLibSortie()});
		}
	}

	private void ajouterDemandeHandler(ActionEvent actionEvent) {
		if (entreesComboBox.getSelectedIndex() == -1 || sortiesCombox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Veuillez renseigner tous les parametres");
		} else {
			synchronized (demandes) {
				demandes.add(new Demande(nom.getText(), (Entree) entreesComboBox.getItemAt(entreesComboBox.getSelectedIndex()), (Sortie) sortiesCombox.getItemAt(sortiesCombox.getSelectedIndex()), false));
				this.viderChamp();
				this.buildTableDemandes();
			}
		}
	}

	public void modifierDemandeHandler(ActionEvent actionEvent) {
		final int selectedRowIndex = tableDemandes.getSelectedRow();

		if (selectedRowIndex == -1) {
			JOptionPane.showMessageDialog(this, "Veuillez selectionner une ligne");
		} else {
			demandes.get(selectedRowIndex).setE(entreesComboBox.getItemAt(entreesComboBox.getSelectedIndex()));
			demandes.get(selectedRowIndex).setS(sortiesCombox.getItemAt(sortiesCombox.getSelectedIndex()));
			demandes.get(selectedRowIndex).setNom(nom.getText());
			this.viderChamp();
			this.buildTableDemandes();
		}
	}

	public void supprimerDemndeHandler(ActionEvent actionEvent) {
		if (tableDemandes.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Veuillez selectionner une ligne");
		} else {
			demandes.remove(tableDemandes.getSelectedRow());
			viderChamp();
			buildTableDemandes();
		}
	}

	public void viderChamp() {
		entreesComboBox.setSelectedIndex(-1);
		sortiesCombox.setSelectedIndex(-1);
		nom.setText(null);
	}

	private void tableDemandesMousePressed(java.awt.event.MouseEvent event) {
		nom.setText(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 0).toString());

		for (int i = 0; i < entreesComboBox.getItemCount(); i++) {
			entreeSelectionnee = (Entree) entreesComboBox.getItemAt(i);
			if (entreeSelectionnee.getLibEntree().equals(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 1).toString())) {
				entreesComboBox.setSelectedIndex(i);
			}
		}

		for (int i = 0; i < sortiesCombox.getItemCount(); i++) {
			sortieSelectionnee = (Sortie) sortiesCombox.getItemAt(i);
			if (sortieSelectionnee.getLibSortie().equals(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 2).toString())) {
				sortiesCombox.setSelectedIndex(i);
			}
		}
	}

	private Icon iconOf(final String iconName) {
		try {
			return new ImageIcon(Paths.get(getClass().getResource("/" + iconName).toURI()).toString());
		} catch (URISyntaxException exception) {
			return null;
		}

	}

	private JButton ajouterDemandeButton;

	private JButton modifierDemandeButton;

	private JButton supprimerDemandeButton;

	private JComboBox<Entree> entreesComboBox = new JComboBox<>();

	private JComboBox<Sortie> sortiesCombox = new JComboBox<>();

	private JLabel jLabel1;

	private JLabel jLabel2;

	private JLabel jLabel3;

	private JScrollPane jScrollPane2;

	private JTable tableDemandes;

	private JTextField nom;

	public static final List<Demande> demandes = new ArrayList<>();

	DefaultTableModel tableDemandesModel = new DefaultTableModel();

	Entree entreeSelectionnee = new Entree();

	Sortie sortieSelectionnee = new Sortie();

	private JButton pauseButton;

	private JButton reprendreButton;

	private JButton arreterButton;

	public static JLabel vTotal;

	public static JLabel vLibre;

	private final Controlleur controlleur = new Controlleur();
}
