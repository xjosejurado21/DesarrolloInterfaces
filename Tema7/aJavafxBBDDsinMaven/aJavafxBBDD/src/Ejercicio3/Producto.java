package Ejercicio3;

import javafx.beans.property.*;

public class Producto {
    private StringProperty id = new SimpleStringProperty();
    private StringProperty nombre = new SimpleStringProperty();
    private DoubleProperty precio = new SimpleDoubleProperty();
    private StringProperty codigo_fabricante = new SimpleStringProperty();

    public Producto(String id, String nombre, double precio, String codigo_fabricante) {
        this.id.set(id);
        this.nombre.set(nombre);
        this.precio.set(precio);
        this.codigo_fabricante.set(codigo_fabricante);
    }

    // Métodos getter para propiedades observables
    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public double getPrecio() {
        return precio.get();
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public String getCodigoFabricante() {
        return codigo_fabricante.get();
    }

    public StringProperty codigoFabricanteProperty() {
        return codigo_fabricante;
    }

    public void setCodigoFabricante(String codigo_fabricante) {
        this.codigo_fabricante.set(codigo_fabricante);
    }

    // Otros métodos y constructores
}
