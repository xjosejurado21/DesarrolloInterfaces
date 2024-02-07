package VideoJuegos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SimpleController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private void handleSubmitButton(ActionEvent event) {
        String name = nameField.getText();
        String ageText = ageField.getText();

        if (!name.isEmpty() && !ageText.isEmpty()) {
            try {
                int age = Integer.parseInt(ageText);
                // Process the form data as needed, for example, display it
                System.out.println("Name: " + name + ", Age: " + age);
                // You can perform other actions with the form data here
            } catch (NumberFormatException e) {
                // Handle the case where age is not a valid integer
                System.out.println("Invalid age format");
            }
        } else {
            // Handle the case where either name or age is empty
            System.out.println("Please fill in all fields");
        }
    }
}
