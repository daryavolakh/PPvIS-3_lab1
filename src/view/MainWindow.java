package view;
import controller.Controller;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;


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
		stage.setHeight(600);
		
		VBox buttonsPane = new VBox();
		buttonsPane.setPadding(new Insets(10,10,10,10));
		
		buttonStart.setPrefSize(100, 50);
		labelLevel.setPrefSize(50, 50);
		levelNum.setPrefSize(50, 50);
		
		buttonsPane.getChildren().addAll(buttonStart,labelLevel,levelNum);
		
		HBox pane = new HBox();
		bottleField = new BottleField(controller);
		pane.getChildren().addAll(bottleField.getCanvas(),buttonsPane);

		Scene scene=new Scene(pane);
		stage.setScene(scene);			
	}
	
	public void show()
	{
		stage.show();
	}

	public void changeLevel()
	{
		getLevel();
		setLevel();
	}
	
	public int getLevel()
	{
		int level = Integer.parseInt(levelNum.getText());
		return level;
	}
	
	public void setLevel()
	{
		int prevValue = getLevel();
		levelNum.setText(String.valueOf(prevValue + 1));
	}
}
