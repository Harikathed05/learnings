package com.company;

import java.util.HashMap;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class CoinChange {
    int amount = 0;
    public int  runDfs(int index, int a) {
        HashMap<Integer, Integer> hashMapCoinAmount =  new HashMap();
        if (a == amount) {
            return amount;
        }
        if(a > amount) {
            return 0;
        }
        if(hashMapCoinAmount.containsKey(index)) {
            return hashMapCoinAmount.get(index);
        }

       // int newAmount = runDfs(index, amount + hashMapCoinAmount.)
         //       hashMapCoinAmount.put(index, )
        return 0;
    }

}
