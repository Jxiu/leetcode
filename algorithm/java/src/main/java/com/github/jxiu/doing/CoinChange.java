package com.github.jxiu.doing;

import java.util.Arrays;

/**
 * 322. 零钱兑换（medium）
 */
public class CoinChange {
    /**
     * 这种问题为啥不直接贪心算法？
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int mod = amount, count = 0;
        int i = coins.length -1;
        while (mod != 0 && i >= 0){
            if (mod < coins[0]) return -1;
            if (mod >= coins[i]) {
                count = count + (mod/coins[i]);
                mod = mod%coins[i];
            }
            i--;
        }
        return count;
    }
}
