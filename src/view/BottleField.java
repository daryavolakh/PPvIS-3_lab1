package view;

import controller.Controller;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.shape.*;
import javafx.animation.*;

public class BottleField {
	public int height = 400, width = 600;
	public Pane canvas;
	public Controller controller;
	public Color color;
	public Circle prisonerCircle;
	public Circle securityCircle;
	public MainWindow mainWindow;


	public BottleField(MainWindow mainWindow, Controller controller) {
		this.mainWindow = mainWindow;
		this.controller = controller;
		canvas = new Pane();
		canvas.setStyle("-fx-background-color: gray;");
		canvas.setPrefSize(width, height);
		
		prisonerCircle = new Circle(20, Color.PALEVIOLETRED);
		prisonerCircle.setStroke(Color.BLACK);
		prisonerCircle.relocate(500, 200);
		canvas.getChildren().add(prisonerCircle);
		
		securityCircle = new Circle(20, Color.DARKRED);
		securityCircle.setStroke(Color.BLACK);
		securityCircle.setLayoutX(40);
		securityCircle.setLayoutY(200);
		
		canvas.getChildren().add(securityCircle);
		
		Rectangle door = new Rectangle(20,100, Color.ANTIQUEWHITE);
		door.setStroke(Color.BLACK);
		canvas.getChildren().add(door);
	}


	public void startSecurityMove() {

		Polyline line = new Polyline();
	
		double x = securityCircle.getTranslateX();
		double y = securityCircle.getTranslateY();
		
		//System.out.println("X= " + x + " Y= " + y);
		double newX = 0 + Math.random() * 5;
		double newY = 0 + Math.random() * 5;
		
		//System.out.println("newX= " + (x + newX*10) + " newY= " + (y - newY*10)); // + " CENTER_X: " + securityCircle.getCenterX());
		
		if (Math.abs(y - newY*10) > (height - 230))
		{
			line.getPoints().addAll(new Double[]{x,y, x - newX*10,y + newY*10});
		//	System.out.println("CHOOSE IF");
		}
		else
			line.getPoints().addAll(new Double[]{x,y, x + newX*10,y - newY*10});
		
		
		PathTransition translation = new PathTransition();
		
		translation.setNode(securityCircle);
		translation.setDuration(Duration.seconds(0.5));
		translation.setPath(line);
		translation.setCycleCount(1);
		
		translation.play();
		
		if ((Math.abs((securityCircle.getLayoutX() + securityCircle.getTranslateX()) - (prisonerCircle.getLayoutX() + prisonerCircle.getTranslateX())) < 40) && ((Math.abs(securityCircle.getLayoutY() + securityCircle.getTranslateY()) - (prisonerCircle.getLayoutY() + prisonerCircle.getTranslateY()))) < 40)
			System.out.println("POPALSYA!!!");
		System.out.println("SECURITY_X=" + (securityCircle.getLayoutX() + securityCircle.getTranslateX()) + "  PRISONER_X=" + (prisonerCircle.getLayoutX() + prisonerCircle.getTranslateX()));
		System.out.println("SECURITY_Y=" + (securityCircle.getLayoutY() + securityCircle.getTranslateY()) + "  PRISONER_Y=" + (prisonerCircle.getLayoutY() + prisonerCircle.getTranslateY()));
			
	}
	
	public Circle getPrisoner()
	{
		return prisonerCircle;
	}
	
	public Circle getSecurity()
	{
		return securityCircle;
	}

	public Pane getCanvas() {
		return canvas;
	}	 
}
