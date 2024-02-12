package application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Binding {

    public static void main(String[] args) {
        IntegerProperty edad = new SimpleIntegerProperty(18);
        // Crear un enlace para verificar si la edad es mayor o igual a 18
        BooleanBinding esMayorDeEdad = Bindings.greaterThanOrEqual(edad, 18);

        // Imprimir el resultado del enlace
        System.out.println("¿Es mayor de edad? " + esMayorDeEdad.get());
        // Cambiar la edad y observar el cambio en el enlace
        edad.set(20);
        System.out.println("¿Es mayor de edad? " + esMayorDeEdad.get());
        edad.set(17);
        System.out.println("¿Es mayor de edad? " + esMayorDeEdad.get());
    }
}