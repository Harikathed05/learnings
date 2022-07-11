package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Heaters {

    public int findRadius(int [] houses, int [] heaters) {
        HashMap<Integer, Integer> minRadius = new HashMap<>();
        for (int i = 0; i < houses.length; i++) {
            if (!minRadius.containsKey(houses[i])) {
                minRadius.put(houses[i], minRadiusToHouse(houses[i], heaters));
            }
        }
        List<Integer> minRadiusList = minRadius.values().stream().collect(Collectors.toList());
        int max = 0;
        for (int radius :
                minRadiusList) {
            if(radius > max) {
                max = radius;
            }
        }
        return max;
    }
    private int minRadiusToHouse(int house, int [] heaters) {
        int min = Math.abs(house - heaters[0]);

        for(int i = 1; i < heaters.length; i++) {
            int temp = house - heaters[i];
            temp = Math.abs(temp);

            if(min > temp){
                min = temp;
            }
        }
        System.out.println("Returning min radius " + min + " for house " + house);
        return min;
    }

    public static void main(String [] args) {
        Heaters heater = new Heaters();
        int [] houses = {1,2,3,4};
        int [] heaters = {1,4};
        System.out.println("Min radius " + heater.findRadius(houses, heaters));
    }
}
