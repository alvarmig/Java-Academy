package com.company.firstRecurringCharacter;

import java.util.HashMap;
import java.util.Map;
/*
* Program will find the first recurring character in an array!
* HashMap is used to store the occurrences of the characters.
 */
public class FirstRecurringCharacter {
    public static void firstRecurringCharacter(char[] array){
        Map<Character, Integer> tempMap =  new HashMap<Character, Integer>();
        int count = 0;

        for(int i=0; i < array.length; i++){
            if(tempMap.containsKey(array[i])){
                //count = tempMap.get(array[i]);
                System.out.println(array[i] + " is the first recurring character!");
                break;
            }else{
                tempMap.put(array[i], 1);
            }
        }
    }

    public static void main(String[] args) {
        char[] array = {'D','C','B','A','C','D'};
        firstRecurringCharacter(array);

        char[] array2 = {'D','F','B','A','C','J','Y','B','A','G','H'};
        firstRecurringCharacter(array2);
    }
}
