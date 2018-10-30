package model;

public class World {
	private int rows = 16;
	private int columns = 20;
	private Field[][] fields;
	private Human prisoner;
	private Security firstSecurity;
	private Security secondSecurity;
	private Security thirdSecurity;
	private Door firstDoor;
	private Door secondDoor;
	private Boolean prisonerWin = false;
	private Boolean prisonerLoose = false;
	private Boolean prisonerWinGame = false;
	private int level = 1;

	public World() {
		fields = new Field[rows][columns];
	}

	public void generateWorld() {
		prisonerWin = false;
		System.out.println("GENERATE");
		for (int indexR = 0; indexR < rows; indexR++) {
			for (int indexC = 0; indexC < columns; indexC++) {
				if (indexR == 3 && indexC == 0) {
					firstDoor = new Door(indexR, indexC);
				} else if (indexR == 4 && indexC == 0) {
					secondDoor = new Door(indexR, indexC);
				} else if (indexR == 3 && indexC == 2) {
					firstSecurity = new Security(indexR, indexC);
				} else if ((level == 2 || level == 3) && indexR == 8 && indexC == 2) {
					secondSecurity = new Security(indexR, indexC);
				} else if (level == 3 && indexR == 13 && indexC == 5) {
					thirdSecurity = new Security(indexR, indexC);
				} else if (indexR == rows - 2 && indexC == columns - 1) {
					prisoner = new Human(indexR, indexC);
				} else {
					fields[indexR][indexC] = new Field(indexR, indexC);
				}
			}
		}
	}

	public Field getField(int x, int y) {
		return fields[x][y];
	}

	public boolean isFieldDoor(int x, int y) {
		return (firstDoor.getField().pointX == x && firstDoor.getField().pointY == y)
				|| (secondDoor.getField().pointX == x && secondDoor.getField().pointY == y);
	}

	public boolean isFieldSecurity(int x, int y) {
		if (level == 1) {
			return (firstSecurity.getField().pointX == x && firstSecurity.getField().pointY == y);
		}
		if (level == 2) {
			return (firstSecurity.getField().pointX == x && firstSecurity.getField().pointY == y)
					|| (secondSecurity.getField().pointX == x && secondSecurity.getField().pointY == y);
		}
		if (level == 3) {
			return (firstSecurity.getField().pointX == x && firstSecurity.getField().pointY == y)
					|| (secondSecurity.getField().pointX == x && secondSecurity.getField().pointY == y)
					|| (thirdSecurity.getField().pointX == x && thirdSecurity.getField().pointY == y);
		}
		return false;
	}

	public boolean isFieldHuman(int x, int y) {
		return (prisoner.getField().pointX == x && prisoner.getField().pointY == y);
	}

	public void movePrisoner(int x, int y) {
		prisoner.changePoints(x, y);
	}

	public void checkLeft(int x, int y) {
		if (prisoner.getColumn() == 0) {
			prisoner.changePoints(0, 0);
		} else {
			movePrisoner(x, y);
		}
	}

	public void checkRight(int x, int y) {
		if (prisoner.getColumn() == columns - 1) {
			prisoner.changePoints(0, 0);
		} else {
			movePrisoner(x, y);
		}
	}

	public void checkTop(int x, int y) {
		if (prisoner.getRow() == 0) {
			prisoner.changePoints(0, 0);
		} else {
			movePrisoner(x, y);
		}
	}

	public void checkBottom(int x, int y) {
		if (prisoner.getRow() == rows - 1) {
			prisoner.changePoints(0, 0);
		} else {
			movePrisoner(x, y);
		}
	}

	public void checkLeftForJump(int x, int y) {
		if (prisoner.getColumn() == 0) {
			prisoner.changePoints(0, 0);
		} else if (prisoner.getColumn() == 1) {
			prisoner.changePoints(0, -1);
		} else {
			movePrisoner(x, y);
		}
	}

	public void checkRightForJump(int x, int y) {
		if (prisoner.getColumn() == columns - 1) {
			prisoner.changePoints(0, 0);
		} else if (prisoner.getColumn() == columns - 2) {
			prisoner.changePoints(0, 1);
		} else {
			movePrisoner(x, y);
		}
	}

	public void checkTopForJump(int x, int y) {
		if (prisoner.getRow() == 0) {
			prisoner.changePoints(0, 0);
		} else if (prisoner.getRow() == 1) {
			prisoner.changePoints(-1, 0);
		} else {
			movePrisoner(x, y);
		}
	}

	public void checkBottomForJump(int x, int y) {
		if (prisoner.getRow() == rows - 1) {
			prisoner.changePoints(0, 0);
		} else if (prisoner.getRow() == rows - 2) {
			prisoner.changePoints(1, 0);
		} else {
			movePrisoner(x, y);
		}
	}

	public void moveSecurity() {
		int prisonerRow = prisoner.getRow();
		int prisonerCol = prisoner.getColumn();

		firstSecurity.move(prisonerRow, prisonerCol);
		if (level == 2 || level == 3) {
			secondSecurity.move(prisonerRow, prisonerCol);
		}

		if (level == 3) {
			thirdSecurity.move(prisonerRow, prisonerCol);
		}
	}

