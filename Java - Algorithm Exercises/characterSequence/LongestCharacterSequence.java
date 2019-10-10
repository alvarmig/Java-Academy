package com.company.characterSequence;

import java.util.HashMap;
import java.util.Map;
/*
* Program will find the most repeated character from a given string.
* Two approaches are used, one with HashMap that prints all the occurrences and one will simple variables.
 */
public class LongestCharacterSequence {
    //HashMap approach.
    public static void longestCharSequence(String word){

        Map<Character, Integer> tempMap =  new HashMap<Character, Integer>();

        char[] tempWord = word.toCharArray();

        for(int i = 0; i < tempWord.length; i++) {
            if(tempMap.containsKey(tempWord[i])) {
                int counter = tempMap.get(tempWord[i]);
                tempMap.put(tempWord[i], counter + 1);
            } else{
                tempMap.put(tempWord[i], 1);
            }
        }
        // print the hashMap and find the Max value.
        final Map.Entry<Character, Integer>[] maxEntry = new Map.Entry[]{null};

        tempMap.entrySet().forEach(entry -> {
            System.out.printf("%-10s%10s\n" , entry.getKey(), entry.getValue());

            if(maxEntry[0] == null || entry.getValue().compareTo(maxEntry[0].getValue()) > 0){
                maxEntry[0] = entry;
            }
        });
        System.out.println("Most repeated character is: " + maxEntry[0]);
    }

    // Simple approach to count the characters using two chars and two counters.
    public static void longestCharSequenceSimple(String word){
        char[] tempWord = word.toCharArray();

        char current_char = 0;
        char max_char = 0;
        int count = 0;
        int max_count = 0;

        for(var i=0; i < tempWord.length; i++){
            if(current_char == tempWord[i]){
                count++;
            }else{
                count = 1;
            }

            if(count > max_count){
                max_count = count;
                max_char = tempWord[i];
            }
            current_char = tempWord[i];
        }
        System.out.println("character: " + max_char  + " count: " + max_count);
    }

    public static void main(String[] args) {
        String characters = "AABCDDBBBEAFSDFJHHHHHJKKK0000";
        longestCharSequence(characters);

        longestCharSequenceSimple(characters);
    }
}
