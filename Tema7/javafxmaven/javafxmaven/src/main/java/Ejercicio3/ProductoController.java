package Ejercicio3;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ProductoController implements Initializable {

    @FXML
    private TableView<Producto> tableViewProductos;

    @FXML
    private TableColumn<Producto, Number> idColumn;

    @FXML
    private TableColumn<Producto, String> nombreColumn;

    @FXML
    private TableColumn<Producto, Number> precioColumn;

    @FXML
    private TableColumn<Producto, Number> codigoFabricanteColumn;

    private ProductoModel model;

    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new ProductoModel(dbURL, dbUser, dbPassword);

        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty());
        codigoFabricanteColumn.setCellValueFactory(cellData -> cellData.getValue().codigoFabricanteProperty());

        cargarProductos();
    }

    private void cargarProductos() throws SQLException {
        tableViewProductos.getItems().clear();
        List<Producto> productos = model.getAllProductos();
        tableViewProductos.getItems().addAll(productos);
    }

    @FXML
    private void cerrarConexion() {
        try {
            model.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
