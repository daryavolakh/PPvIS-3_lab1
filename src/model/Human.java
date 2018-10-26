package model;

public class Human{	
	Field field;

	public Human(int pointX, int pointY) {
		field = new Field(pointX,pointY);
	}

	public void changePoints(int x, int y) {
		field.pointX += x;
		field.pointY += y;
//		pointX += x;
//		pointY += y;
	}
	
	public int getRow() {
		return field.pointX;
	}
	
	public int getColumn() {
		return field.pointY;
	}
	
	public Field getField() {
		return field;
	}
	
	
}
