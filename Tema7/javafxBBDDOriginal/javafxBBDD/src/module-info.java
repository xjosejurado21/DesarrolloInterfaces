module javafxBBDD {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	
	/*Module info Opens*/
	opens application to javafx.graphics, javafx.fxml;
	opens ejercicio1 to javafx.graphics, javafx.fxml;
	opens ejercicio2 to javafx.graphics, javafx.fxml;
	opens ejercicio3 to javafx.graphics, javafx.fxml;
	opens ejercicio4 to javafx.graphics, javafx.fxml;
	opens ejercicio1avanzado to javafx.graphics, javafx.fxml;
	opens reto to javafx.graphics, javafx.fxml;
}
