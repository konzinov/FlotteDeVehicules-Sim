package flotte.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import flotte.model.Vehicule;
import javax.swing.JButton;

public class Menu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Carte c = new Carte(1000,700);
	Param p = new Param();
	public Menu(){
		setSize(1280, 800);
		setResizable(false);
		
		
		c.setPreferredSize(new Dimension(1000,800));
		
		//p.setPreferredSize(new Dimension(1280-950,700));
		getContentPane().add(c, BorderLayout.LINE_START);
		getContentPane().add(p , BorderLayout.LINE_END);
		
		setVisible(true);
		
		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String argv[]){
		Menu fenetre= new Menu();
		
		
		
	}
}
