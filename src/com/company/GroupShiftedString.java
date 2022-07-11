package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class GroupShiftedString {


    public String checkGroupShifting(String str1) {
        StringBuilder stringGroupValue = new StringBuilder();
        for(int i = 0; i < str1.length()-1; i++){
            int diff = (int)str1.charAt(i+1) - (int)str1.charAt(i);
            stringGroupValue.append(diff < 0 ? 26 + diff : diff);
        }
        return stringGroupValue.toString();
    }

    public static void main(String[] args) {
        GroupShiftedString groupShiftedString = new GroupShiftedString();
        String[] stringToBeGrouped =  {"acd", "dfg", "wyz", "yab", "mop",
                "bdfh", "a", "x", "moqs"};
       // String[] stringToBeGrouped =  {"abc", "bcd", "acef", "xyz", "az",
        //        "ba", "a", "z"};
        HashMap<String, List<String>> hashStringGroups = new HashMap<>();
        for (String s:
             stringToBeGrouped) {
            if(s.length() == 1) {
                if ( hashStringGroups.containsKey("1")) {
                    List<String> arraylist = new ArrayList<>(hashStringGroups.get("1"));
                    arraylist.add(s);
                    hashStringGroups.put("1", arraylist);
                } else {
                    hashStringGroups.put("1", Arrays.asList(s));
                }
            } else {
                String group = groupShiftedString.checkGroupShifting(s);
                if ( hashStringGroups.containsKey(group)) {
                    List<String> arraylist = new ArrayList<>(hashStringGroups.get(group));
                    arraylist.add(s);
                    hashStringGroups.put(group, arraylist);
                } else {
                    hashStringGroups.put(group, Arrays.asList(s));
                }
            }
        }

        hashStringGroups.forEach((s, strings) -> System.out.println("Group Key : " + s + " Strings in group " + strings.toString()));
    }
}
