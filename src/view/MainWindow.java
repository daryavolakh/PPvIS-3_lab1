package view;

import controller.Controller;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;

public class MainWindow {
	public Controller controller;
	public Stage stage;
	public Button buttonStart = new Button("START");
	public Label labelLevel = new Label("  level: ");
	public Label levelNum = new Label("0");
	public BottleField bottleField;

	public MainWindow(Controller controller) {
		this.controller = controller;
		stage = new Stage();
		stage.setTitle("RUN!!!");
		stage.setWidth(696);
		stage.setHeight(555);
		stage.setResizable(false);

		VBox buttonsPane = new VBox();
		buttonsPane.setPadding(new Insets(20, 15, 20, 15));

		HBox levelValue = new HBox();
		levelValue.getChildren().addAll(labelLevel, levelNum);

		buttonsPane.getChildren().addAll(buttonStart, levelValue);

		HBox pane = new HBox();
		Scene scene = new Scene(pane);
		pane.getChildren().add(buttonsPane);

		bottleField = new BottleField(MainWindow.this, controller);
		pane.getChildren().add(bottleField.getGridPane());

		/*
		 * buttonStart.setOnAction(e -> { bottleField = new
		 
		 * pane.getChildren().add(bottleField.getCanvas()); });
		 */

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.A)
                {
                	controller.movePrisoner(0,-1);
                	update();
                	controller.moveSecurity();
                	update();
                }
                
                if (keyEvent.getCode() == KeyCode.D)
                {
                	controller.movePrisoner(0,1);
                	update();
                	controller.moveSecurity();
                	update();
                }
                
                if (keyEvent.getCode() == KeyCode.W)
                {
                	controller.movePrisoner(-1,0);
                	update();
                	controller.moveSecurity();
                	update();
                }
                
                if (keyEvent.getCode() == KeyCode.S)
                {
                	controller.movePrisoner(1,0);
                	update();
                	controller.moveSecurity();
                	update();
                }
            }
		});

		stage.setScene(scene);
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
	
	public void update() {
		controller.updateWorld();
		bottleField.repaint();
	}

	public void closeBottleField() {

	}

	public void changeBottleField() {

	}
}
