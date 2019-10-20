package com.company.amdocs;
/*
 * Simple program to identify the colors (white or black) of a chess board.
 */
public class Chessboard {

    public static String colorChess(int num, int num2){
        String color = "";

        if(num%2 == 0 && num2%2 == 0) {
            return color = "black";
        }
        if(!(num%2 == 0) && !(num2%2 == 0)) {
            return color = "black";
        }
        if(!(num% 2 == 0) && num2%2 ==0) {
            return color = "white";
        }
        if(num% 2 == 0 && !(num2%2 == 0)) {
            return color = "white";
        }

        return color;
    }

    public static void main(String[] args) {
        System.out.println(colorChess(0,0));
        System.out.println(colorChess(1,0));
        System.out.println(colorChess(2,0));
        System.out.println(colorChess(3,0));

        System.out.println("third");
        System.out.println(colorChess(0,0));
        System.out.println(colorChess(1,1));
        System.out.println(colorChess(2,2));
        System.out.println(colorChess(3,3));

        System.out.println("second");
        System.out.println(colorChess(0,0));
        System.out.println(colorChess(0,1));
        System.out.println(colorChess(0,2));
        System.out.println(colorChess(0,3));

        System.out.println("first");

    }
}
