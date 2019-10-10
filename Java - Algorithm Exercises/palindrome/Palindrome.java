package com.company.palindrome;
/*
* Program identifies which words from an array are palindromes.
* One for is used to convert each string into an array of characters.
 */
public class Palindrome {

    public static void palindrome(String[] words ) {
        for(int i = 0; i < words.length; i++){
            char[] tempWord = words[i].toCharArray();

            int middle = tempWord.length/2;
            boolean palindrome = false;

            for(int j = 0; j <= (middle); j++){
                if(tempWord[j] == tempWord[tempWord.length - j - 1]){
                    palindrome = true;
                }else{
                    palindrome = false;
                    break;
                }
            }
            if(palindrome == true) {
                System.out.println(words[i] + " it's a  palindrome");
            }else {
                System.out.println(words[i] + " is Not a palindrome");
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"madam", "ala", "10801", "not", "madom", "caravana", "ana"};

        palindrome(words);
    }
}
