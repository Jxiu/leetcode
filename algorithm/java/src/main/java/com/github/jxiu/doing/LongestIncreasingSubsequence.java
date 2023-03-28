package com.github.jxiu.doing;

import java.util.Arrays;

/**
 * 300. 最长递增子序列(medium)
 */
public class LongestIncreasingSubsequence {

    //10,9,2,4,5,3,7,101,18
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                // 遍历之前都比自己小的中 最大的升序次数
                if (nums[i] > nums[j]){
                    dp[i] = Integer.max(dp[j] +1, dp[i]);
                }
            }
            max = Integer.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
