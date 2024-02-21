package Ejercicio3;

import javafx.beans.property.*;

public class Producto {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nombre = new SimpleStringProperty();
    private DoubleProperty precio = new SimpleDoubleProperty();
    private IntegerProperty codigoFabricante = new SimpleIntegerProperty();

    public Producto(int id, String nombre, double precio, int codigoFabricante) {
        this.id.set(id);
        this.nombre.set(nombre);
        this.precio.set(precio);
        this.codigoFabricante.set(codigoFabricante);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
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

    public int getCodigoFabricante() {
        return codigoFabricante.get();
    }

    public IntegerProperty codigoFabricanteProperty() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(int codigoFabricante) {
        this.codigoFabricante.set(codigoFabricante);
    }
}
