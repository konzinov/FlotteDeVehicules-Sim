package flottevehicules.vue;

import flottevehicules.model.Anneau;
import flottevehicules.model.Entree;
import flottevehicules.model.Flotte;
import flottevehicules.model.Place;
import flottevehicules.model.Sortie;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Carte extends JPanel {
	/*Liste des entrees*/
	private Entree e1 = new Entree();

	private Entree e2 = new Entree();

	private Entree e3 = new Entree();

	private Entree e4 = new Entree();

	private Entree e5 = new Entree();

	private Entree e6 = new Entree();

	/*Liste des sorties*/
	private Sortie s1 = new Sortie();

	private Sortie s2 = new Sortie();

	private Sortie s3 = new Sortie();

	private Sortie s4 = new Sortie();

	private Sortie s5 = new Sortie();

	private Sortie s6 = new Sortie();

	/*Liste des anneaux*/
	private Anneau a0 = new Anneau();

	private Anneau a1 = new Anneau();

	private Anneau a2 = new Anneau();

	private Anneau a3 = new Anneau();

	private Anneau a4 = new Anneau();

	private Anneau a5 = new Anneau();

	private Anneau a6 = new Anneau();

	public static List<Ellipse2D.Double> voitures = new ArrayList<Ellipse2D.Double>();

	public List<Place> placesCarte = new ArrayList<Place>();

	public List<Entree> entrees = new ArrayList<>();

	public List<Sortie> sorties = new ArrayList<>();

	public List<Anneau> anneaux = new ArrayList<>();

	public Carte(int larg, int haut) {

		this.setPreferredSize(new Dimension(larg, haut));

		for (int i = 0; i < Flotte.getNb_vehicule_flotte(); i++) {
			voitures.add(new Ellipse2D.Double());
		}
		Point p1 = new Point((int) this.getPreferredSize().getWidth() / 3, (int) this.getPreferredSize().getWidth() / 8);

		a1.setLibAnneau("R1");
		a1.setLocalisation(new flottevehicules.model.Point("p1", p1.getX(), p1.getY()));
		;
		a1.setNumAnneau(1);
		a1.setNumPlace(1);
		int cx = (int) this.getPreferredSize().getWidth() / 3;

		int cy = (int) this.getPreferredSize().getHeight() / 2;


		a0.setLibAnneau("C");
		a0.setLocalisation(new flottevehicules.model.Point("C", cx, cy));
		a0.setNumAnneau(0);
		a0.setNumPlace(0);
		Point2D.Double p2 = new Point2D.Double((Math.cos(Math.PI / 3) * (p1.getX() - cx) - (Math.sin(Math.PI / 3) * (p1.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p1.getX() - cx) + (Math.cos(Math.PI / 3) * (p1.getY() - cy)) + cy);
		a2.setLibAnneau("R2");
		a2.setLocalisation(new flottevehicules.model.Point("p2", p2.getX(), p2.getY()));
		;
		a2.setNumAnneau(2);
		a2.setNumPlace(2);
		Point2D.Double p3 = new Point2D.Double((Math.cos(Math.PI / 3) * (p2.getX() - cx) - (Math.sin(Math.PI / 3) * (p2.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p2.getX() - cx) + (Math.cos(Math.PI / 3) * (p2.getY() - cy)) + cy);
		a3.setLibAnneau("R3");
		a3.setLocalisation(new flottevehicules.model.Point("p3", p3.getX(), p3.getY()));
		;
		a3.setNumAnneau(3);
		a3.setNumPlace(3);
		Point2D.Double p4 = new Point2D.Double((Math.cos(Math.PI / 3) * (p3.getX() - cx) - (Math.sin(Math.PI / 3) * (p3.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p3.getX() - cx) + (Math.cos(Math.PI / 3) * (p3.getY() - cy)) + cy);
		a4.setLibAnneau("R4");
		a4.setLocalisation(new flottevehicules.model.Point("p4", p4.getX(), p4.getY()));
		;
		a4.setNumAnneau(4);
		a4.setNumPlace(4);
		Point2D.Double p5 = new Point2D.Double((Math.cos(Math.PI / 3) * (p4.getX() - cx) - (Math.sin(Math.PI / 3) * (p4.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p4.getX() - cx) + (Math.cos(Math.PI / 3) * (p4.getY() - cy)) + cy);
		a5.setLibAnneau("R5");
		a5.setLocalisation(new flottevehicules.model.Point("p5", p5.getX(), p5.getY()));
		;
		a5.setNumAnneau(5);
		a5.setNumPlace(5);
		Point2D.Double p6 = new Point2D.Double((Math.cos(Math.PI / 3) * (p5.getX() - cx) - (Math.sin(Math.PI / 3) * (p5.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p5.getX() - cx) + (Math.cos(Math.PI / 3) * (p5.getY() - cy)) + cy);
		a6.setLibAnneau("R6");
		a6.setLocalisation(new flottevehicules.model.Point("p6", p6.getX(), p6.getY()));
		;
		a6.setNumAnneau(6);
		a6.setNumPlace(6);

		//Entree
		Ellipse2D i1 = new Ellipse2D.Double(p1.getX() - 20 - 40, p1.getY() - 20 - 35, 40, 40);
		e1.setLibEntree("I1");
		e1.setLocalisation(new flottevehicules.model.Point("p7", p1.getX() - 40, p1.getY() - 35));

		e1.setNumEntree(1);
		e1.setNumPlace(7);

		Ellipse2D i2 = new Ellipse2D.Double(p2.getX() - 20 + 10, p2.getY() - 20 - 50, 40, 40);
		e2.setLibEntree("I2");
		e2.setLocalisation(new flottevehicules.model.Point("p8", p2.getX() + 10, p2.getY() - 50));
		e2.setNumEntree(2);
		e2.setNumPlace(8);

		Ellipse2D i3 = new Ellipse2D.Double(p3.getX() - 20 + 45, p3.getY() - 20 - 30, 40, 40);
		e3.setLibEntree("I3");
		e3.setLocalisation(new flottevehicules.model.Point("p9", p3.getX() + 45, p3.getY() - 30));
		e3.setNumEntree(3);
		e3.setNumPlace(9);

		Ellipse2D i4 = new Ellipse2D.Double(p4.getX() - 20 - 40, p4.getY() - 20 + 35, 40, 40);
		e4.setLibEntree("I4");
		e4.setLocalisation(new flottevehicules.model.Point("p10", p4.getX() - 40, p4.getY() + 35));
		e4.setNumEntree(4);
		e4.setNumPlace(10);

		Ellipse2D i5 = new Ellipse2D.Double(p5.getX() - 20 - 45, p5.getY() - 20 - 30, 40, 40);
		e5.setLibEntree("I5");
		e5.setLocalisation(new flottevehicules.model.Point("p11", p5.getX() - 45, p5.getY() - 30));
		e5.setNumEntree(5);
		e5.setNumPlace(11);

		Ellipse2D i6 = new Ellipse2D.Double(p6.getX() - 20 - 10, p6.getY() - 20 - 50, 40, 40);
		e6.setLibEntree("I6");
		e6.setLocalisation(new flottevehicules.model.Point("p12", p6.getX() - 10, p6.getY() - 50));
		e6.setNumEntree(6);
		e6.setNumPlace(12);

		//Sortie

		Ellipse2D o1 = new Ellipse2D.Double(p1.getX() - 20 + 40, p1.getY() - 20 - 35, 40, 40);
		s1.setLibSortie("O1");
		s1.setLocalisation(new flottevehicules.model.Point("p13", p1.getX() + 40, p1.getY() - 35));
		s1.setNumPlace(13);
		s1.setNumSortie(1);

		Point2D.Double p25 = new Point2D.Double((Math.cos(Math.PI / 2) * (i2.getCenterX() - p2.getX()) - (Math.sin(Math.PI / 2) * (i2.getCenterY() - p2.getY()))) + p2.getX(), Math.sin(Math.PI / 2) * (i2.getCenterX() - p2.getX()) + (Math.cos(Math.PI / 2) * (i2.getCenterY() - p2.getY())) + p2.getY());
		Ellipse2D o2 = new Ellipse2D.Double(p25.getX() - 20, p25.getY() - 20, 40, 40);
		s2.setLibSortie("O2");
		s2.setLocalisation(new flottevehicules.model.Point("p14", p25.getX(), p25.getY()));
		s2.setNumPlace(14);
		s2.setNumSortie(2);

		Point2D.Double p26 = new Point2D.Double((Math.cos(Math.PI / 2) * (i3.getCenterX() - p3.getX()) - (Math.sin(Math.PI / 2) * (i3.getCenterY() - p3.getY()))) + p3.getX(), Math.sin(Math.PI / 2) * (i3.getCenterX() - p3.getX()) + (Math.cos(Math.PI / 2) * (i3.getCenterY() - p3.getY())) + p3.getY());
		Ellipse2D o3 = new Ellipse2D.Double(p26.getX() - 20, p26.getY() - 20, 40, 40);
		s3.setLibSortie("O3");
		s3.setLocalisation(new flottevehicules.model.Point("p15", p26.getX(), p26.getY()));
		s3.setNumPlace(15);
		s3.setNumSortie(3);

		Ellipse2D o4 = new Ellipse2D.Double(p4.getX() - 20 + 40, p4.getY() - 20 + 35, 40, 40);
		s4.setLibSortie("O4");
		s4.setLocalisation(new flottevehicules.model.Point("p16", p4.getX() + 40, p4.getY() + 35));
		s4.setNumPlace(16);
		s4.setNumSortie(4);

		Point2D.Double p27 = new Point2D.Double((Math.cos(Math.PI / 2) * (i5.getCenterX() - p5.getX()) - (Math.sin(-Math.PI / 2) * (i5.getCenterY() - p5.getY()))) + p5.getX(), Math.sin(-Math.PI / 2) * (i5.getCenterX() - p5.getX()) + (Math.cos(Math.PI / 2) * (i5.getCenterY() - p5.getY())) + p5.getY());
		Ellipse2D o5 = new Ellipse2D.Double(p27.getX() - 20, p27.getY() - 20, 40, 40);
		s5.setLibSortie("O5");
		s5.setLocalisation(new flottevehicules.model.Point("p17", p27.getX(), p27.getY()));
		s5.setNumPlace(17);
		s5.setNumSortie(5);

		Point2D.Double p28 = new Point2D.Double((Math.cos(Math.PI / 2) * (i6.getCenterX() - p6.getX()) - (Math.sin(-Math.PI / 2) * (i6.getCenterY() - p6.getY()))) + p6.getX(), Math.sin(-Math.PI / 2) * (i6.getCenterX() - p6.getX()) + (Math.cos(Math.PI / 2) * (i6.getCenterY() - p6.getY())) + p6.getY());
		Ellipse2D o6 = new Ellipse2D.Double(p28.getX() - 20, p28.getY() - 20, 40, 40);
		s6.setLibSortie("O6");
		s6.setLocalisation(new flottevehicules.model.Point("p18", p28.getX(), p28.getY()));
		s6.setNumPlace(18);
		s6.setNumSortie(6);

		//Construction des places
		anneaux.add(a0);
		anneaux.add(a1);
		anneaux.add(a2);
		anneaux.add(a3);
		anneaux.add(a4);
		anneaux.add(a5);
		anneaux.add(a6);
		entrees.add(e1);
		entrees.add(e2);
		entrees.add(e3);
		entrees.add(e4);
		entrees.add(e5);
		entrees.add(e6);
		sorties.add(s1);
		sorties.add(s2);
		sorties.add(s3);
		sorties.add(s4);
		sorties.add(s5);
		sorties.add(s6);

		placesCarte = Stream.of(anneaux, entrees, sorties).flatMap(List::stream).collect(Collectors.toList());
	}


	public void paintComponent(Graphics g) {
		Graphics2D G2d = (Graphics2D) g;
		int x1 = this.getWidth() / 4;
		int y1 = this.getHeight() / 4;
		final float dash1[] = {10.0f};
		final BasicStroke dashed =
				new BasicStroke(1.0f,
						BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_MITER,
						10.0f, dash1, 0.0f);

		G2d.setColor(Color.white);
		G2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		G2d.setColor(Color.black);
		Point p1 = new Point(this.getWidth() / 3, this.getWidth() / 8);

		int cx = this.getWidth() / 3;
		int cy = this.getHeight() / 2;

		Point2D.Double p2 = new Point2D.Double((Math.cos(Math.PI / 3) * (p1.getX() - cx) - (Math.sin(Math.PI / 3) * (p1.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p1.getX() - cx) + (Math.cos(Math.PI / 3) * (p1.getY() - cy)) + cy);
		Point2D.Double p3 = new Point2D.Double((Math.cos(Math.PI / 3) * (p2.getX() - cx) - (Math.sin(Math.PI / 3) * (p2.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p2.getX() - cx) + (Math.cos(Math.PI / 3) * (p2.getY() - cy)) + cy);
		Point2D.Double p4 = new Point2D.Double((Math.cos(Math.PI / 3) * (p3.getX() - cx) - (Math.sin(Math.PI / 3) * (p3.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p3.getX() - cx) + (Math.cos(Math.PI / 3) * (p3.getY() - cy)) + cy);
		Point2D.Double p5 = new Point2D.Double((Math.cos(Math.PI / 3) * (p4.getX() - cx) - (Math.sin(Math.PI / 3) * (p4.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p4.getX() - cx) + (Math.cos(Math.PI / 3) * (p4.getY() - cy)) + cy);
		Point2D.Double p6 = new Point2D.Double((Math.cos(Math.PI / 3) * (p5.getX() - cx) - (Math.sin(Math.PI / 3) * (p5.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p5.getX() - cx) + (Math.cos(Math.PI / 3) * (p5.getY() - cy)) + cy);
		int[] x = {(int) p1.getX(), (int) p2.getX(), (int) p3.getX(), (int) p4.getX(), (int) p5.getX(), (int) p6.getX()};
		int[] y = {(int) p1.getY(), (int) p2.getY(), (int) p3.getY(), (int) p4.getY(), (int) p5.getY(), (int) p6.getY()};
		Polygon p = new Polygon(x, y, x.length);
		//Premier triangle
		Point2D.Double p7 = new Point2D.Double(cx - 22, cy - 38);
		Point2D.Double p8 = new Point2D.Double(p1.getX() - 22, p1.getY() + 35);
		Point2D.Double p9 = new Point2D.Double(p6.getX() + 40, p6.getY());
		int[] t1 = {(int) p7.getX(), (int) p8.getX(), (int) p9.getX()};
		int[] t2 = {(int) p7.getY(), (int) p8.getY(), (int) p9.getY()};
		Polygon t = new Polygon(t1, t2, t1.length);
		G2d.drawPolygon(t);
		// second triangle
		Point2D.Double p10 = new Point2D.Double((Math.cos(Math.PI / 3) * (p7.getX() - cx - 2) - (Math.sin(Math.PI / 3) * (p7.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p7.getX() - cx) + (Math.cos(Math.PI / 3) * (p7.getY() - cy)) + cy);
		Point2D.Double p11 = new Point2D.Double((Math.cos(Math.PI / 3) * (p8.getX() - cx) - (Math.sin(Math.PI / 3) * (p8.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p8.getX() - cx) + (Math.cos(Math.PI / 3) * (p8.getY() - cy)) + cy);
		Point2D.Double p12 = new Point2D.Double((Math.cos(Math.PI / 3) * (p9.getX() - cx) - (Math.sin(Math.PI / 3) * (p9.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p9.getX() - cx) + (Math.cos(Math.PI / 3) * (p9.getY() - cy)) + cy);
		int[] t3 = {(int) p10.getX(), (int) p11.getX(), (int) p12.getX()};
		int[] t4 = {(int) p10.getY(), (int) p11.getY(), (int) p12.getY()};
		Polygon tr1 = new Polygon(t3, t4, t3.length);
		G2d.drawPolygon(tr1);
		//troisième triangle
		Point2D.Double p13 = new Point2D.Double((Math.cos(Math.PI / 3) * (p10.getX() - cx - 2) - (Math.sin(Math.PI / 3) * (p10.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p10.getX() - cx) + (Math.cos(Math.PI / 3) * (p10.getY() - cy)) + cy);
		Point2D.Double p14 = new Point2D.Double((Math.cos(Math.PI / 3) * (p11.getX() - cx) - (Math.sin(Math.PI / 3) * (p11.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p11.getX() - cx) + (Math.cos(Math.PI / 3) * (p11.getY() - cy)) + cy);
		Point2D.Double p15 = new Point2D.Double((Math.cos(Math.PI / 3) * (p12.getX() - cx) - (Math.sin(Math.PI / 3) * (p12.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p12.getX() - cx) + (Math.cos(Math.PI / 3) * (p12.getY() - cy)) + cy);
		int[] t5 = {(int) p13.getX(), (int) p14.getX(), (int) p15.getX()};
		int[] t6 = {(int) p13.getY(), (int) p14.getY(), (int) p15.getY()};
		Polygon tr2 = new Polygon(t5, t6, t5.length);
		G2d.drawPolygon(tr2);
		// Quatrième triangle 
		Point2D.Double p16 = new Point2D.Double((Math.cos(Math.PI / 3) * (p13.getX() - cx) - (Math.sin(Math.PI / 3) * (p13.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p13.getX() - cx) + (Math.cos(Math.PI / 3) * (p13.getY() - cy)) + cy);
		Point2D.Double p17 = new Point2D.Double((Math.cos(Math.PI / 3) * (p14.getX() - cx) - (Math.sin(Math.PI / 3) * (p14.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p14.getX() - cx) + (Math.cos(Math.PI / 3) * (p14.getY() - cy)) + cy);
		Point2D.Double p18 = new Point2D.Double((Math.cos(Math.PI / 3) * (p15.getX() - cx) - (Math.sin(Math.PI / 3) * (p15.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p15.getX() - cx) + (Math.cos(Math.PI / 3) * (p15.getY() - cy)) + cy);
		int[] t7 = {(int) p16.getX(), (int) p17.getX(), (int) p18.getX()};
		int[] t8 = {(int) p16.getY(), (int) p17.getY(), (int) p18.getY()};
		Polygon tr3 = new Polygon(t7, t8, t7.length);
		G2d.drawPolygon(tr3);
		// Cinquième triangle
		Point2D.Double p19 = new Point2D.Double((Math.cos(Math.PI / 3) * (p16.getX() - cx) - (Math.sin(Math.PI / 3) * (p16.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p16.getX() - cx) + (Math.cos(Math.PI / 3) * (p16.getY() - cy)) + cy);
		Point2D.Double p20 = new Point2D.Double((Math.cos(Math.PI / 3) * (p17.getX() - cx) - (Math.sin(Math.PI / 3) * (p17.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p17.getX() - cx) + (Math.cos(Math.PI / 3) * (p17.getY() - cy)) + cy);
		Point2D.Double p21 = new Point2D.Double((Math.cos(Math.PI / 3) * (p18.getX() - cx - 2) - (Math.sin(Math.PI / 3) * (p18.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p18.getX() - cx) + (Math.cos(Math.PI / 3) * (p18.getY() - cy)) + cy);
		int[] t9 = {(int) p19.getX(), (int) p20.getX(), (int) p21.getX()};
		int[] t10 = {(int) p19.getY(), (int) p20.getY(), (int) p21.getY()};
		Polygon tr4 = new Polygon(t9, t10, t9.length);
		G2d.drawPolygon(tr4);
		// Sixième triangle
		Point2D.Double p22 = new Point2D.Double((Math.cos(Math.PI / 3) * (p19.getX() - cx) - (Math.sin(Math.PI / 3) * (p19.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p19.getX() - cx) + (Math.cos(Math.PI / 3) * (p19.getY() - cy)) + cy);
		Point2D.Double p23 = new Point2D.Double((Math.cos(Math.PI / 3) * (p20.getX() - cx) - (Math.sin(Math.PI / 3) * (p20.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p20.getX() - cx) + (Math.cos(Math.PI / 3) * (p20.getY() - cy)) + cy);
		Point2D.Double p24 = new Point2D.Double((Math.cos(Math.PI / 3) * (p21.getX() - cx - 2) - (Math.sin(Math.PI / 3) * (p21.getY() - cy))) + cx, Math.sin(Math.PI / 3) * (p21.getX() - cx) + (Math.cos(Math.PI / 3) * (p21.getY() - cy)) + cy);
		int[] t11 = {(int) p22.getX(), (int) p23.getX(), (int) p24.getX()};
		int[] t12 = {(int) p22.getY(), (int) p23.getY(), (int) p24.getY()};
		Polygon tr5 = new Polygon(t11, t12, t11.length);
		G2d.drawPolygon(tr5);
		// création d'anneau ******************************************//
		Ellipse2D a = new Ellipse2D.Double(cx - 20, cy - 20, 40, 40);
		G2d.draw(a);
		Ellipse2D a1 = new Ellipse2D.Double(p1.getX() - 20, p1.getY() - 20, 40, 40);
		G2d.draw(a1);
		Ellipse2D a2 = new Ellipse2D.Double(p2.getX() - 20, p2.getY() - 20, 40, 40);
		G2d.draw(a2);
		Ellipse2D a3 = new Ellipse2D.Double(p3.getX() - 20, p3.getY() - 20, 40, 40);
		G2d.draw(a3);
		Ellipse2D a4 = new Ellipse2D.Double(p4.getX() - 20, p4.getY() - 20, 40, 40);
		G2d.draw(a4);
		Ellipse2D a5 = new Ellipse2D.Double(p5.getX() - 20, p5.getY() - 20, 40, 40);
		G2d.draw(a5);
		Ellipse2D a6 = new Ellipse2D.Double(p6.getX() - 20, p6.getY() - 20, 40, 40);
		G2d.draw(a6);
		// création d'entrée ******************************************//
		Ellipse2D i1 = new Ellipse2D.Double(p1.getX() - 20 - 40, p1.getY() - 20 - 35, 40, 40);
		double xxx = p1.getX() - 40;

		G2d.draw(i1);
		Ellipse2D i2 = new Ellipse2D.Double(p2.getX() - 20 + 10, p2.getY() - 20 - 50, 40, 40);
		G2d.draw(i2);
		Ellipse2D i3 = new Ellipse2D.Double(p3.getX() - 20 + 45, p3.getY() - 20 - 30, 40, 40);
		G2d.draw(i3);
		Ellipse2D i4 = new Ellipse2D.Double(p4.getX() - 20 - 40, p4.getY() - 20 + 35, 40, 40);
		G2d.draw(i4);
		Ellipse2D i5 = new Ellipse2D.Double(p5.getX() - 20 - 45, p5.getY() - 20 - 30, 40, 40);
		G2d.draw(i5);
		Ellipse2D i6 = new Ellipse2D.Double(p6.getX() - 20 - 10, p6.getY() - 20 - 50, 40, 40);
		G2d.draw(i6);

		// création de sortie ******************************************//
		Ellipse2D o1 = new Ellipse2D.Double(p1.getX() - 20 + 40, p1.getY() - 20 - 35, 40, 40);
		G2d.draw(o1);
		Point2D.Double p25 = new Point2D.Double((Math.cos(Math.PI / 2) * (i2.getCenterX() - p2.getX()) - (Math.sin(Math.PI / 2) * (i2.getCenterY() - p2.getY()))) + p2.getX(), Math.sin(Math.PI / 2) * (i2.getCenterX() - p2.getX()) + (Math.cos(Math.PI / 2) * (i2.getCenterY() - p2.getY())) + p2.getY());
		Ellipse2D o2 = new Ellipse2D.Double(p25.getX() - 20, p25.getY() - 20, 40, 40);
		G2d.draw(o2);
		Point2D.Double p26 = new Point2D.Double((Math.cos(Math.PI / 2) * (i3.getCenterX() - p3.getX()) - (Math.sin(Math.PI / 2) * (i3.getCenterY() - p3.getY()))) + p3.getX(), Math.sin(Math.PI / 2) * (i3.getCenterX() - p3.getX()) + (Math.cos(Math.PI / 2) * (i3.getCenterY() - p3.getY())) + p3.getY());
		Ellipse2D o3 = new Ellipse2D.Double(p26.getX() - 20, p26.getY() - 20, 40, 40);
		G2d.draw(o3);
		Ellipse2D o4 = new Ellipse2D.Double(p4.getX() - 20 + 40, p4.getY() - 20 + 35, 40, 40);
		G2d.draw(o4);
		Point2D.Double p27 = new Point2D.Double((Math.cos(Math.PI / 2) * (i5.getCenterX() - p5.getX()) - (Math.sin(-Math.PI / 2) * (i5.getCenterY() - p5.getY()))) + p5.getX(), Math.sin(-Math.PI / 2) * (i5.getCenterX() - p5.getX()) + (Math.cos(Math.PI / 2) * (i5.getCenterY() - p5.getY())) + p5.getY());
		Ellipse2D o5 = new Ellipse2D.Double(p27.getX() - 20, p27.getY() - 20, 40, 40);
		G2d.draw(o5);
		Point2D.Double p28 = new Point2D.Double((Math.cos(Math.PI / 2) * (i6.getCenterX() - p6.getX()) - (Math.sin(-Math.PI / 2) * (i6.getCenterY() - p6.getY()))) + p6.getX(), Math.sin(-Math.PI / 2) * (i6.getCenterX() - p6.getX()) + (Math.cos(Math.PI / 2) * (i6.getCenterY() - p6.getY())) + p6.getY());
		Ellipse2D o6 = new Ellipse2D.Double(p28.getX() - 20, p28.getY() - 20, 40, 40);
		G2d.draw(o6);

		G2d.setStroke(dashed);
		G2d.drawPolygon(p);
		G2d.drawLine((int) p2.getX(), (int) p2.getY(), (int) p5.getX(), (int) p5.getY());
		G2d.drawLine((int) p6.getX(), (int) p6.getY(), (int) p3.getX(), (int) p3.getY());
		G2d.drawLine((int) p1.getX(), (int) p1.getY(), (int) p4.getX(), (int) p4.getY());

		for (Ellipse2D.Double e : voitures) {
			G2d.setColor(Color.blue);
			G2d.fillOval((int) e.getX(), (int) e.getY(), 20, 20);
			G2d.draw(e);


		}
	}

	public Anneau getA0() {
		return a0;
	}
}