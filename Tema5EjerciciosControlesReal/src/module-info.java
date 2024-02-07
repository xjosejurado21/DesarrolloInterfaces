module Tema5EjerciciosControlesReal {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
	opens MenusBar to javafx.graphics, javafx.fxml;
	opens Calculadora to javafx.graphics, javafx.fxml;
	opens VideoJuegos to javafx.graphics, javafx.fxml;
	opens Css to javafx.graphics, javafx.fxml;
	

}
