package model;

public class World {
	Field[][] fields;
	int rows = 8;
	int columns = 12;
	
	public World()
	{
		fields  = new Field[rows][columns];
		for (int indexR = 0; indexR < rows; indexR++)
			for (int indexC = 0; indexC < columns; indexC++)
			{				
				if ((indexR == 3 || indexR == 4) && indexC == 0)
					fields[indexR][indexC] = new Door(indexR + 1,indexC + 1);
				
				else if (indexR == 3 && indexC == 2)
					fields[indexR][indexC] = new Security(indexR + 1,indexC + 1);
				
				else if (indexR == rows - 2 && indexC == columns - 1)
					fields[indexR][indexC] = new Human(indexR + 1,indexC + 1);
				else 
					fields[indexR][indexC] = null;
			}			
	}
	
	public Field getField(int x, int y)
	{
		return fields[x - 1][y - 1];
	}
	
	public boolean isFieldDoor(int x, int y)
	{
		if (fields[x - 1][y - 1] instanceof Door)
			return true;
		else
			return false;
	}
	
	public boolean isFieldSecurity(int x, int y)
	{
		if (fields[x - 1][y - 1] instanceof Security)
			return true;
		else
			return false;
	}
	
	public boolean isFieldHuman(int x, int y)
	{
		if (fields[x - 1][y - 1] instanceof Human)
			return true;
		else
			return false;
	}
}
