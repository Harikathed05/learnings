package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
 * in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 */

public class FindAllAnagrams {
    private boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMapStr1 = new HashMap<>();
        for (char c:
             str1.toCharArray()) {
            hashMapStr1.put(c, hashMapStr1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> hashMapStr2 = new HashMap<>();
        for (char c:
                str2.toCharArray()) {
            hashMapStr2.put(c, hashMapStr2.getOrDefault(c, 0) + 1);
        }
        return hashMapStr1.equals(hashMapStr2);
    }

    public int[] findAllAnagrams(String original, String p) {
        int pSize = p.length();
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i < original.length(); i++) {
            if((i + pSize) <= original.length()) {
                String str1 =  original.substring(i, i+pSize);
                if(isAnagram(str1, p)) {
                    integerList.add(i);
                }
            }
        }
        return integerList.stream().mapToInt(x -> Integer.valueOf(x)).toArray();
    }

    public static void main(String [] args) {
        FindAllAnagrams findAllAnagrams = new FindAllAnagrams();
        //int[] indexes = findAllAnagrams.findAllAnagrams("cbaebabacd", "abc");
        int[] indexes = findAllAnagrams.findAllAnagrams("abab", "ab");
        for (int i = 0; i < indexes.length; i++) {
            System.out.println(indexes[i]);
        }
    }
}
