package model;

public class Security{
	Field field;
	public Security(int pointX, int pointY) {
		field = new Field(pointX, pointY);
	}

	public void changePoints(int x, int y) {
		field.pointX += x;
		field.pointY += y;
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

	public void move(int prisonerRow, int prisonerCol) {
		int securityRow = field.pointX;
		int securityCol = field.pointY;

		int distanceX = prisonerRow - securityRow;
		int distanceY = prisonerCol - securityCol;

		if (securityCol == 0 || securityCol == 19) {
			changePoints(0, 1);
		} 
		else if (securityCol == 19) {
			changePoints(0, -1);
		}
		else if (securityRow == 0 ) {
			changePoints(1, 0);
		}		
		else if (securityRow == 15) {
			changePoints(-1, 0);
		}
		else {
			if (distanceX >= 0 && distanceY > 0) {
				changePoints(0, 1);
			}			
			
//			else if (distanceX >= 0 && distanceY < 0) {
//				changePoints(0,-1);
//			}
//	
//			else if (distanceX < 0 && distanceY >= 0) {
//				changePoints(-1,0);
//			}
//	
//			else if (distanceX > 0 && distanceY <= 0) {
//				changePoints(1, 0);
//			}
		}
	}


}