	public void update() {
		if (prisonerGetOut() && level == 3) {
			prisonerWinGame = true;
		} else if (prisonerGetOut()) {
			prisonerWin = true;
			level++;
		} else if (catchPrisoner()) {
			prisonerLoose = true;
		} else if (!catchPrisoner()) {
			for (int indexR = 0; indexR < rows; indexR++) {
				for (int indexC = 0; indexC < columns; indexC++) {
					if (indexR == firstDoor.getRow() && indexC == firstDoor.getColumn()) {
						fields[indexR][indexC] = firstDoor.getField();
					} else if (indexR == secondDoor.getRow() && indexC == secondDoor.getColumn()) {
						fields[indexR][indexC] = secondDoor.getField();
					} else if (indexR == prisoner.getRow() && indexC == prisoner.getColumn()) {
						fields[indexR][indexC] = prisoner.getField();
					} else if (indexR == firstSecurity.getRow() && indexC == firstSecurity.getColumn()) {
						fields[indexR][indexC] = firstSecurity.getField();
					} else if ((level == 2 || level == 3) && indexR == secondSecurity.getRow()
							&& indexC == secondSecurity.getColumn()) {
						fields[indexR][indexC] = secondSecurity.getField();
					} else if (level == 3 && indexR == thirdSecurity.getRow() && indexC == thirdSecurity.getColumn()) {
						fields[indexR][indexC] = thirdSecurity.getField();
					} else {
						fields[indexR][indexC] = new Field(indexR, indexC);
					}

					if (level == 2 && indexR == secondSecurity.getRow() && indexC == secondSecurity.getColumn()) {
						fields[indexR][indexC] = secondSecurity.getField();
					}
				}
			}
		}
	}

	public boolean catchPrisoner() {
		boolean catchByFirstSecurity = prisoner.getRow() == firstSecurity.getRow()
				&& prisoner.getColumn() == firstSecurity.getColumn();
		boolean catchBySecondSecurity = false;
		boolean catchByThirdSecurity = false;
		if (level == 2 || level == 3) {
			catchBySecondSecurity = prisoner.getRow() == secondSecurity.getRow()
					&& prisoner.getColumn() == secondSecurity.getColumn();
		}

		if (level == 3) {
			catchByThirdSecurity = prisoner.getRow() == thirdSecurity.getRow()
					&& prisoner.getColumn() == thirdSecurity.getColumn();
		}
		return catchByFirstSecurity || catchBySecondSecurity || catchByThirdSecurity;
	}

	public boolean prisonerGetOut() {
		boolean getOutFromFirstDoor = prisoner.getRow() == firstDoor.getRow()
				&& prisoner.getColumn() == firstDoor.getColumn();
		boolean getOutFromSecondDoor = prisoner.getRow() == secondDoor.getRow()
				&& prisoner.getColumn() == secondDoor.getColumn();

		return getOutFromFirstDoor || getOutFromSecondDoor;
	}
	
	public void hitRLSecurity(int x, int y) {
		if (Math.abs(prisoner.getColumn() - firstSecurity.getColumn()) == 2 && prisoner.getRow() == firstSecurity.getRow()) {
			firstSecurity.hitSecurity(x,y);
		}
		
		if ((level == 2 || level == 3) && Math.abs(prisoner.getColumn() - secondSecurity.getColumn()) == 2 && prisoner.getRow() == secondSecurity.getRow()) {
			secondSecurity.hitSecurity(x,y);
		}
		
		if (level == 3 && Math.abs(prisoner.getColumn() - thirdSecurity.getColumn()) == 2  && prisoner.getRow() == thirdSecurity.getRow()) {
			thirdSecurity.hitSecurity(x,y);
		}
	}
	
	public void hitBTSecurity(int x, int y) {
		System.out.println(prisoner.getColumn() - firstSecurity.getColumn());
		if (Math.abs(prisoner.getRow() - firstSecurity.getRow()) == 2) {
			firstSecurity.hitSecurity(x,y);
		}
		
		if ((level == 2 || level == 3) && Math.abs(prisoner.getRow() - firstSecurity.getRow()) == 2) {
			secondSecurity.hitSecurity(x,y);
		}
		
		if (level == 3 && Math.abs(prisoner.getRow() - firstSecurity.getRow()) == 2) {
			thirdSecurity.hitSecurity(x,y);
		}
	}
	
	public void securityLoseAttention() {
		firstSecurity.loseAttention();
		
		if (level == 2 || level == 3) {
			secondSecurity.loseAttention();
		}
		
		if (level == 3) {
			thirdSecurity.loseAttention();
		}
	}

	public boolean isPrisonerWin() {
		return prisonerWin;
	}

	public boolean isPrisonerLoose() {
		return prisonerLoose;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Boolean prisonerWinGame() {
		return prisonerWinGame;
	}

	public int getLevel() {
		return level;
	}
}
