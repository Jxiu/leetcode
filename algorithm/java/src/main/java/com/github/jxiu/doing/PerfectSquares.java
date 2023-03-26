package com.github.jxiu.doing;

/**
 * 279. 完全平方数
 * <br>对于分割类型题，动态规划的状态转移方程通常并不依赖相邻的位置，而是依赖于满足分割
 * 条件的位置
 */
public class PerfectSquares {

    public int numSquares(int n) {
//        Double i  = Math.sqrt(n);
//        Math.floor(i);
        // 12 3.x  12 - 9
        // 3 1.x  3 - 1
        // 2 1.x  2-1
        // 1  1
        // ---
        // 12 - 4, 8
        // 8 - 4 ,4
        // 4 - 4
        // 表示每个数最少有多少完全平方数组成
        int[] dp = new int[n+1];
        for (int i = 0; i <= n ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j * j < i ; j++) {
                // i-j*j = 找到所有能 + 一个完全平方数 = 目前数的所有数中（组成次数最小的）
                dp[i] = Integer.min(dp[i], dp[i-j*j] +1);
            }
        }

        return dp[n];
    }
}
