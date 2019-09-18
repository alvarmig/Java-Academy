/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Miguel
 */
public class Entidad {

    private final StringProperty ID;
    private final StringProperty Descripcion;

    public Entidad(String ID, String Descripcion) {
        this.ID = new SimpleStringProperty(ID);
        this.Descripcion = new SimpleStringProperty(Descripcion);
    }

    public String getID() {
        return ID.get();
    }

    public void setID(String id) {
        ID.set(id);
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public String getDescripcion() {
        return Descripcion.get();
    }

    public void setClave(String descripcion) {
        Descripcion.set(descripcion);
    }

    public StringProperty DescripcionProperty() {
        return Descripcion;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
