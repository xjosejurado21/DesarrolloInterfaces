package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ejercicio1 extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
FXMLLoader loader = new FXMLLoader(getClass().getResource("ejercicio2.fxml"));
Parent root = loader.load();
//Tittle
primaryStage.setTitle("Mi Aplicación JavaFX");
primaryStage.setScene(new Scene(root, 850, 300));
primaryStage.show();
}

public static void main(String[] args) {
launch(args);
}
}