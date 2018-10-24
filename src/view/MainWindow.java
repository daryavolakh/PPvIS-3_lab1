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
	private Controller controller;
	private HBox pane;
	private Stage stage;
	private Button buttonStart = new Button("START");
	private int level = 1;
	private Label labelLevel = new Label("  level: ");
	private Label levelNum = new Label("1");
	private BottleField bottleField;

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

		pane = new HBox();
		Scene scene = new Scene(pane);
		pane.getChildren().add(buttonsPane);		

		buttonStart.setOnAction(e -> {
			bottleField = new BottleField(MainWindow.this, controller);
			//bottleField.setLevel(level);
			pane.getChildren().add(bottleField.getGridPane());
		});

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.A) {
					controller.checkLeft(0,-1);
					startMove();
				}

				if (keyEvent.getCode() == KeyCode.D) {
					controller.checkRight(0, 1);
					startMove();
				}

				if (keyEvent.getCode() == KeyCode.W) {
					controller.checkTop(-1, 0);
					startMove();
				}

				if (keyEvent.getCode() == KeyCode.S) {
					controller.checkBottom(1, 0);
					startMove();
				}
			}
		});

		stage.setScene(scene);
	}

	public void show() {
		stage.show();
	}

//	public void changeLevel() {
//		getLevel();
//		setLevel();
//	}

	public int getLevel() {
		int level = Integer.parseInt(levelNum.getText());
		return level;
	}

	public void setLevel() {
		int prevValue = getLevel();
		levelNum.setText(String.valueOf(prevValue + 1));
	}
	
	public void startMove() {
		//controller.movePrisoner(x, y);
		update();
		check();
		controller.moveSecurity();
		update();
		check();
	}

	public void update() {
		controller.updateWorld();
		bottleField.repaint();
	}
	
	public void check() {
		if(controller.isPrisonerWin()) {
			level++;
			System.out.println("LEVEL " + level);
			closeBottleField();
		//	changeBottleField();			
			levelNum.setText(Integer.toString(level));
		}
		
		else if (controller.isPrisonerLoose()) {
			closeBottleField();
		}
	}

	public void closeBottleField() {
		pane.getChildren().remove(bottleField.getGridPane());
		System.out.println("CLOSE BOTTLE");
	}

//	public void changeBottleField() {
//		this.bottleField = new BottleField(MainWindow.this,controller);
//		this.bottleField.setLevel(level);
//		pane.getChildren().add(this.bottleField.getGridPane());
//	}
}
