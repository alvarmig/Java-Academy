/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Miguel
 */
public class Genero {

    private final StringProperty Clave;
    private IntegerProperty ID;

    public Genero(String Clave, Integer id) {
        this.Clave = new SimpleStringProperty(Clave);
        this.ID = new SimpleIntegerProperty(id);
    }

    public String getClave() {
        return Clave.get();
    }

    public void setClave(String Name) {
        Clave.set(Name);
    }

    public StringProperty ClaveProperty() {
        return Clave;
    }

    public IntegerProperty valueProperty() {
        return ID;
    }

    public void setID(int id) {
        ID.set(id);
    }

    public Integer getID() {
        return ID.get();
    }

    @Override
    public String toString() {
        return getClave();
    }
}
