package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class World {
	private int rows = 8;
	private int columns = 12;
	private Field[][] fields = new Field[rows][columns];
	private Human prisoner;
	private Security security;

	public World() {
		for (int indexR = 0; indexR < rows; indexR++) {
			for (int indexC = 0; indexC < columns; indexC++) {
				if ((indexR == 3 || indexR == 4) && indexC == 0) {
					fields[indexR][indexC] = new Door(indexR, indexC);
				} else if (indexR == 3 && indexC == 2) {
					security = new Security(indexR, indexC);
					fields[indexR][indexC] = security;
				} else if (indexR == rows - 2 && indexC == columns - 1) {
					prisoner = new Human(indexR, indexC);
					fields[indexR][indexC] = prisoner;
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

	public void moveSecurity() {
		int prisonerRow = prisoner.getRow();
		int prisonerCol = prisoner.getColumn();

		int securityRow = security.getRow();
		int securityCol = security.getColumn();

		if ((prisonerRow - securityRow) > 0 && (prisonerCol - securityCol) > 0) {
			security.changePoints(0, 1);
		}

		else if ((prisonerRow - securityRow) > 0 && (prisonerCol - securityCol) < 0) {
			security.changePoints(0, -1);
		}

		else if ((prisonerRow - securityRow) < 0 && (prisonerCol - securityCol) > 0) {
			security.changePoints(1, 0);
		}

		else if ((prisonerRow - securityRow) < 0 && (prisonerCol - securityCol) < 0) {
			security.changePoints(-1, 0);
		}

		else if ((prisonerRow - securityRow) == 0 && (prisonerCol - securityCol) < 0) {
			security.changePoints(0, -1);
		}

		else if ((prisonerRow - securityRow) == 0 && (prisonerCol - securityCol) > 0) {
			security.changePoints(0, 1);
		}

		else if ((prisonerRow - securityRow) > 0 && (prisonerCol - securityCol) == 0) {
			security.changePoints(1, 0);
		}

		else if ((prisonerRow - securityRow) < 0 && (prisonerCol - securityCol) == 0) {
			security.changePoints(-1, 0);
		}

		else {
			System.out.println("DON'T MOVE");
		}
	}

	public void update() {
		int prisonerX = prisoner.getRow();
		int prisonerY = prisoner.getColumn();
		int securityX = security.getRow();
		int securityY = security.getColumn();

		if (!catchPrisoner()) {

			for (int indexR = 0; indexR < rows; indexR++) {
				for (int indexC = 0; indexC < columns; indexC++) {
					if (indexR == prisonerX && indexC == prisonerY) {
						fields[indexR][indexC] = prisoner;
					} else if (indexR == securityX && indexC == securityY) {
						fields[indexR][indexC] = security;
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
		if (prisoner.getRow() == security.getRow() && prisoner.getColumn() == security.getColumn()) {
			System.out.println("CATCH!!!QQQQQQQ");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Oops...");

			alert.setHeaderText("Game over");
			alert.setContentText("You loose :(");

			alert.showAndWait();
			return true;
		}
		return false;
	}
}
