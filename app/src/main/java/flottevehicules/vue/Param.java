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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Param extends javax.swing.JPanel {

	public Param() {
		initComponents();
		entree.setModel(Combo.initEntreesCombo());
		sortie.setModel(Combo.initSortiesCombo());
		this.viderChamp();
	}

	private void initComponents() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		entree = new JComboBox<>();
		sortie = new JComboBox<>();
		jScrollPane2 = new JScrollPane();

		tableDemandes = new javax.swing.JTable() {
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};

		ajouterDemandeButton = new JButton("Ajouter", iconOf("add.png"));
		ajouterDemandeButton.addActionListener(actionEvent -> {
			if (entree.getSelectedIndex() == -1 || sortie.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(this, "Veuillez renseigner tous les parametres");
			} else {
				synchronized (demandes) {
					demandes.add(new Demande(nom.getText(), (Entree) entree.getItemAt(entree.getSelectedIndex()), (Sortie) sortie.getItemAt(sortie.getSelectedIndex()), false));
					viderChamp();
				}
			}
		});

		modifierDemandeButton = new javax.swing.JButton();
		modifierDemandeButton.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/application_edit.png"));
		jButton3 = new javax.swing.JButton();
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableDemandes.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Veuillez selectionner une ligne");
				} else {
					demandes.remove(tableDemandes.getSelectedRow());
					viderChamp();
				}
			}
		});
		jButton3.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/delete.png"));


		jLabel1.setText("Nom");

		jLabel2.setText("Entree");

		jLabel3.setText("Sortie");

		entree.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

		sortie.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

		tableDemandes.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][]{
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null}
				},
				new String[]{
						"Title 1", "Title 2", "Title 3", "Title 4"
				}
		));
		jScrollPane2.setViewportView(tableDemandes);

		//  jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flotte/vue/application_edit.png"))); // NOI18N
		modifierDemandeButton.setText("Modifier");
		modifierDemandeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (tableDemandes.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Veuillez selectionner une ligne");
				} else {

					demandes.get(tableDemandes.getSelectedRow()).setE((Entree) entree.getItemAt(entree.getSelectedIndex()));
					demandes.get(tableDemandes.getSelectedRow()).setS((Sortie) sortie.getItemAt(sortie.getSelectedIndex()));
					demandes.get(tableDemandes.getSelectedRow()).setNom(nom.getText());
					viderChamp();
				}
			}
		});

		//jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flotte/vue/delete.png"))); // NOI18N
		jButton3.setText("Supprimer");

		nom = new JTextField();
		nom.setColumns(10);

		tableDemandes.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableDemandesMouseClicked(evt);
			}

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
														.addComponent(entree, 0, 186, Short.MAX_VALUE)
														.addComponent(nom, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
														.addComponent(sortie, Alignment.TRAILING, 0, 186, Short.MAX_VALUE))
												.addGap(56)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(modifierDemandeButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
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
														.addComponent(entree, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup()
												.addComponent(btnNouveau)
												.addGap(18)
												.addComponent(ajouterDemandeButton)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(sortie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3)
										.addComponent(modifierDemandeButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addComponent(jButton3)
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


	public void viderChamp() {

		entree.setSelectedIndex(-1);
		sortie.setSelectedIndex(-1);
		nom.setText(null);
		model = new DefaultTableModel();
		Object entete[] = {"NOM", "ENTREE", "SORTIE"};
		model.addColumn("NOM");
		model.addColumn("ENTREE");
		model.addColumn("SORTIE");
		//demandes = new ArrayList<Demande>();
		for (int i = 0; i < demandes.size(); i++) {
			model.addRow(new Object[]{demandes.get(i).getNom(), demandes.get(i).getE().getLibEntree(), demandes.get(i).getS().getLibSortie()});
		}
		tableDemandes.setModel(model);

	}

	private void tableDemandesMouseClicked(java.awt.event.MouseEvent evt) {

	}

	private void tableDemandesMousePressed(java.awt.event.MouseEvent evt) {
		nom.setText(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 0).toString());
		for (int i = 0; i < entree.getItemCount(); i++) {
			selectedE = (Entree) entree.getItemAt(i);
			if (selectedE.getLibEntree().equals(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 1).toString())) {
				entree.setSelectedIndex(i);
			}
		}

		for (int i = 0; i < sortie.getItemCount(); i++) {
			selectedS = (Sortie) sortie.getItemAt(i);
			if (selectedS.getLibSortie().equals(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 2).toString())) {
				sortie.setSelectedIndex(i);
			}
		}
	}

	private Icon iconOf(final String iconName) {
		return new ImageIcon(Paths.get("src", "resources", iconName).toString());
	}

	private JButton ajouterDemandeButton;

	private JButton modifierDemandeButton;

	private JButton jButton3;

	private JComboBox<Entree> entree = new JComboBox<>();

	private JComboBox<Sortie> sortie = new JComboBox<>();

	private JLabel jLabel1;

	private JLabel jLabel2;

	private JLabel jLabel3;

	private JScrollPane jScrollPane2;

	private JTable tableDemandes;

	private JTextField nom;

	public static List<Demande> demandes = new ArrayList<>();

	DefaultTableModel model = new DefaultTableModel();

	Entree selectedE = new Entree();

	Sortie selectedS = new Sortie();

	private JButton pauseButton;

	private JButton reprendreButton;

	private JButton arreterButton;

	public static JLabel vTotal;

	public static JLabel vLibre;

	private Controlleur controlleur = new Controlleur();
}
