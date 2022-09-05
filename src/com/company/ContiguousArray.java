package com.company;

import java.util.HashMap;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> maxSumSubArray = new HashMap<>();
        int sum = 0;
        int max = 0;
        maxSumSubArray.put(sum, -1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if(maxSumSubArray.containsKey(sum)) {
                max = Math.max(max, (i - (maxSumSubArray.get(sum))));
            } else {
                maxSumSubArray.put(sum, i);
            }
        }


        //int ones = 0;
        //int zeros = 0;
        /*for (int i:
             nums) {
            if(i == 0) {
                zeros++;
            } else {
                ones++;
            }
        }
        if(zeros == 0 || ones == 0) {
            return 0;
        }
        System.out.println("zeros " + zeros + " ones "+ ones + " nums.length "+nums.length);
        int subarrayLenRight = nums.length;
        int zerosRight = zeros;
        //int zerosLeft = zeros;
        int onesRight = ones;
        int newOnes = ones;
        int newZeros = zeros;
        //int onesLeft = ones;
        for(int j = 0; j <  nums.length; j++) {
                if(zerosRight == onesRight) {
                    break;
                } else {
                    if(nums[j] == 0) {
                        zerosRight--;
                        //System.out.println("extra zeros " + zeros);
                    } else {
                        onesRight--;
                        //System.out.println("extra ones " + ones);
                    }
                    subarrayLenRight-- ;
                }
        }
        int subarrayLenLeft = nums.length;
        //int k = 0;
        for(int j = nums.length -1; j >= 0; j--) {
                if(zeros == ones) {
                    System.out.println("zeros "+ zeros +" ones "+ ones);
                    break;
                } else {
                    if(nums[j] == 0) {
                        zeros--;
                        //System.out.println("extra zeros " + zeros);
                    } else {
                        ones--;
                        //System.out.println("extra ones " + ones);
                    }
                    subarrayLenLeft--;
                }
            //}
        }
        int left = 0;
        int right = nums.length-1;
        int newLen = nums.length;

        while (left<right) {
            if(newZeros == newOnes) {
                break;
            } else {
                if(nums[left] == 0) {
                    newZeros--;
                } else {
                    newOnes--;
                }
                if(nums[right] == 0) {
                    newZeros--;
                } else {
                    newOnes--;
                }
                newLen = newLen - 2;
            }
            left++;
            right--;
        }
        System.out.println("subarrayLenRight " + subarrayLenRight + " subarrayLenLeft "+ subarrayLenLeft + " newLen " + newLen);
        return subarrayLenRight > subarrayLenLeft ? subarrayLenRight : subarrayLenLeft;*/
        return max;
    }

    public static void main(String [] args) {
        ContiguousArray contiguousArray = new ContiguousArray();
       //System.out.println("length of max subarray " + contiguousArray.findMaxLength(new int[]{0,1,0}));
        //System.out.println("length of max subarray " + contiguousArray.findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
        //System.out.println("length of max subarray " + contiguousArray.findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
        //System.out.println("length of max subarray " + contiguousArray.findMaxLength(new int[]{0,1,1}));
        //System.out.println("length of max subarray " + contiguousArray.findMaxLength(new int[]{1,1,1,1,1,1,1,1}));
        System.out.println("length of max subarray " + contiguousArray.findMaxLength(new int[]{0,1,1,0,1,1,1,0}));
        System.out.println("length of max subarray " + contiguousArray.findMaxLength(new int[]{0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1}));
    }
}
