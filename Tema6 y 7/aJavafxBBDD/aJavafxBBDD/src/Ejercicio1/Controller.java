package Ejercicio1;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.List;

public class Controller {

    @FXML
    private ListView<String> listViewVideojuegos;

    private TVideoJuegoController dbController;

    public Controller() throws SQLException {
        // Inicializa el controlador de la base de datos
    	  String dbURL = "jdbc:mysql://localhost/dbgametop";
          String dbUser = "root";
          String dbPassword = "";
          dbController = new TVideoJuegoController(dbURL, dbUser, dbPassword);
    }

    @FXML
    private void initialize() {
        // Al inicializar el controlador, carga los juegos desde la base de datos
        try {
            cargarJuegos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarJuegos() throws SQLException {
        List<TVideoJuego> videojuegos = dbController.mostrarJuegos();
        // Aquí podrías formatear la lista de videojuegos y mostrarlos en el ListView
        // por ejemplo, convirtiendo cada objeto TVideoJuego a una cadena descriptiva
        listViewVideojuegos.getItems().clear();
        for (TVideoJuego videojuego : videojuegos) {
            String descripcion = videojuego.getNombre() + " (" + videojuego.getAnio() + ") - " +
                    videojuego.getCompania() + ", " + videojuego.getPrecio() + ", " +
                    videojuego.getSinopsis() + ", " + videojuego.getPlataforma();
            listViewVideojuegos.getItems().add(descripcion);
        }
    }

    @FXML
    private void cerrarConexion() {
        // Cierra la conexión a la base de datos
        try {
            dbController.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
}
