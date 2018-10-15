package model;

public class Field {
	public int pointX;
	public int pointY;
	public boolean fieldFree = true;
	
	public Field(int pointX, int pointY)
	{
		this.pointX = pointX;
		this.pointY = pointY;
	}
	
	public boolean isFieldFree()
	{
		return fieldFree;
	}
	
	public void fieldBusy()
	{
		fieldFree = false;
	}
	
	public int getRow()
	{
		return pointX;
	}
	
	public int getColumn()
	{
		return pointY;
	}
	
	
}
