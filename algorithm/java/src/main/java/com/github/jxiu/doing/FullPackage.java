package com.github.jxiu.doing;

import com.github.jxiu.ArrayUtil;

/**
 * 完全背包问题,N中物品 每一种重量weights[n],价值values[n]
 * tips：好像可以计算密度然后贪心算法
 */
public class FullPackage {

    public int knapsack_better(int[] weights,int[] values,int N,int W){
        int[] dp = new int[W+1];
        for (int i = 0; i < N; i++) {
            // 第i个物品的重量
            int w = weights[i];
            // 第i个物品的价值
            int v = values[i];
            for (int j = w; j <= W; j++) {
                dp[j] = Integer.max(dp[j], dp[j-w]+v);
            }
        }
        return dp[W];
    }

    /**
     *  TODO 这个答案好像是错误的！！！
     * @param weights
     * @param values
     * @param N
     * @param W
     * @return
     */
    public int knapsack(int[] weights,int[] values,int N,int W){
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i <= N; i++) {
            // 第i个物品的重量
            int w = weights[i-1];
            // 第i个物品的价值
            int v = values[i-1];
            for (int j = 1; j <=W; j++) {
                // 不断地扩大装量限制
                if (j>=w){
                    // 重量限制至少能装下一件当前物品
                    // 新的最大重量 = 没有放进这个物品的最大重量 和 （（存在这件物品后放进背包的最大重量-当前物品的重量）的最大价值 + 当前价值中）的较大值
                    // 注意0，1背包问题是放了<<不存在当前物品时候>>当前重量-当前物品重量的最大价值 + 当前物品的价值
                    dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-w]+v);
                }else {
                    // 重量限制完全不能装下当前物品
                    // 价值只能等于只有前面那些物品的最大价值
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        ArrayUtil.printMatrix(dp);
        return dp[N][W];
    }
}
