/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author Miguel
 */
public class CurrencyConverter {

    public static double MXtoEU(double change) {
        double res = 0.0;
        res = change / 16.8;
        System.out.println("");
        return res;
    }

    public static double MXtoDOL(double change) {
        double res = 0.0;
        res = change / 12.7;
        System.out.println("");
        return res;
    }

    public static double MXtoYUA(double change) {
        double res = 0.0;
        res = MXtoDOL(change) * .15;
        System.out.println("");
        return res;
    }

}
