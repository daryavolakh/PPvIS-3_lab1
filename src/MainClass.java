import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.World;
import view.MainWindow;

public class MainClass extends Application {

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage firstStage) {
		World world = new World();
		Controller controller = new Controller(world);
		MainWindow window = new MainWindow(controller);
		window.show();
	}
}
