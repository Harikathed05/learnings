package com.company;

import java.util.HashMap;

public class NumberOfBoomerang {

    public int fullTuple(int [][] points) {
        HashMap<Integer, Integer> gapOfPointers = new HashMap<>();
        int allPossibleBoomerangs = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int distance = x*x + y*y;
                gapOfPointers.put(distance, gapOfPointers.getOrDefault(distance, 0) + 1);
            }
            for(int val : gapOfPointers.values()) {
                allPossibleBoomerangs += val * (val-1);
            }
            gapOfPointers.clear();
        }
        return allPossibleBoomerangs;
    }

    public static void main(String[] args ) {
        NumberOfBoomerang nob = new NumberOfBoomerang();
        int [][] points = {{1,1},{2,2},{3,3}};
        //[[0,0],[1,0],[2,0]]
        int [][] points1 = {{0,0},{1,0},{2,0}};
        int [][] points2 =  {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
       // System.out.println(nob.combinationOfBoomerang(points));
       // System.out.println(nob.combinationOfBoomerang(points1));
        System.out.println(nob.fullTuple(points1));
        //System.out.println(nob.fullTuple(points1));
        System.out.println(nob.fullTuple(points2));
    }
}
