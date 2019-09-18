/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Miguel
 */
public class Divisa {

    private int id;
    private String nombre;
    private float valor;

    //private PropertyChangeSupport propertySupport;
    //Constructors with Property
    /*public Currency(Integer id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }*/

 /*public Currency() {
        propertySupport = new PropertyChangeSupport(this);
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
