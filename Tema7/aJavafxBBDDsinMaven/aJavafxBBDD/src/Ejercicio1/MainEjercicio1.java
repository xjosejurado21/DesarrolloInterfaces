package Ejercicio1;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEjercicio1 extends Application {
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ejercicio1.fxml"));
        Parent root = loader.load();


        primaryStage.setTitle("Mi Aplicación JavaFX");
        primaryStage.setScene(new Scene(root, 550, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
    	String dbURL="jdbc:mysql://localhost/dbgametop";
		String dbUser="root";
		String dbPassword="";
		
		try {
			TVideoJuegoController controller=new TVideoJuegoController(dbURL, dbUser, dbPassword);
			controller.mostrarJuegos();
			controller.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        launch(args);
    }
}
