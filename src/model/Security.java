package model;

public class Security {
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

	public void hitSecurity(int x, int y) {
		if (!checkRow(field.pointX) || !checkCol(field.pointY)) {
			changePoints(x, y);
		}
	}

	public void move(int prisonerRow, int prisonerCol) {
		int securityRow = field.pointX;
		int securityCol = field.pointY;

		int distanceX = prisonerRow - securityRow;
		int distanceY = prisonerCol - securityCol;

		if (!checkRow(securityRow) || !checkCol(securityCol)) {
			if (distanceX >= 0 && distanceY > 0) {
				changePoints(0, 1);
			}

			else if (distanceX >= 0 && distanceY < 0) {
				changePoints(0, -1);
			}

			else if (distanceX < 0 && distanceY >= 0) {
				changePoints(-1, 0);
			}

			else if (distanceX > 0 && distanceY <= 0) {
				changePoints(1, 0);
			}
		}
	}

	public void loseAttention() {
		for (int index = 0; index < 5; index++) {
			if (!checkCol(field.pointY)) {
				changePoints(0, 1);
			}
		}
	}

	public boolean checkCol(int securityCol) {
		if (securityCol == 0) {
			changePoints(0, 1);
			return true;
		} else if (securityCol == 19) {
			changePoints(0, -1);
			return true;
		} else {
			return false;
		}
	}

	public boolean checkRow(int securityRow) {
		if (securityRow == 0) {
			changePoints(1, 0);
			return true;
		} else if (securityRow == 15) {
			changePoints(-1, 0);
			return true;
		}

		else {
			return false;
		}
	}
}
