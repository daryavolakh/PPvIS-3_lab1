import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainWindow;

public class MainClass extends Application {
	
	public static void main(String args[]) {
		launch(args);
	}
	
	public void start(Stage firstStage)
	{
		Controller controller = new Controller();
		MainWindow window = new MainWindow(controller);
		window.show();
	}	
}

