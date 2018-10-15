package view;

import controller.Controller;
import javafx.scene.layout. GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BottleField {
	public int height = 400, width = 600;
	public Controller controller;
	public MainWindow mainWindow;
	private GridPane gridPane;	
	int rows = 8;
	int columns = 12;
	
	
	public BottleField(MainWindow mainWindow, Controller controller) {
		this.mainWindow = mainWindow;
		this.controller = controller;
		
		gridPane = new GridPane();
		
		controller.createWorld();
		for(int indexR = 0; indexR < rows; indexR++)
			for(int indexC = 0; indexC < columns; indexC++)
			{
				if (controller.isFieldDoor(indexR,indexC))
					gridPane.add(new Label(), indexC, indexR);
				else if (controller.isFieldSecurity(indexR,indexC))
					gridPane.add(new Label("O"), indexC, indexR);
				
				else if (controller.isFieldHuman(indexR,indexC))
					gridPane.add(new Label("X"), indexC, indexR);
				
				else 
					gridPane.add(new Label(" "), indexC, indexR);
			}
		
	}

	public void startSecurityMove() {

		

	/*	if (prisonerCatchUp) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Oops...");
			alert.setHeaderText("You lose...");
			alert.setContentText("Game over...");
			alert.showAndWait();
		} else if (prisonerGetsOut) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Congratilations!");
			alert.setHeaderText("You're lucky :)");
			alert.setContentText("Let's start next level!");
			alert.showAndWait();
		}
	}

	public Circle getPrisoner() {
		return prisonerCircle;
	}

	public Circle getSecurity() {
		return securityCircle;
	}

	public Pane getCanvas() {
		return canvas;
	}	*/
}
	}