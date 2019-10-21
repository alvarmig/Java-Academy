package com.company.binaryAdd;
/*
* Program adds two binary numbers from strings. Carry needs to be considered.
 */
public class BinaryAdd {

    private static String addBinary(String num1, String num2) {
        String result = "";

        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry == 1) {

            carry += ((i >= 0) ? num1.charAt(i) - '0': 0);
            carry += ((j >= 0) ? num2.charAt(j) - '0': 0);

            result = (char)(carry % 2 + '0') + result;

            carry /=2;

            i--; j--;
        }
        return result;
    }

    private static String addBinary2(String num1, String num2) {
        StringBuilder result = new StringBuilder(0);

        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            // both ifs are used to calculate the addition of the last two characters.
            if( i >= 0) {
                sum += num1.charAt(i) - '0';
            }

            if( j >= 0) {
                sum += num2.charAt(j) - '0';
            }
            //As we are doing addition when need to use mod2 to get char we are going to insert. ex: 1 + 1 = 2, 2%2 = 0, 0 is inserted
            result.insert(0, sum % 2); //1%2=1, 0%2=0, 2%2=1

            //calculate the carry
            carry = sum / 2;

            i--; j--;
        }
       if(carry > 0){
            result.insert(0, 1);
       }

        return result.toString();
    }

    public static void main(String[] args) {
        String num = "1101";
        String num2 = "100";

        System.out.println(addBinary2(num, num2));


        String num3 = "1001";
        String num4 = "1101";

        System.out.println(addBinary2(num3, num4));
    }
}
