/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class Currency implements Serializable {

    String name;
    double value;

    private PropertyChangeSupport propertySupport;

    //Constructors with Property
    public Currency(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public Currency() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double Value) {
        value = Value;
    }

}
