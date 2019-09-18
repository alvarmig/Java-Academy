/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedecartas;

import Beans.Carta;
import Beans.Jugador;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class PaqueteDeCartas {

    private Carta[] paquete;
    private static Dictionary valorDeCartas = new Hashtable();
    private static Jugador[] jugadores; //arreglo que contiene los jugadores.
    private int cartaActual; // index of next Card to be dealt (0-51)
    private static int valorDeLaMano;
    private static final int NUMERO_DE_CARTAS = 52; // constant # of Cards

    // random number generator
    private static final Random NUMEROS_ALEATORIOS = new Random();
    // constructor fills deck of Cards

    public PaqueteDeCartas() {

        String[] caras = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis",
            "Siete", "Ocho", "Nueve", "Diez", "Joker", "Quina", "Rey"};
        String[] palos = {"Corazones", "Diamantes", "Treboles", "Espadas"};

        paquete = new Carta[NUMERO_DE_CARTAS]; // create array of Card objects
        cartaActual = 0; // set currentCard so first Card dealt is deck[ 0 ]

        // populate deck with Card objects
        for (int count = 0; count < paquete.length; count++) {
            paquete[count] = new Carta(caras[count % 13], palos[count / 13]);
        }
    }

    public void barajar() {
        cartaActual = 0;
        for (int first = 0; first < paquete.length; first++) {
            int second = NUMEROS_ALEATORIOS.nextInt(NUMERO_DE_CARTAS);

            Carta temp = paquete[first];
            paquete[first] = paquete[second];
            paquete[second] = temp;

        }
    }

    public Carta repartirCarta() {
        if (cartaActual < paquete.length) {
            return paquete[cartaActual++];
        } else {
            return null;
        }
    }

    public Dictionary asignarValorDeCartas() {

        valorDeCartas.put("Tres de Diamantes", 3);
        valorDeCartas.put("Tres de Treboles", 3);
        valorDeCartas.put("Siete de Corazones", 7);
        valorDeCartas.put("Diez de Corazones", 10);
        valorDeCartas.put("Cinco de Corazones", 5);
        valorDeCartas.put("Seis de Corazones", 6);
        valorDeCartas.put("As de Corazones", 1);
        valorDeCartas.put("Tres de Corazones", 3);
        valorDeCartas.put("As de Diamantes", 1);
        valorDeCartas.put("Dos de Treboles", 2);
        valorDeCartas.put("Nueve de Corazones", 9);
        valorDeCartas.put("Joker de Espadas", 11);
        valorDeCartas.put("Dos de Espadas", 2);

        valorDeCartas.put("Dos de Diamantes", 2);
        valorDeCartas.put("Seis de Diamantes", 6);
        valorDeCartas.put("Cinco de Espadas", 5);
        valorDeCartas.put("Quina de Diamantes", 10);
        valorDeCartas.put("Joker de Diamantes", 11);
        valorDeCartas.put("Nueve de Diamantes", 9);
        valorDeCartas.put("Quina de Treboles", 10);
        valorDeCartas.put("Quina de Corazones", 10);
        valorDeCartas.put("Seis de Espadas", 6);
        valorDeCartas.put("Rey de Espadas", 11);
        valorDeCartas.put("Nueve de Treboles", 9);
        valorDeCartas.put("Siete de Diamantes", 7);
        valorDeCartas.put("Siete de Espadas", 7);

        valorDeCartas.put("Rey de Diamantes", 11);
        valorDeCartas.put("Dos de Corazones", 2);
        valorDeCartas.put("Siete de Treboles", 7);
        valorDeCartas.put("Cinco de Diamantes", 5);
        valorDeCartas.put("Joker de Corazones", 11);
        valorDeCartas.put("Quina de Espadas", 10);
        valorDeCartas.put("Diez de Espadas", 10);
        valorDeCartas.put("As de Treboles", 1);
        valorDeCartas.put("Ocho de Treboles", 8);
        valorDeCartas.put("Ocho de Diamantes", 8);
        valorDeCartas.put("Rey de Corazones", 11);
        valorDeCartas.put("As de Espadas", 1);
        valorDeCartas.put("Ocho de Corazones", 8);

        valorDeCartas.put("Diez de Treboles", 10);
        valorDeCartas.put("Cuatro de Treboles", 4);
        valorDeCartas.put("Diez de Diamantes", 10);
        valorDeCartas.put("Cuatro de Diamantes", 4);
        valorDeCartas.put("Joker de Treboles", 11);
        valorDeCartas.put("Cinco de Treboles", 5);
        valorDeCartas.put("Nueve de Espadas", 9);
        valorDeCartas.put("Seis de Treboles", 6);
        valorDeCartas.put("Rey de Treboles", 10);
        valorDeCartas.put("Cuatro de Espadas", 4);
        valorDeCartas.put("Cuatro de Corazones", 4);
        valorDeCartas.put("Ocho de Espadas", 8);
        valorDeCartas.put("Tres de Espadas", 3);

        return valorDeCartas;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeroDeJugadores;
        int cartasDelJuego;

        PaqueteDeCartas baraja = new PaqueteDeCartas();
        baraja.barajar();

        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese numero de Jugadores: ");
        numeroDeJugadores = Integer.parseInt(lector.nextLine());
        System.out.println("Ingrese numero de cartas: ");
        cartasDelJuego = Integer.parseInt(lector.nextLine());

        jugadores = new Jugador[numeroDeJugadores];

        if (numeroDeJugadores < 5 && cartasDelJuego <= NUMERO_DE_CARTAS) {
            for (int j = 0; j < numeroDeJugadores; j++) {
                Jugador jugadorActual = new Jugador();
                Carta[] manoActual = new Carta[cartasDelJuego];

                System.out.printf("Escribe el nombre del jugador: ");
                jugadorActual.setNombre(lector.nextLine());

                for (int i = 0; i < manoActual.length; i++) {
                    manoActual[i] = baraja.repartirCarta();
                }

                jugadorActual.setManoDeCartas(manoActual);
                jugadores[j] = jugadorActual;

                for (Carta carta : manoActual) {
                    System.out.println(valorDeCartas.get("Tres de Diamantes"));
                    //valorDeLaMano = Integer.parseInt(( ));
                }

                System.out.println("El nombre del jugador es: " + jugadores[j].getNombre());
                System.out.println("Su mano tiene: " + Arrays.toString(jugadores[j].getManoDeCartas()));

            }
        } else {
            System.out.printf("El número debe ser menor a 5. ");
            System.out.printf("El número de cartas debe ser menor a " + NUMERO_DE_CARTAS);
            System.out.printf("Fin de la ejecución");
            System.exit(0);
        }
        repartirRestantes(baraja);
    }

    private static void repartirRestantes(PaqueteDeCartas baraja) {
        for (int i = 1; i <= 52; i++) {
            System.out.printf("%-24s", baraja.repartirCarta());

            if (i % 4 == 0) {
                System.out.println();
            }
        }
    }

}
