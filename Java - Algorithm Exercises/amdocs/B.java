package com.company.amdocs;

public class B extends A {
    int fi = 15;

    public static void main(String[] args) {
        B b = new B();
        b.fi = 20;

        System.out.println(b.fi);
        System.out.println(((A)b).fi);
    }
}
