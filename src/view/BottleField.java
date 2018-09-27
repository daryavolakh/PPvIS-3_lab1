package view;

import controller.Controller;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.scene.text.Text;

public class BottleField {
	public int height = 400, width = 600;
	public Pane canvas;
	public Controller controller;
	public Color color;
	public Circle prisonerCircle;
	public Circle securityCircle;


	public BottleField(Controller controller) {
		this.controller = controller;
		canvas = new Pane();
		canvas.setStyle("-fx-background-color: gray;");
		canvas.setPrefSize(width, height);

		Rectangle door = new Rectangle(20,100, Color.ANTIQUEWHITE);
		canvas.getChildren().add(door);
		
		Circle securityCircle = new Circle(20, Color.DARKRED);
		securityCircle.relocate(40, 200);
		startSecurityMove(securityCircle);
		
		prisonerCircle = new Circle(20, Color.PALEVIOLETRED);
		prisonerCircle.relocate(500, 200);
		canvas.getChildren().add(prisonerCircle);
	}

	public void startSecurityMove(Circle securityCircle) {		
		canvas.getChildren().add(securityCircle);
		securityCircleMove(securityCircle, 220);

	}

	public void securityCircleMove(Circle security, int end) {
		
		Polyline line = new Polyline();
	
		line.getPoints().addAll(new Double[]{0.0,0.0, 0.0,250.0, 0.0,-190.0, 0.0,0.0});
		
		PathTransition translation = new PathTransition();
		
		translation.setNode(security);
		translation.setDuration(Duration.seconds(3));
		translation.setPath(line);
		translation.setCycleCount(PathTransition.INDEFINITE);
		
		translation.play();
	}
	
	public Circle getPrisoner()
	{
		return prisonerCircle;
	}

	public Pane getCanvas() {
		return canvas;
	}

}
