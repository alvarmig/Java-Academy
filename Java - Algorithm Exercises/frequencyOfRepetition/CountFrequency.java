package com.company.frequencyOfRepetition;

import java.util.HashMap;
import java.util.Map;

public class CountFrequency {

    public static void countFrequency(int[] arr){
        int count =0;
        Map<Integer, Integer> tempMap =  new HashMap<Integer, Integer>();

        for(int i=0; i < arr.length; i++) {
            if(tempMap.containsKey(arr[i])){
                int counter = tempMap.get(arr[i]);
                tempMap.put(arr[i], counter + 1);
            }else {
                tempMap.put(arr[i], 1);
            }
        }
        System.out.println(tempMap);

        tempMap.entrySet().forEach(entry -> {
            System.out.printf("%-10s%10s\n" , entry.getKey(), entry.getValue());
        });

        for(Integer key : tempMap.values()){
            if(key > 1){
                count++;
            }
        }
        System.out.println("Numbers repeated are: " + count);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,4,5,6,3,3,3,6,6};
        countFrequency(arr);

        int[] arr1 = {1, 3, 1, 4, 5, 6, 3, 3};
        countFrequency(arr1);

        int[] arr2 = {7,3,2,1,5,7,8,8,6,3,4,4,4,10,11};
        countFrequency(arr2);
    }
}
