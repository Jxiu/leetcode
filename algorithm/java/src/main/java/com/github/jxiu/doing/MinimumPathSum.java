package com.github.jxiu.doing;

/**
 * 64. Minimum Path Sum(medium) 最小路径和
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        // 数组中数字都是非负数，初始化dp数组
        int N = grid.length; int IN = N == 0 ? 0 : grid[0].length;
        // 多初始化一层右上角默认都是0
        int[][] dp = new int[N+1][IN+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < IN; j++) {
                // 最上边
                dp[i][j] = Integer.min(dp[i][j+1], dp[i+1][j]) + grid[i][j];
            }
        }
        return dp[N+1][IN+1];
    }
}
