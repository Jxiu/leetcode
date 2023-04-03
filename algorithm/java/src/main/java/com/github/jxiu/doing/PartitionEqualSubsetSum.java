package com.github.jxiu.doing;

import java.util.Arrays;

/**
 * 416. 分割等和子集(medium)
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition_better(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum /2; // 能凑出一般则另一半必定存在
        boolean dp[] = new boolean[target+1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j>=nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
            System.out.println("i: " + i + ","+ nums[i-1]+", "+ Arrays.toString(dp));
        }
        return dp[target];
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum/2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target ; j++) {
                //  从1开始判断和是否可以有当前元素凑出来
                if (j < nums[i-1]){
                    //和不能有当前元素凑成（因为小于当前元素）
                    // 和就等于没有当前元素是否能凑出
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 和可以有当前元素凑成
                    // dp[i-1][j] = 没有当当前元素是否能凑出和（默认false）
                    // dp[i-1][j-nums[i-1]] = （当前和-减去当前元素）的元素和是否能凑出（一直减到0肯定是存在）
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][target];
    }
}
