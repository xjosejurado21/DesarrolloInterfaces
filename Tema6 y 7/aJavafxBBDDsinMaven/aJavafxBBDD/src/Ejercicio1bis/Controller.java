package Ejercicio1bis;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.List;

public class Controller {

    @FXML
    private ListView<String> listaVideojuegos;

    private TVideoJuegoModel model;

    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Inicializa el modelo de la base de datos
        model = new TVideoJuegoModel(dbURL, dbUser, dbPassword);

        // Al inicializar el controlador, carga los juegos desde la base de datos
        try {
            cargarJuegos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarJuegos() throws SQLException {
        List<TVideoJuego> videojuegos = model.mostrarVideoJuegos();
        // Aquí podrías formatear la lista de videojuegos y mostrarlos en el ListView
        // por ejemplo, convirtiendo cada objeto TVideoJuego a una cadena descriptiva
        listaVideojuegos.getItems().clear();
        for (TVideoJuego videojuego : videojuegos) {
            String descripcion = videojuego.getNombre() + " (" + videojuego.getAnio() + ") - " +
                    videojuego.getCompania() + ", " + videojuego.getPrecio() + ", " +
                    videojuego.getSinopsis() + ", " + videojuego.getPlataforma();
            listaVideojuegos.getItems().add(descripcion);
        }
    }

    @FXML
    private void cerrarConexion() {
        // Cierra la conexión a la base de datos
        try {
            model.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

