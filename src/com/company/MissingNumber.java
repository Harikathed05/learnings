package com.company;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n*(n+1))/2;
        int sumNums = 0;
        for (int i = 0; i < nums.length; i++) {
            sumNums += nums[i];
        }
        return sum - sumNums;
    }
}
