package model;

import java.awt.Color;

public class Human extends Field {
	private Color color = Color.ORANGE;

	public Human(int pointX, int pointY) {
		super(pointX, pointY);
	}

	public void changePoints(int x, int y) {
		pointX += x;
		pointY += y;
	}

	public Color getColor() {
		return color;
	}
}
