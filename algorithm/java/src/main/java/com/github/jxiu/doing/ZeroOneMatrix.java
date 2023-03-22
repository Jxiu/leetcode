package com.github.jxiu.doing;

import com.github.jxiu.ArrayUtil;

/**
 * 542. 01 矩阵(medium)
 * mat 中至少有一个 0
 */
public class ZeroOneMatrix {

    /**
     * 四个方向搜索
     * @param mat
     */
    public int[][] updateMatrix(int[][] mat) {
        int N = mat.length; int L = N == 0 ? 0 : mat[0].length;
        int[][] dp = new int[N][L];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                dp[i][j] = Integer.MAX_VALUE - 1;
            }
        }
        ArrayUtil.printMatrix(dp);
        // 正向动态规划
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
               if (mat[i][j] == 0){
                   dp[i][j] = 0;
               }else {
                   if (j > 0){
                       dp[i][j] = Integer.min(dp[i][j],dp[i][j-1] +1);
                   }
                   if (i > 0){
                       dp[i][j] = Integer.min(dp[i][j],dp[i-1][j] +1);
                   }
               }
            }
        }
        ArrayUtil.printMatrix(dp);
        // 反向动态规划
        for (int i = N-1; i >=0 ; i--) {
            for (int j = L-1; j >=0 ; j--) {
                if (mat[i][j] != 0){
                    // 更新距离
                    if (j < L-1){
                        dp[i][j] = Integer.min(dp[i][j],dp[i][j+1] +1);
                    }
                    if (i < N -1){
                        dp[i][j] = Integer.min(dp[i][j],dp[i+1][j] +1);
                    }
                }
            }
        }
        ArrayUtil.printMatrix(dp);
        return dp;
    }


        public int[][] updateMatrix_i(int[][] mat) {
        int N = mat.length; int L = N == 0 ? 0 : mat[0].length;
        int[][] dp = new int[N][L];
        // 顺着左上方向递归，在右下遇到0更新（距离）
        // 矩阵中至少存在一个0
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                // 判断当前格子=0
                if (mat[i][j] == 0){
                    dp[i][j] = 0;
                    // 反向搜索更新 两点之间直线最短

                }else {
                    if (i == 0 && j ==0){
                        dp[i][j] = 1;
                    }else if( i == 0) {
                        dp[i][j] = dp[i][j=1] + 1;
                    }else if (j == 0) {
                        dp[i][j] = dp[j][i-1] + 1;
                    }else {
                        // 更新格子为左上两个方向最小+1
                        dp[i][j] = Integer.min(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp;
    }


}
