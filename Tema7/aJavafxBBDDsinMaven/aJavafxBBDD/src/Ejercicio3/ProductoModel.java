package Ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel {
    private Connection conn;

    public ProductoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    public List<Producto> getAllProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM producto");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String id = rs.getString("id");
            String nombre = rs.getString("nombre");
            double precio = rs.getDouble("precio");
            String codigoFabricante = rs.getString("codigo_fabricante");
            // Asegúrate de que estos nombres coincidan con los de la clase Producto
            productos.add(new Producto(id, nombre, precio, codigoFabricante));
        }
        stmt.close();
        rs.close();
        return productos;
    }

    public void close() throws SQLException {
        conn.close();
    }
}
