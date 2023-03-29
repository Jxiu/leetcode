package com.github.jxiu.doing;

import com.github.jxiu.ArrayUtil;

/**
 * 1143. 最长公共子序列(medium)
 */
public class LongestCommonSubsequence {

    //TODO 复习
    public int longestCommonSubsequence(String text1, String text2) {
        // a a
        // a1bc1ce abc
        // a abc       1,1,1
        // a1 abc      1,1,1
        // a1b abc    1,2,2
        // a1ba abc   1,2,2
        int m = text1.length(), n = text2.length();
        // 以建立一个二维数组 dp，其中 dp[i][j] 表示到第一个字符串位置 i 为止、到
        //第二个字符串位置 j 为止、最长的公共子序列长度。
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    // 顺序遍历到相等字母
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(text1);
        System.out.println(text2);
        ArrayUtil.printMatrix(dp);
        return dp[m][n];
    }
}
