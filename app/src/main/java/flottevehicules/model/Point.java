package flottevehicules.model;

import java.awt.geom.Point2D;

public class Point extends Point2D.Double {

	private static final long serialVersionUID = 1L;

	private String libPoint;


	public Point() {
		super();
	}

	public Point(String lib, double nX, double nY) {
		super(nX, nY);
		setLibPoint(lib);
	}

	public String getLibPoint() {
		return libPoint;
	}

	public void setLibPoint(String libPoint) {
		this.libPoint = libPoint;
	}

}
