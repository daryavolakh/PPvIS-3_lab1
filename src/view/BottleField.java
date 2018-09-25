package view;

import controller.Controller;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BottleField{
	public int height = 300, width = 500;
	public Canvas canvas;
	public Controller controller;	
	
	public BottleField(Controller controller)
	{
		this.controller = controller;
		
		canvas = new Canvas();
		canvas.setHeight(height);
        canvas.setWidth(width);
	}
	
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	
}
