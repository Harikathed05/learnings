package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class SortByCharFrequency {
    private void sortStringToCharFrequency(String str) {
        HashMap<Character, Integer> characterIntegerTreeMap = new HashMap<>();
        for (char c:
             str.toCharArray()) {
            if(characterIntegerTreeMap.containsKey(c)) {
                characterIntegerTreeMap.put(c, characterIntegerTreeMap.get(c) + 1);
            } else {
                characterIntegerTreeMap.put(c, 1);
            }
        }
        //characterIntegerTreeMap.forEach((key, value) -> { System.out.println("key "+ key + " value "+ value);});
        TreeMap<Integer, List<Character>> uniqueCharFrequency = new TreeMap<>();
        for (Map.Entry<Character, Integer> o:
             characterIntegerTreeMap.entrySet()) {
            if(uniqueCharFrequency.containsKey(o.getValue())) {
                List<Character> characters = new ArrayList<>(uniqueCharFrequency.get(o.getValue()));
                characters.add(o.getKey());
                uniqueCharFrequency.put(o.getValue(), characters);
            } else {
                uniqueCharFrequency.put(o.getValue(), Arrays.asList(o.getKey()));
            }
        }
        StringBuilder sb = new StringBuilder();
        uniqueCharFrequency.forEach((key, value) -> { printListOfChar(key, value, sb);});
        System.out.println(sb.reverse().toString());
    }

    private void printListOfChar(int key, List<Character> characters, StringBuilder sb) {

            Arrays.stream(characters.toArray()).sorted().collect(Collectors.toList()).forEach( c -> {
                for (int i = 0; i < key; i++) {
                    sb.append(c);
                }
            });
    }
    public static void main(String[] args) {
        SortByCharFrequency sortByCharFrequency = new SortByCharFrequency();
        //sortByCharFrequency.sortStringToCharFrequency("abc");
        //sortByCharFrequency.sortStringToCharFrequency("GeeksforGeeks");
        //sortByCharFrequency.sortStringToCharFrequency("geeksforgeeks");
        sortByCharFrequency.sortStringToCharFrequency("tree");
    }
}
