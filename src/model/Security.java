package model;

public class Security extends Field {

	public Security(int pointX, int pointY) {
		super(pointX, pointY);
	}
	
	public void changePoints(int x, int y)
	{
		pointX += x;
		pointY += y;
	}

}
