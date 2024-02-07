package HilosReto;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EjercicioHiloController {

    @FXML
    private Button startButton;

    @FXML
    void handleStartButton() {
        for (int i = 0; i < 5; i++) { // Lanza 5 hilos
            Thread thread = new Thread(new ContadorThread());
            thread.start();
        }
    }
}
