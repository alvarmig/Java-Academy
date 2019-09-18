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
public class Jugador {

    private String nombre;
    private Carta[] manoDeCartas;

    public Jugador() {

    }

    public Jugador(String nombreJugador, Carta[] cartas) {
        nombre = nombreJugador;
        manoDeCartas = cartas;
    }

    public void setNombre(String nombreJugador) {
        nombre = nombreJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setManoDeCartas(Carta[] cartas) {
        manoDeCartas = cartas;
    }

    public Carta[] getManoDeCartas() {
        return manoDeCartas;
    }
}
