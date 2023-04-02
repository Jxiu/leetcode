package com.github.jxiu.doing;

import com.github.jxiu.ArrayUtil;

/**
 * 0-1背包问题
 */
public class ZeroOnePack {

    // 优化去掉一个维度
    public int knapsack_better(int[] weights,int[] values, int N, int W){
        // 只能一定重量时候最大价值
        int[] dp = new int[W+1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i-1];
            int v = values[i-1];
            // 新增一件物品后最大价值变换
            for (int j = W; j >= w ; j--) {
                dp[j] = Integer.max(dp[j],dp[j-w]+v);
            }
        }
        return dp[W];
    }


        /**
         *
         * @param weights
         * @param values
         * @param N N件物品
         * @param W 最大重量
         * @return
         */
    public int knapsack(int[] weights,int[] values, int N, int W){
        // N件物品重量上限为W时候的最大价值
        // 最简单：一件物品重量上限为1的时候的最大价值
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i <= N; i++) {
            // 一次遍历代表一件物品在范围内的最大价值
            // 第一次：第一件物品在不同重量限制下的最大价值（最大W）
            // 第二次：前两件物品在不同重量限制下的最大价值
            int w = weights[i-1];
            int v = values[i-1];
            for (int j = 1; j <= W; j++) {
                if (j>=w){
                    // 空间足够放下一件新的物品
                    // 新的最大价值 = 没有这件物品的最大价值和有这件物品的新价值中较大的一个
                    // 新价值 = 减去新物品最大重量后的最大价值 +　新物品的价值
                    dp[i][j] = Integer.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else {
                    // 空间不够，无法添加新的物品，价值还是之前的最大价值
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        ArrayUtil.printMatrix(dp);
            return dp[N][W];
    }
}
