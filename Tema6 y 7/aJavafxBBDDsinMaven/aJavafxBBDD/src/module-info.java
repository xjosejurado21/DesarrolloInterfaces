module aJavafxBBDD {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens Ejercicio1 to javafx.graphics, javafx.fxml;
	opens Ejercicio1bis to javafx.graphics, javafx.fxml;
	opens Ejercicio2 to javafx.graphics, javafx.fxml;
	opens Ejercicio3 to javafx.graphics, javafx.fxml;
	opens Ejercicio4 to javafx.graphics, javafx.fxml;
	opens Ejercicio5 to javafx.graphics, javafx.fxml;
}
