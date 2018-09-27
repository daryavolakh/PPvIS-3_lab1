package view;

import controller.Controller;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class MainWindow {
	public Controller controller;
	public Stage stage;
	public Button buttonStart = new Button("START");
	public Label labelLevel = new Label("  level: ");
	public Label levelNum = new Label("0");
	public BottleField bottleField;

	public MainWindow(Controller controller)
	{
		this.controller = controller;
		stage = new Stage();
		stage.setTitle("RUN!!!");
		stage.setWidth(800);
		stage.setHeight(555);
		stage.setResizable(false);
		
		VBox buttonsPane = new VBox();
		buttonsPane.setPadding(new Insets(15,15,15,15));
		
		HBox levelValue = new HBox();
		levelValue.getChildren().addAll(labelLevel,levelNum);
		
		buttonsPane.getChildren().addAll(buttonStart,levelValue);
		
		HBox pane = new HBox();
		bottleField = new BottleField(controller);
		pane.getChildren().addAll(bottleField.getCanvas(),buttonsPane);

		Scene scene=new Scene(pane);
		stage.setScene(scene);	
		
		/*scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
	        @Override
	        public void handle(KeyEvent event) {
	            if (event.getCode() == KeyCode.LEFT){
	            	bottleField.getPrisoner().setTranslateX(bottleField.getPrisoner().getTranslateX() - 5);
	            }
	            
	        }
	    });*/
		
		scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCharacter().equals("a"))
                {
                	bottleField.getPrisoner().setTranslateX(bottleField.getPrisoner().getTranslateX() - 5);
                }
                
                if (ke.getCharacter().equals("d"))
                {
                	bottleField.getPrisoner().setTranslateX(bottleField.getPrisoner().getTranslateX() + 5);
                }
                
                if (ke.getCharacter().equals("w"))
                {
                	bottleField.getPrisoner().setTranslateY(bottleField.getPrisoner().getTranslateY() - 5);
                }
                
                if (ke.getCharacter().equals("s"))
                {
                	bottleField.getPrisoner().setTranslateY(bottleField.getPrisoner().getTranslateY() + 5);
                }
            }
		});
		            
	}

	public void show() {
		stage.show();
	}

	public void changeLevel() {
		getLevel();
		setLevel();
	}

	public int getLevel() {
		int level = Integer.parseInt(levelNum.getText());
		return level;
	}

	public void setLevel() {
		int prevValue = getLevel();
		levelNum.setText(String.valueOf(prevValue + 1));
	}

	
}
