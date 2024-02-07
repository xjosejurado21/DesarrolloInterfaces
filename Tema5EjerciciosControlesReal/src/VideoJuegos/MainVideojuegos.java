package VideoJuegos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainVideojuegos extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VideoJuegos.fxml"));
        Parent root = loader.load();

        // Obtener el controlador después de cargar el FXML
        SimpleController controller = loader.getController();

        // Ruta local de la imagen con barras invertidas escapadas
        String imagePath = "file:C:/Users/josel/Desktop/logo.jpg";

        // Crear la imagen
        Image image = new Image(imagePath);

        // Configurar el ícono de la ventana
        primaryStage.getIcons().add(image);

        primaryStage.setTitle("Videojuegos");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
