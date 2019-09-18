/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 * Albergar las propiedades de una carta
 *
 * @author Miguel
 */
public class Carta {

    private String cara; // cara de la carta, que puede ser uno, dos, ...
    private String palo; // palo de la carta, puede ser: espadas, diamantes, treboles...

    public Carta(String caraCarta, String paloCarta) {
        cara = caraCarta;
        palo = paloCarta;
    }

    // return String representation of Card
    @Override
    public String toString() {
        return cara + " de " + palo;
    }

}
