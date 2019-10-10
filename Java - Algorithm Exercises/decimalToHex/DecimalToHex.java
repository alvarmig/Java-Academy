package com.company.decimalToHex;
/*
* Program that converts an integer to the hexadecimal value.
 */
public class DecimalToHex {

    public static void decimalHex(int number){
        String hex;
        hex = Integer.toHexString(number);
        System.out.println(hex);
    }

    public static void main(String[] args) {
        decimalHex(200);
        decimalHex(16);
    }
}
