package com.company.amdocs;

public class AmdocsTest {

    public static void bark(){
        System.out.println("Woof!");
    }

    public static void main(String[] args){
        AmdocsTest Spunky = new AmdocsTest();
        Spunky.bark();

        AmdocsTest spike =  null;
        spike.bark();
    }
}
