package model;

public class Field {
	public int pointX;
	public int pointY;

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


}
