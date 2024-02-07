package Hilos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EjercicioHiloController {

    @FXML
    private Button startButton;

    @FXML
    private void handleStartButton() {
        startButton.setDisable(true); // Deshabilita el botón para evitar múltiples clics
        ContadorThread contadorThread = new ContadorThread();
        contadorThread.start();
    }
}
