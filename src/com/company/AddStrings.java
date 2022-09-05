package com.company;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 *
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 */
public class AddStrings {

    public String addedStrings(String str1, String str2) {

        char [] longString = str1.length() >= str2.length() ? str1.toCharArray() : str2.toCharArray();
        char [] smallString = str1.length() <= str2.length() ? str1.toCharArray() : str2.toCharArray();
        smallString = str1.length() == str2.length() ? str2.toCharArray() : smallString;
        int j = smallString.length;
        StringBuilder stringBuilder = new StringBuilder();

        int carry = 0;
        for(int i = longString.length - 1; i >=0; i--) {
            int temp1 = Integer.parseInt(String.valueOf(longString[i]));
            System.out.println("Temp1 " + temp1);
            int temp2 = 0;
            if(j > 0 ) {
                temp2 =  Integer.parseInt(String.valueOf(smallString[j - 1]));
                System.out.println("Temp2 " + temp2);
                j --;
            }
            int sum = (temp1 + temp2 + carry ) % 10;
            System.out.println("Sum " + sum);
            carry = (temp1 + temp2 + carry ) / 10;
            System.out.println("carry " + carry);
            stringBuilder = stringBuilder.append(sum);
        }
        if(carry > 0 ) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String [] args) {
        AddStrings addStrings = new AddStrings();
        //System.out.println(addStrings.addedStrings("11", "123"));
       // System.out.println(addStrings.addedStrings("456", "77"));
        //System.out.println(addStrings.addedStrings("0", "9"));
        System.out.println(addStrings.addedStrings("1", "9"));
    }
}
