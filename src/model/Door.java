package model;

import java.awt.Color;

public class Door extends Field {	
	private Color color = Color.YELLOW;

	public Door(int pointX, int pointY) {
		super(pointX, pointY);
	}
	
	public Color getColor() {
		return color;
	}

}
