package com.company;

import java.util.HashMap;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *e.g input -> erepapere -> output -> 9 ; input -> abckayakcba -> o/p -> 11; input -> abccccdd output -> 7(dccbccd)
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "aaaaabbbccccddeeeeeee";
        String s1 = "bbccccddeeeeee";
        String s2 = "abccccdd";
        String s3 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome.checkPalindromePossibility(s));
        System.out.println(longestPalindrome.checkPalindromePossibility(s1));
        System.out.println(longestPalindrome.checkPalindromePossibility(s2));
        System.out.println(longestPalindrome.checkPalindromePossibility(s3));
    }

    public int checkPalindromePossibility(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (char c :
                str.toCharArray()) {
            if (characterIntegerHashMap.containsKey(c)) {
                int value = characterIntegerHashMap.get(c);
                characterIntegerHashMap.replace(c, value + 1);
            } else {
                characterIntegerHashMap.put(c, 1);
            }
        }
        int longestPalindromicStringPossible = 0;
        int oddCount = 0;
        for (int value :
                characterIntegerHashMap.values()) {
            System.out.println("value " + value);
            if ((value % 2 != 0) ) {
                if (oddCount == 0) {
                    longestPalindromicStringPossible = longestPalindromicStringPossible + value;
                    System.out.println("Odd count - 0 " + longestPalindromicStringPossible);
                    oddCount = 1;
                } else {

                    longestPalindromicStringPossible = longestPalindromicStringPossible + value - 1;
                    System.out.println("Odd count - 1 " + longestPalindromicStringPossible);
                }
            } else {
                longestPalindromicStringPossible = longestPalindromicStringPossible + value;
                System.out.println("even values - " + longestPalindromicStringPossible);
            }
        }
        return longestPalindromicStringPossible;
    }
}
