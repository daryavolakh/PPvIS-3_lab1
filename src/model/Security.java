package model;

public class Security extends Field {

	public Security(int pointX, int pointY) {
		super(pointX, pointY);
	}

	public void changePoints(int x, int y) {
		pointX += x;
		pointY += y;
	}

	public void move(int prisonerRow, int prisonerCol) {
		int securityRow = pointX;
		int securityCol = pointY;

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
			
			else if (distanceX >= 0 && distanceY < 0) {
				changePoints(0,-1);
			}
	
			else if (distanceX < 0 && distanceY >= 0) {
				changePoints(-1,0);
			}
	
			else if (distanceX > 0 && distanceY <= 0) {
				changePoints(1, 0);
			}
		}
	}


}
