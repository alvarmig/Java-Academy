package com.company.wordTypeCount;

import java.util.*;
/*
* Program counts the number of occurrences of each word in a given String by the user.
* A HashMap is used to store the occurrence of each word.
*/
public class WordTypeCount {

    public static void main(String[] args) {
        Map<String, Integer> tempMap = new HashMap<String, Integer>();

        createMap(tempMap);
        //displayMap(tempMap);
        displayMapArrow(tempMap);
    }

    public static void createMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = scanner.nextLine();

        System.out.println("String entered: " + input);

        String[] chars = input.split( " " );

        for(String token : chars){
            String word = token.toLowerCase();
            // if the map contains the word
            if(map.containsKey(word)){
                int count = map.get(word);
                map.put(word, count + 1);
            }else {
                map.put(word, 1);
            }
        }
    }
    // Display Map, arrow function implementation.
    public static void displayMapArrow(Map<String, Integer> map) {

        System.out.println( "\nMap contains:\nKey\t\tValue" );
        map.entrySet().forEach(entry -> {
            System.out.printf("%-10s%10s\n" , entry.getKey(), entry.getValue());
        });
    }

    public static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet();
        TreeSet<String> sortedKeys = new TreeSet<String>( keys );

        System.out.println( "\nMap contains:\nKey\t\tValue" );
        for(String key : sortedKeys){
            System.out.printf( "%-10s%10s\n", key, map.get(key));
        }
    }
}
