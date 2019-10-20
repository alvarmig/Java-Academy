package com.company.firstNonRecurringCharacter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/*
 * Program will find the first Non recurring character in a string!
 * LinkedHashMap is used to store the occurrences of the characters and to maintain the natural order of insertions.
 */
public class FirstNonRecurringCharacter {

    public static void createLinkedHashMap(String word){
        char[] tempWord = word.toCharArray();

        Map<Character, Integer> tempMap = new LinkedHashMap<Character, Integer>();

        for(int i=0; i < tempWord.length; i++) {
            if(tempMap.containsKey(tempWord[i])){
                int counter = tempMap.get(tempWord[i]);
                tempMap.put(tempWord[i], counter + 1);
            }else{
                tempMap.put(tempWord[i], 1);
            }
        }

        displayMap(tempMap);
        firstNonRecurringCharacter(tempMap);
    }

    public static void firstNonRecurringCharacter(Map<Character, Integer> tempMap) {

        Optional<Map.Entry<Character, Integer>> result = tempMap.entrySet().stream().filter(value -> {
            if(value.getValue() == 1) {
                return true;
            }
            return false;
        }).findFirst();

        System.out.println(result);

    }

    public static void displayMap(Map<Character, Integer> tempMap){

        System.out.println(tempMap);

        tempMap.entrySet().forEach(value -> {
            System.out.println(value.getKey() + " " +  value.getValue());
        });
    }

    public static void main(String[] args){
        String word = "abcbahcjtlw";
        createLinkedHashMap(word);

        String word2 = "qwsqwstzx";
        createLinkedHashMap(word2);


    }
}
