package Ejercicio1;

import java.sql.SQLException;
import java.util.List;

public class TVideoJuegoController {
    private TVideoJuegoModel model;

    public TVideoJuegoController(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new TVideoJuegoModel(dbURL, dbUser, dbPassword);
    }

    public List<TVideoJuego> mostrarJuegos() throws SQLException {
        return model.getAllVideoJuegos();
    }

    public void cerrarConexion() throws SQLException {
        model.close();
    }
}
