package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WorldSecondLevel{
	private int rows = 16;
	private int columns = 20;
	private Field[][] fields = new Field[rows][columns];
	private Human prisoner;
	private Security firstSecurity;
	private Security secondSecurity;
	private Door firstDoor;
	private Door secondDoor;
	private Boolean prisonerWin = false;
	private Boolean prisonerLoose = false;

	public WorldSecondLevel() {

		System.out.println("I AM HERE");
		firstDoor = new Door(3, 0);
		secondDoor = new Door(4, 0);
		for (int indexR = 0; indexR < rows; indexR++) {
			for (int indexC = 0; indexC < columns; indexC++) {
				if (indexR == rows - 2 && indexC == columns - 1) {
					prisoner = new Human(indexR, indexC);
					fields[indexR][indexC] = prisoner;
				} else if (indexR == 3 && indexC == 0) {
					fields[indexR][indexC] = firstDoor;
				} else if (indexR == 4 && indexC == 0) {
					fields[indexR][indexC] = secondDoor;
				} else if (indexR == 0 && indexC == 2) {
					firstSecurity = new Security(indexR, indexC);
					fields[indexR][indexC] = firstSecurity;
				} else if (indexR == 2 && indexC == 2) {
					secondSecurity = new Security(indexR, indexC);
					fields[indexR][indexC] = secondSecurity;
				} else {
					fields[indexR][indexC] = new Field(indexR, indexC);
				}
			}
		}
	}

	public void moveSecurity() {
		int prisonerRow = prisoner.getRow();
		int prisonerCol = prisoner.getColumn();

		firstSecurity.move(prisonerRow, prisonerCol);
		secondSecurity.move(prisonerRow, prisonerCol);
	}

	public void update() {
		if (prisonerGetOut()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Congratulations!");

			alert.setHeaderText("Good job!");
			alert.setContentText("Let's start next level!");

			alert.showAndWait();
			prisonerWin = true;
		} else if (catchPrisoner()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Oops...");

			alert.setHeaderText("Game over");
			alert.setContentText("You loose :(");

			alert.showAndWait();

			prisonerLoose = true;
		} else if (!catchPrisoner()) {
			for (int indexR = 0; indexR < rows; indexR++) {
				for (int indexC = 0; indexC < columns; indexC++) {
					if (indexR == firstDoor.getRow() && indexC == firstDoor.getColumn()) {
						fields[indexR][indexC] = firstDoor;
					} else if (indexR == secondDoor.getRow() && indexC == secondDoor.getColumn()) {
						fields[indexR][indexC] = secondDoor;
					} else if (indexR == prisoner.getRow() && indexC == prisoner.getColumn()) {
						fields[indexR][indexC] = prisoner;
					} else if (indexR == firstSecurity.getRow() && indexC == firstSecurity.getColumn()) {
						fields[indexR][indexC] = firstSecurity;
					} else if (indexR == secondSecurity.getRow() && indexC == secondSecurity.getColumn()) {
						fields[indexR][indexC] = secondSecurity;
					} else if ((indexR == 3 || indexR == 4) && indexC == 0) {
						fields[indexR][indexC] = new Door(indexR, indexC);
					} else {
						fields[indexR][indexC] = new Field(indexR, indexC);
					}
				}
			}
		}

	}

	public boolean catchPrisoner() {
		if (prisoner.getRow() == firstSecurity.getRow() && prisoner.getColumn() == firstSecurity.getColumn()
				|| prisoner.getRow() == secondSecurity.getRow() && prisoner.getColumn() == secondSecurity.getColumn()) {
			return true;
		}
		return false;
	}

	public boolean prisonerGetOut() {
		boolean getOutFromFirstDoor = prisoner.getRow() == firstDoor.getRow()
				&& prisoner.getColumn() == firstDoor.getColumn();
		boolean getOutFromSecondDoor = prisoner.getRow() == secondDoor.getRow()
				&& prisoner.getColumn() == secondDoor.getColumn();

		if (getOutFromFirstDoor || getOutFromSecondDoor) {
			return true;
		}
		return false;
	}

	public boolean isPrisonerWin() {
		return prisonerWin;
	}

	public boolean isPrisonerLoose() {
		return prisonerLoose;
	}
	

	public Field getField(int x, int y) {
		return fields[x][y];
	}

	public boolean isFieldDoor(int x, int y) {
		return getField(x, y) instanceof Door;
	}

	public boolean isFieldSecurity(int x, int y) {
		return getField(x, y) instanceof Security;
	}

	public boolean isFieldHuman(int x, int y) {
		return getField(x, y) instanceof Human;
	}

	public void movePrisoner(int x, int y) {
			prisoner.changePoints(x, y);
	}
	
	public void checkLeft(int x, int y) {
		if (prisoner.getColumn() == 0) {
			prisoner.changePoints(0, 0);
		}
		else {
			movePrisoner(x,y);
		}
	}
	
	public void checkRight(int x, int y) {
		if (prisoner.getColumn() == columns - 1) {
			prisoner.changePoints(0, 0);
		} 		
		else {
			movePrisoner(x,y);
		}
	}
	
	public void checkTop(int x, int y) {
		if (prisoner.getRow() == 0) {
			prisoner.changePoints(0, 0);
		}
		else {
			movePrisoner(x,y);
		}
	}
	
	public void checkBottom(int x, int y) {
		if (prisoner.getRow() == rows - 1) {
			prisoner.changePoints(0, 0);
		} 		
		else {
			movePrisoner(x,y);
		}
	}

}
