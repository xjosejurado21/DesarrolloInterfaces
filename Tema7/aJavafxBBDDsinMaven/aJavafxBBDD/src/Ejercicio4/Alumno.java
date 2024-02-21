package Ejercicio4;

import javafx.beans.property.*;
import java.util.Date;

public class Alumno {
	//sirve para actualizar automaticamente los nuevos valores
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nombre = new SimpleStringProperty();
    private StringProperty apellido1 = new SimpleStringProperty();
    private StringProperty apellido2 = new SimpleStringProperty();
    private StringProperty es_repetidor = new SimpleStringProperty();
    private StringProperty telefono = new SimpleStringProperty();
    private ObjectProperty<java.sql.Date> fecha_nacimiento = new SimpleObjectProperty<>();
    

    // Constructor
    public Alumno(int id, String nombre, String apellido1, String apellido2, Date fecha_nacimiento, String es_repetidor, String telefono) {
        this.id.set(id);
        this.nombre.set(nombre);
        this.apellido1.set(apellido1);
        this.apellido2.set(apellido2);
        this.fecha_nacimiento.set((java.sql.Date) fecha_nacimiento);
        this.es_repetidor.set(es_repetidor);
        this.telefono.set(telefono);
    }

    // Métodos getter y setter
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

    public String getApellido1() {
        return apellido1.get();
    }

    public StringProperty apellido1Property() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1.set(apellido1);
    }

    public String getApellido2() {
        return apellido2.get();
    }

    public StringProperty apellido2Property() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2.set(apellido2);
    }

    public Date getFechaNacimiento() {
        return fecha_nacimiento.get();
    }

    public ObjectProperty<java.sql.Date> fechaNacimientoProperty() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento.set((java.sql.Date) fecha_nacimiento);
    }

    public String getEsRepetidor() {
        return es_repetidor.get();
    }

    public StringProperty esRepetidorProperty() {
        return es_repetidor;
    }

    public void setEsRepetidor(String es_repetidor) {
        this.es_repetidor.set(es_repetidor);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }
}
