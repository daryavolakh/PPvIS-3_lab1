package view;

import controller.Controller;
import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;

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
		for (int indexR = 0; indexR < rows; indexR++) {
			for (int indexC = 0; indexC < columns; indexC++) {
				if (controller.isFieldDoor(indexR, indexC)) {
					gridPane.add(new Label("o"), indexC, indexR);
				} else if (controller.isFieldSecurity(indexR, indexC)) {
					gridPane.add(new Label("s"), indexC, indexR);
				} else if (controller.isFieldHuman(indexR, indexC)) {
					gridPane.add(new Label("x"), indexC, indexR);
				} else {
					gridPane.add(new Label(".."), indexC, indexR);
				}
			}
		}

		// for (int indexR = 0; indexR < rows; indexR++) {
		// System.out.println(indexR + " row");
		// for (int indexC = 0; indexC < columns; indexC++) {
		// Label label = (gridPane.getElement();
		// System.out.println();
		// }
		// }
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void repaint() {
		gridPane.getChildren().clear();

		for (int indexR = 0; indexR < rows; indexR++) {
			for (int indexC = 0; indexC < columns; indexC++) {
				if (controller.isFieldDoor(indexR, indexC)) {
					gridPane.add(new Label("o"), indexC, indexR);
				} else if (controller.isFieldSecurity(indexR, indexC)) {
					gridPane.add(new Label("s"), indexC, indexR);
				} else if (controller.isFieldHuman(indexR, indexC)) {
					gridPane.add(new Label("x"), indexC, indexR);
				} else {
					gridPane.add(new Label(".."), indexC, indexR);
				}
			}
		}
	}
}