package com.github.jxiu.doing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 70. 爬楼梯(easy)
 */
public class ClimbingStairs {

    /**
     * 空间优化到O(1)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        // 走到前步的方式
        int pre2 = 1;
        // 走到前一步方式
        int pre1 = 2;
        int cur = 0; //当前步数
        for (int i = 3; i <= n; i++){
            System.out.printf("i=%d : %d,%d,%d\n", i, pre2, pre1, cur);
            cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }

    public int climbStairs1(int n) {
        // 第n阶梯的方法 dp[n] = dp[n-1] + dp[n-2]
        // 即走到前两阶的方法（在走两步）+走到前一阶的方法（再走一步）
        if (n <= 2){
            return n;
        }
        // n=3
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
