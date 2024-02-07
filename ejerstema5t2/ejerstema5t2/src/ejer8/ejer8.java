package ejer8;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ejer8 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ejer8.fxml"));
		Parent root = loader.load();

		primaryStage.setTitle("Ejercicio User");
		primaryStage.setScene(new Scene(root, 600, 300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}