package view;

import controller.Controller;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
	private Label labelLevel = new Label("  level: ");
	private Label levelNum = new Label("1");
	private BottleField bottleField;
	private boolean useHelp = true;

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
			pane.getChildren().add(bottleField.getGridPane());
		});

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {

				if (keyEvent.getCode() == KeyCode.A && keyEvent.isShiftDown()) {
					controller.checkLeftForJump(0, -2);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.D && keyEvent.isShiftDown()) {
					controller.checkRightForJump(0, 2);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.W && keyEvent.isShiftDown()) {
					controller.checkTopForJump(-2, 0);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.S && keyEvent.isShiftDown()) {
					controller.checkBottomForJump(2, 0);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.A && keyEvent.isAltDown()) {
					System.out.println("ALT");
					controller.hitRLSecurity(0,2);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.D && keyEvent.isAltDown()) {
					System.out.println("ALT");
					controller.hitRLSecurity(0,-2);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.W && keyEvent.isAltDown()) {
					System.out.println("ALT");
					controller.hitBTSecurity(-2,0);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.S && keyEvent.isAltDown()) {
					System.out.println("ALT");
					controller.hitBTSecurity(2,0);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.A) {
					controller.checkLeft(0, -1);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.D) {
					controller.checkRight(0, 1);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.W) {
					controller.checkTop(-1, 0);
					startMove();
				}

				else if (keyEvent.getCode() == KeyCode.S) {
					controller.checkBottom(1, 0);
					startMove();
				}
				
				else if (keyEvent.getCode() == KeyCode.H && useHelp) {
					controller.securityLoseAttention();
					update();
					useHelp = false;
				}
			}
		});

		stage.setScene(scene);
	}

	public void show() {
		stage.show();
	}

	public int getLevel() {
		int level = Integer.parseInt(levelNum.getText());
		return level;
	}

	public void setLevel() {
		int prevValue = getLevel();
		levelNum.setText(String.valueOf(prevValue + 1));
	}

	public void startMove() {
		controller.moveSecurity();
		update();
	}

	public void update() {
		controller.updateWorld();
		check();
		bottleField.repaint();
	}

	public void check() {
		if (controller.prisonerWinGame()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Congratulations!");

			alert.setHeaderText("YOU WIN");
			alert.setContentText("!!!!!!!!!!!!!!!!!");

			alert.showAndWait();

			closeBottleField();
			stage.close();
		} else if (controller.isPrisonerWin()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Congratulations!");

			alert.setHeaderText("Good job!");
			alert.setContentText("Let's start next level!");

			alert.showAndWait();

			closeBottleField();

			changeBottleField();
			levelNum.setText(Integer.toString(controller.getLevel()));
		} else if (controller.isPrisonerLoose()) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Oops...");

			alert.setHeaderText("Game over");
			alert.setContentText("You loose :(");

			alert.showAndWait();
			closeBottleField();
		}
	}

	public void closeBottleField() {
		pane.getChildren().remove(bottleField.getGridPane());
	}

	public void changeBottleField() {
		this.bottleField = new BottleField(MainWindow.this, controller);
		pane.getChildren().add(this.bottleField.getGridPane());
	}
}
