package com.company.amdocs;
/*
 * Simple program to check if an object equals null will call a method.
 */
public class Dog {

    public static void bark(){
        System.out.println("Woof!");
    }

    public static void main(String[] args){
        Dog Spunky = new Dog();
        Spunky.bark();

        Dog spike =  null;
        spike.bark();
    }
}
