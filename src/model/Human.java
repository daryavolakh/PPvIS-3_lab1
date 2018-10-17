package model;

public class Human extends Field {
	public Human(int pointX, int pointY) {
		super(pointX, pointY);
	}
	
	public void changePoints(int x, int y)
	{
		pointX += x;
		pointY += y;
	}
}
