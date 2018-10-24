package model;

import java.awt.Color;

public class Field {
	protected int pointX;
	protected int pointY;
	private Color color = Color.WHITE;

	public Field(int pointX, int pointY) {
		this.pointX = pointX;
		this.pointY = pointY;
	}

	public int getRow() {
		return pointX;
	}

	public int getColumn() {
		return pointY;
	}
	
	public Color getColor() {
		return color;
	}

}
