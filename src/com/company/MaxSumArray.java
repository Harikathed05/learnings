package com.company;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSumArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int currentPrefixSum = 0;
        int maxProfit = nums[0];
        for (int i  = 0; i < nums.length; i++) {
            currentPrefixSum += nums[i];
            if (currentPrefixSum < nums[i]) {
                currentPrefixSum = nums[i];
            }
            if (maxProfit < currentPrefixSum) {
                maxProfit = currentPrefixSum;
            }
        }
        return maxProfit ;
    }
}
