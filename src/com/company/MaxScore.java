package com.company;

/**
 * Givven an array of size N, return max sum of K elements either from start or end or both but not by disturbing
 * the sequence in which the elements occur.
 *
 * arr 1, 5, 3, -2, 1000, -10
 *
 * K = 3
 */
public class MaxScore {
    private int maxSumOfKElements(int k, final int[] cardPoints, final int startIndex) {
        int tempIndex  = startIndex;
        int sum  = 0;
        while (k != 0) {
            if (tempIndex < cardPoints.length) {
                sum = sum + cardPoints[tempIndex];
                //System.out.println("when cardpoint is more sum is " + sum + " for tempIndex " + tempIndex);
            }
            else {
                sum =  sum + cardPoints[tempIndex - cardPoints.length];
                //System.out.println("when cardpoint is less sum is " + sum + " for tempIndex - cardPoints.length] " + (tempIndex - cardPoints.length));
            }
            k--;
            tempIndex ++;
        }
        return sum;
    }

    public int maxiScore(final int[] cardPoints, final int k) {
        int max = 0;
        for(int i = 0; i < cardPoints.length; i++) {
            int tempMax = maxSumOfKElements(k, cardPoints, i);
            System.out.println("maxSumOfKElements when i is " + i + " sum is " + tempMax + " k is " + k);
            if(tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }
    public static void main(String args[]) {
        //int [] cardPoints = new int[]{2,7,4,1,8,1};
        //int [] cardPoints = new int[]{1,2,3,4,5,6,1};
        //int [] cardPoints = new int[]{1, 5, 3, -2, 1000, -10};
        //int [] cardPoints = new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20};
        int [] cardPoints = new int[]{5, 10, 2, 9, 11};
        MaxScore maxScore = new MaxScore();
        System.out.println(maxScore.maxiScore(cardPoints, 3));
    }
}
