/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

/**
 *
 * @author Miguel
 */
public class lock {

    public static void main(String[] args) {
        boolean lock;
        for (int i = 0; i < 100; i++) {
            if (i == 10) {
                lock = true;

                if (lock) {
                    System.out.printf("El numero de iteraciones fue: " + i + "\n");
                    lock = false;
                }
            }
            if (i == 99) {
                System.out.println("Fin de la ejecución\n");
            }
        }
    }
}
