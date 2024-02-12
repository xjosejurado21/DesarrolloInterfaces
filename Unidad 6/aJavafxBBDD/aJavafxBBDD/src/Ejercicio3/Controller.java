package Ejercicio3;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.List;

public class Controller {

    @FXML
    private TableView<Producto> tableViewProductos;

    @FXML
    private TableColumn<Producto, String> idColumn;

    @FXML
    private TableColumn<Producto, String> nombreColumn;

    @FXML
    private TableColumn<Producto, Double> precioColumn;

    @FXML
    private TableColumn<Producto, String> codigoFabricanteColumn;

    private ProductoModel model;

    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Inicializa el modelo de la base de datos
        model = new ProductoModel(dbURL, dbUser, dbPassword);

        // Configura las columnas de la TableView
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        codigoFabricanteColumn.setCellValueFactory(cellData -> cellData.getValue().codigoFabricanteProperty());

        // Al inicializar el controlador, carga los productos desde la base de datos
        try {
            cargarProductos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarProductos() throws SQLException {
        // Limpiar la TableView antes de cargar nuevos datos
        tableViewProductos.getItems().clear();

        List<Producto> productos = model.getAllProductos();

        // Agrega los datos a la TableView
        tableViewProductos.getItems().addAll(productos);
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
