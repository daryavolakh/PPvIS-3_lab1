package view;

import javafx.scene.shape.Rectangle;
import controller.Controller;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BottleField {
	public int height = 400, width = 600;
	public Controller controller;
	public MainWindow mainWindow;
	private GridPane gridPane;
	int rows = 16;
	int columns = 20;

	public BottleField(MainWindow mainWindow, Controller controller) {
		this.mainWindow = mainWindow;
		this.controller = controller;

		gridPane = new GridPane();

		controller.createWorld();
		repaint();
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void repaint() {
		gridPane.getChildren().clear();

		for (int indexR = 0; indexR < rows; indexR++) {
			for (int indexC = 0; indexC < columns; indexC++) {
				if (controller.isFieldDoor(indexR, indexC)) {
					gridPane.add(addRectangle(Color.YELLOW), indexC, indexR);
				} else if (controller.isFieldSecurity(indexR, indexC)) {
					gridPane.add(addRectangle(Color.RED), indexC, indexR);
				} else if (controller.isFieldHuman(indexR, indexC)) {					
					gridPane.add(addRectangle(Color.ORANGE), indexC, indexR);
				} else {	
					gridPane.add(addRectangle(Color.WHITE), indexC, indexR);
				}
			}
		}
	}
	
	public Rectangle addRectangle(Color color) {
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(27);
		rectangle.setHeight(27);
		rectangle.setFill(color);
		rectangle.setStroke(Color.LIGHTGRAY);
		return rectangle;
	}
}