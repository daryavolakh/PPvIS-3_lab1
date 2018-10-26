package model;

public class Door{
	Field field;
	public Door(int pointX, int pointY) {
		field = new Field(pointX, pointY);
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
