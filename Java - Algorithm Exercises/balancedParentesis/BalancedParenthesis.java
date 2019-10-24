package com.company.balancedParentesis;

import java.util.Stack;

public class BalancedParenthesis {

    public static String checkParentesis(String word) {

        Stack<Character> tempStack = new Stack<Character>();
        String wordIsBalanced = "NOT BALANCED";

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '{' || word.charAt(i) == '(' || word.charAt(i) == '[') {
                tempStack.push(word.charAt(i));
            }

            if(word.charAt(i) == '}' || word.charAt(i) == ')' || word.charAt(i) == ']') {
                if(tempStack.isEmpty()){
                    return wordIsBalanced = "NOT BALANCED";
                }else if(!isMatchingPair(tempStack.pop(), word.charAt(i))){
                    return wordIsBalanced = "NOT BALANCED";
                }
            }
        }

        if (tempStack.isEmpty())
            return wordIsBalanced = "BALANCED";
        else{
            return wordIsBalanced = "NOT BALANCED";
        }
    }

    public static boolean isMatchingPair(char character1, char character2)
    {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }

    public static void main(String[] args){

        String exp = "[()]{}{[()()]()}";
        System.out.println("Input: " + exp);
        System.out.println("Output: " + checkParentesis(exp));

        String exp2 = "[(])";
        System.out.println("Input: " + exp2);
        System.out.println("Output: " +checkParentesis(exp2));

        String exp3 = "([)]";
        System.out.println("Input: " + exp3);
        System.out.println("Output: " +checkParentesis(exp3));
    }
}
