package Ejercicio3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MainEjercicio extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ejercicio3layouts.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Mi Aplicación JavaFX");
        primaryStage.setScene(new Scene(root, 900, 300));
        primaryStage.show();

        // Configuración para la base de datos tienda
        String dbURL = "jdbc:mysql://localhost/tienda";
        String dbUser = "root";
        String dbPassword = "";

        try {
            ProductoController controller = loader.getController();
            controller.inicializar(dbURL, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
