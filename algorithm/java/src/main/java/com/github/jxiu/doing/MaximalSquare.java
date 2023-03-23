package com.github.jxiu.doing;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * 221. 最大正方形(medium) TODO 复习
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int N = matrix.length, L = N==0?0:matrix[0].length;
        if (N == 0 || L == 0){
            return 0;
        }
        int maxSide=0;
        int[][] dp = new int[N+1][L+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                if (matrix[i-1][j-1] == '1'){
                    // 对角线每次移动会新增左上和右下两条新的边
                    // 取对角线和左上（保证左上新增的边是1）、右下角中最小的值 + 1
                    dp[i][j] = min(dp[i-1][j-1],min(dp[i-1][j],dp[j-1][i])) +1;
                }
                // 更新最大值
                maxSide = max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
