package com.company;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * Input: n = 1, bad = 1
 * Output: 1
 * Input: n = 5, bad = 4
 * Output: 4
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {

        int min = 1;
        int max = n;

        while(min <= max) {
            int mid = min + (max - min)/2;
            if((mid == 0)) { // if(!isBadVersion(mid)) { change if condition to commented one.
                min = mid - 1;
            }
            else {
                max = mid +1;
            }


        }
        return min;
    }

}
