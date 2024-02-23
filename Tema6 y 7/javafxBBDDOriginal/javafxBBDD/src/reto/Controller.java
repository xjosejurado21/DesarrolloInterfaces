package reto;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;
import java.util.List;

public class Controller {

	@FXML
	private TableView<Libro> tableViewLibro;

	@FXML
	private TableColumn<Libro, String> tituloColumn;

	@FXML
	private TableColumn<Libro, String> editorialColumn;

	@FXML
	private TableColumn<Libro, String> autorColumn;

	@FXML
	private TableColumn<Libro, Integer> paginasColumn;

	@FXML
	private TextField tituloTF;

	@FXML
	private ChoiceBox<String> editorialCB;

	@FXML
	private TextField autorTF;

	@FXML
	private TextField paginasTF;

	@FXML
	private Button btnAñadir;

	@FXML
	private Button btnBorrar;

	private LibroModel model;

	public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
		model = new LibroModel(dbURL, dbUser, dbPassword);

		btnAñadir.setOnAction(event -> agregarLibro());

		cargarEditoriales();
		mostrarLibro();
	}

	private void cargarEditoriales() {
		List<String> editoriales = List.of("Planeta", "B de Block", "Debolsillo", "Penguin", "Salamandra");

		editorialCB.setItems(FXCollections.observableArrayList(editoriales));
	}

	private void mostrarLibro() throws SQLException {
		tableViewLibro.getItems().clear();

		List<Libro> libro = model.getAllLibros();

		tableViewLibro.getItems().addAll(libro);
	}

	@FXML
	private void agregarLibro() {
		String titulo = tituloTF.getText();
		String editorial = editorialCB.getValue();
		String autor = autorTF.getText();
		int paginas = Integer.parseInt(paginasTF.getText());

		Libro nuevoLibro = new Libro(0, titulo, editorial, autor, paginas);
		try {
			model.agregarLibro(nuevoLibro);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String mensaje = "Libro añadido:\n" + "Titulo: " + titulo + "\n" + "Editorial: " + editorial + "\n" + "Autor: "
				+ autor + "\n" + "Páginas: " + paginas;

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Libro Añadido");
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();

		mostrarRegistros();
		limpiarCampos();
	}

	private void limpiarCampos() {
		tituloTF.clear();
		editorialCB.setValue(null);
		autorTF.clear();
		paginasTF.clear();
	}

	@FXML
	private void borrarRegistro() {
		String tituloLibro = tituloTF.getText();
		try {
			model.borrarRegistro(tituloLibro);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Libro borrado");
			alert.setHeaderText(null);
			alert.setContentText("Has borrado el libro " + tituloLibro);
			alert.showAndWait();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		limpiarCampos();
	}
	
	@FXML
    private void mostrarRegistros() {

        tituloColumn.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        editorialColumn.setCellValueFactory(cellData -> cellData.getValue().editorialProperty());
        autorColumn.setCellValueFactory(cellData -> cellData.getValue().autorProperty());
        paginasColumn.setCellValueFactory(cellData -> cellData.getValue().paginasProperty().asObject());

        // Limpiar la TableView antes de cargar nuevos datos
        tableViewLibro.getItems().clear();

        try {
            List<Libro> libro = model.getAllLibros();

            // Agrega los datos a la TableView
            tableViewLibro.getItems().addAll(libro);

        } catch (SQLException e) {
            e.printStackTrace();
        } // catch
    } // fun

	@FXML
	private void cerrarConexion() {
		try {
			model.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
