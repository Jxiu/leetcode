package com.github.jxiu.doing;

/**
 * 72.编辑距离（hard）
 * TODO 复习
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // 表示将第一个字符串到位置 i 为止，和第二个字符串到位置 j 为止，最多需要几步编辑。
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if (i == 0){
                    dp[i][j] = j;
                }else if(j==0) {
                    dp[i][j] = i;
                }else {
                    dp[i][j] = Integer.min(
                            // 两个位置的字符相等 则无需增加编辑次数
                            dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1)?0:1),
                            // 当二者对应的字符不同时，修改的消耗是 dp[i-1][j-1]+1，插入 i 位置/删除 j 位置
                            //的消耗是 dp[i][j-1] + 1，插入 j 位置/删除 i 位置的消耗是 dp[i-1][j] + 1
                            Integer.min(dp[i-1][j]+1,dp[i][j-1]+1)
                            );
                }
            }
        }
        return dp[m][n];
    }
}
