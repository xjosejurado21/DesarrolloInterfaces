package MenusBar;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class SimpleController {

    @FXML
    private void handleMenuAction(ActionEvent event) {
        MenuItem sourceMenuItem = (MenuItem) event.getSource();
        System.out.println("Se seleccionó la opción: " + sourceMenuItem.getText());
    }
}
