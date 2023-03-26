package com.github.jxiu.doing;

import java.util.Arrays;

/**
 * 91. 解码方法(medium)
 * 题目数据保证答案肯定是一个 32 位 的整数。
 */
public class DecodeWays {

    /**
     * TODO 复习
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        // 给定的是一个数字串
        int n = s.length();
        if (n == 0){
            return 0;
        }
        // 计算出字符序号
        int prev = s.charAt(0) - '0';
        // 首字母是 0，无法解析 因为A-Z解析是1-26
        if (prev == 0 ) return 0;
        if (n==1) return 1;
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            // 默认只有一种解法
            dp[i] = 1;
        }
        for (int i = 2; i <= n ; i++) {
            // 当前数组
            int cur = s.charAt(i-1)- '0';
            if ((prev == 0 || prev > 2) && cur == 0){
                // 没有解法， 0只能前一个数字搭配
                // 如果是不是 10 20  即和前一个数组拼凑出的数 小于 1 或者 大于26
                return 0;
            }
            if ((prev == 1) || (prev == 2 && cur < 7)){
                // 10-26
                if (cur == 0){
                    // 10 或 20 只能凑成一对
                    dp[i] = dp[i-2];
                }else {
                    // 否则等于 前一个数字解法 + 前两个数组解法
                    dp[i] = dp[i-2] + dp[i-1];
                }
            }else {
                // 只能拆成带个数字
                //1-10 只有一种解法，解法不会新增
                dp[i] = dp[i-1];
            }
            prev = cur;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }


    public int numDecodings_i(String s) {
    assert s != null;
    // 0,3-9
    // 1,2
    // 可以解码次数
    int[] dp = new int[s.length()];
    dp[0] = 1;
    for (int i = 1; i < s.length(); i++) {
        char c = s.charAt(i);
        char pc = s.charAt(i);
        // 两数字可以组成一个单词
        if (pc == '1'){
            dp[i] = dp[i] + 1;
        }else if (pc == '2'){

        }else {
            // 不能和前面一个数字凑成一个单词
            dp[i] = dp[i-1] + 1;
        }
    }
    return dp[s.length() -1];
}
}
