package application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultadoController {

    @FXML
    private Label labelResultado;

    // Método para mostrar los resultados en la etiqueta
    public void mostrarResultado(String resultado) {
        labelResultado.setText(resultado);
    }
}
