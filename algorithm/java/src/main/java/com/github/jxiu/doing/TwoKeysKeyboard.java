package com.github.jxiu.doing;

/**
 * 650. 只有两个键的键盘 medium
 */
public class TwoKeysKeyboard {

    public int minStep_1(int n){
        int ans = 0;
        for (int i = 2; i * i < n; i++) {
            while (n%i == 0){
                n/=i;
                ans+=i;
            }
        }
        if (n > 1){
            ans += n;
        }
        System.out.println("n = " + n+",ans = " + ans);
        return ans;
    }

    public int minSteps(int n) {
        // 最少操作次数数组
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            // 1  0
            // 2  2
            // 3  3
            // 4  4
            // 5  A AA AAAAA
            // 6 A AA AAAA
            // 质数只能是n次
            // 非质数次数=组成质数次数+相乘次数
            dp[i] = i;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0){
                    dp[i] = dp[j] + dp[j/i];
                    break;
                }
            }
        }
        return dp[n];
    }
}
