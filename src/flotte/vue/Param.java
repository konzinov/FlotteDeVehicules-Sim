package flotte.vue;

import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import flotte.model.Boite;
import flotte.model.Controlleur;
import flotte.model.Demande;
import flotte.model.Entree;
import flotte.model.Flotte;
import flotte.model.Sortie;
import flotte.model.Vehicule;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JEditorPane;


public class Param extends javax.swing.JPanel {

    /**
     * Creates new form Param
     */
	
    public Param() {
    	
        initComponents();
        entree.setModel(Combo.getComboEntree());
        sortie.setModel(Combo.getComboSortie());
       this.viderChamp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        entree = new javax.swing.JComboBox();
        sortie = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        tableDemandes = new javax.swing.JTable(){
        	@Override
        	public boolean isCellEditable(int arg0,int arg1){
        		return false;
        	}
        };
       
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(entree.getSelectedIndex()==-1||sortie.getSelectedIndex()==-1){
        		 JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les parametres");	
        		}
        		else{
        			synchronized (demandes) {
						
					
        		demandes.add(new Demande(nom.getText(),(Entree)entree.getItemAt(entree.getSelectedIndex()),(Sortie)sortie.getItemAt(sortie.getSelectedIndex()),false));
        		viderChamp();
        			}
        		}
        	}
        });
        
        
        jButton1.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/add.png"));
        jButton2 = new javax.swing.JButton();
        jButton2.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/application_edit.png"));
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(tableDemandes.getSelectedRow()==-1){
        			JOptionPane.showMessageDialog(null, "Veuillez selectionner une ligne");
        		}
        		else{
        			demandes.remove(tableDemandes.getSelectedRow());
        			viderChamp();
        		}
        	}
        });
        jButton3.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/delete.png"));

       

        jLabel1.setText("Nom");

        jLabel2.setText("Entree");

        jLabel3.setText("Sortie");

        entree.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        sortie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tableDemandes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableDemandes);

       // jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flotte/vue/add.png"))); // NOI18N
        jButton1.setText("Ajouter");

      //  jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flotte/vue/application_edit.png"))); // NOI18N
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               if(tableDemandes.getSelectedRow()==-1){
            	   JOptionPane.showMessageDialog(null, "Veuillez selectionner une ligne");
               }
               else{
            	   
            	demandes.get(tableDemandes.getSelectedRow()).setE((Entree)entree.getItemAt(entree.getSelectedIndex()));
            	demandes.get(tableDemandes.getSelectedRow()).setS((Sortie)sortie.getItemAt(sortie.getSelectedIndex()));
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
        		/*Vehicule v = new Vehicule();
        		Vehicule v2 = new Vehicule();
        		Vehicule v3 = new Vehicule();
        		Vehicule v4 = new Vehicule();
        		Vehicule v5 = new Vehicule();
        		v2.setNumVehicule(2);
        		v.setNumVehicule(1);
        		v3.setNumVehicule(3);
        		v4.setNumVehicule(4);
        		v5.setNumVehicule(5);
        		v.calculerCourtChemin(Combo.clo.e6, Combo.clo.s2);
        		v2.calculerCourtChemin(Combo.clo.e5, Combo.clo.s3);
        		v3.calculerCourtChemin(Combo.clo.e6, Combo.clo.s2);
        		v4.calculerCourtChemin(Combo.clo.e4, Combo.clo.s1);
        		v5.calculerCourtChemin(Combo.clo.e2, Combo.clo.s6);
        		v.start();
        		v2.start();
        		/*v3.start();
        		v4.start();
        		v5.start();*/
        		controll.start();
        	}
        });
        
        btnPause = new JButton("Pause");
        btnPause.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controll.pauser();
        	}
        });
        btnPause.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/disconnect.png"));
        
        btnReprendre = new JButton("Reprendre");
        btnReprendre.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controll.reprendre();
        	}
        });
        
        btnNewButton = new JButton("Arreter");
        btnNewButton.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/circle_red.png"));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controll.arreter();
        	}
        });
        
         vTotal = new JLabel("Vehicules : "+Flotte.getNb_vehicule_flotte());
        
         vLibre = new JLabel("Libre : "+Flotte.getNb_vehicule_dispo());
        
        JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Flotte.Ajouter_vehicule();
        		Boite.signaleurs =  new boolean[Flotte.getNb_vehicule_flotte()];
        		vTotal.setText("Vehicules : "+Flotte.getNb_vehicule_flotte());
        		vLibre.setText("Libre : "+Flotte.getNb_vehicule_dispo());
        		
        	}
        });
        button.setIcon(new ImageIcon("/home/emmanuel/workspace/FlotteDeVehicules/add.png"));
        
        JButton button_1 = new JButton("");
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Flotte.Retirer_vehicule();
        		vTotal.setText("Vehicules : "+Flotte.getNb_vehicule_flotte());
        		vLibre.setText("Libre : "+Flotte.getNb_vehicule_dispo());
        		
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
        						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
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
        							.addComponent(btnPause, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
        							.addGap(31)
        							.addComponent(btnNewButton))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btnLancer, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(btnReprendre)))
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
        					.addComponent(jButton1)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(sortie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3)
        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
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
        						.addComponent(btnReprendre))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btnNewButton)
        							.addGap(30))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btnPause)
        							.addGap(22))))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(editorPane, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    
    public void viderChamp(){
    	
    	entree.setSelectedIndex(-1);
    	sortie.setSelectedIndex(-1);
    	nom.setText(null);
    	model = new DefaultTableModel();
    	Object entete[] = {"NOM","ENTREE","SORTIE"};
    	model.addColumn("NOM");
    	model.addColumn("ENTREE");
    	model.addColumn("SORTIE");
    	//demandes = new ArrayList<Demande>();
    	for(int i=0;i<demandes.size();i++){
    		model.addRow(new Object[]{demandes.get(i).getNom(),demandes.get(i).getE().getLibEntree(),demandes.get(i).getS().getLibSortie()});
    	}
    	tableDemandes.setModel(model);
    	 
    }
    
    private void tableDemandesMouseClicked(java.awt.event.MouseEvent evt){
    	
    }
    
    private void tableDemandesMousePressed(java.awt.event.MouseEvent evt){
    	nom.setText(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 0).toString());
    	for(int i=0;i<entree.getItemCount();i++){
    		selectedE = (Entree) entree.getItemAt(i);
    		if(selectedE.getLibEntree().equals(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 1).toString())){
    			entree.setSelectedIndex(i);
    		}
    	}
    	
    	for(int i=0;i<sortie.getItemCount();i++){
    		selectedS = (Sortie) sortie.getItemAt(i);
    		if(selectedS.getLibSortie().equals(tableDemandes.getValueAt(tableDemandes.getSelectedRow(), 2).toString())){
    			sortie.setSelectedIndex(i);
    		}
    	}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox entree = new JComboBox();
    private javax.swing.JComboBox sortie = new JComboBox();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableDemandes;
    private JTextField nom;
    public  static List<Demande> demandes = new ArrayList<Demande>();
    DefaultTableModel model =new DefaultTableModel();
    Entree selectedE = new Entree();
    Sortie selectedS = new Sortie();
    private JButton btnPause;
    private JButton btnReprendre;
    private JButton btnNewButton;
    public static JLabel vTotal;
    public static JLabel vLibre; 
    private Controlleur controll = new Controlleur();
}
