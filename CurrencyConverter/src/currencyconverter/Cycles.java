/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import Beans.Currency;
import Helpers.CurrencyConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Miguel
 */
public class Cycles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        CurrencyConverter converter = new CurrencyConverter();

        Currency currency = new Currency();

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        int operation = 0;
        double res = 0;
        double amount = 0.0f;

        do {
            System.out.println("");
            System.out.println("Welcome to the currency converter");
            System.out.println("MENU:");
            System.out.println("1- De Peso a Euro");
            System.out.println("2- De Peso a Dolar");
            System.out.println("3- De Peso a Yuan");
            System.out.println("4- Salir");
            System.out.println("Que cambio deseas hacer ?");

            try {
                operation = Integer.parseInt(keyboard.readLine());
            } catch (IOException e) {
                System.err.println("Error");
                System.exit(1);
            }

            if (operation != 4) {

                System.out.println("");

                System.out.println("Dame una cantidad en moneda nacional");
                try {
                    amount = Double.parseDouble(keyboard.readLine());
                } catch (IOException e) {
                    System.err.println("Error");
                    System.exit(1);
                }
                System.out.println("");
            }

            switch (operation) {
                case 1:
                    currency.setName("MXtoEU");
                    currency.setValue(amount);
                    res = converter.MXtoEU(amount);
                    break;
                case 2:
                    currency.setName("MXtoDOL");
                    currency.setValue(amount);
                    res = converter.MXtoDOL(amount);
                    break;
                case 3:
                    currency.setName("MXtoYUA");
                    currency.setValue(amount);
                    res = converter.MXtoYUA(amount);
                    break;
                case 4:
                    System.out.println("Bye");
                    System.exit(0);
                    break;
            }

            System.out.printf("El resultado de la conversion es: %f", res);
            System.out.println("");
            System.out.printf("El objecto currency tiene las siguientes propiedas: "
                    + "name: ".concat(currency.getName()) + " value: ".concat(String.valueOf(currency.getValue())));
            System.out.println("");

        } while (operation != 4);
    }
}
