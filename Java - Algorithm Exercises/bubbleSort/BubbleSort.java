package com.company.bubbleSort;

/*
* Program that implements the bubble sort algorithm, two loops are requires.
 */
public class BubbleSort {

    public static void bubbleSort(int[] numbers){
        for(int i = 0; i < numbers.length - 1; i++) {

            for(int j = 0; j < numbers.length - i - 1; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    int tempNumber = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tempNumber;
                }
            }
        }

        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(numbers);
    }
}
