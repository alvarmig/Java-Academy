package com.company.amdocs;
//https://www.buggybread.com/2014/12/java-interview-questions-and-answers_29.html
public class Beta extends Baap {
    public int h =44;
    public int getH(){
        System.out.println("Beta " + h);
        return h;
    }

    public static void main(String[] args){
        Baap b = new Beta();
        System.out.println(b.h + "" + b.getH());

        Beta bb = (Beta)b;
        System.out.println(bb.h + "" + bb.getH());
    }
}
