package com.github.jxiu.doing;

/**
 * 413. 等差数列划分
 */
public class ArithmeticSlices {


    public int numberOfArithmeticSlices(int[] nums) {
        // 1    0
        // 1 2  0
        // 1 2 3   1
        // 1 2 3 4  3
        // 1 2 3 4 5  6

        // 1 2 3 4 5 6 4  6
        // 1 2 3 4 5 6 4 2  7
        // 1 2 3 4 5 6 4 2 0 9

        if (nums.length < 3){
            return 0;
        }
        int[] dp = new int[nums.length];
        int d1,d2; // 第二个到最新一个差，第三个到第二个差
        int startIdx = -1;
        for (int i = 2; i < nums.length; i++) {
            d1 = nums[i] - nums[i-1];
            d2 = nums[i-1] - nums[i-2];
            if (d1 == d2){
                // 等差数列第一次
                if (startIdx < 0){
                    // 以前的次数+最新的次数
                    dp[i] = dp[i-1] + 1;
                    startIdx = i; // 连续数组开始的下标
                } else {
                    // 计算连续序列的个数
                        dp[i] = dp[i-1] + 1 + (i - startIdx);
                    }
            }else{
                // 不是等差数列
                // 继承前个节点的个数
                dp[i] = dp[i - 1];
                // 重置
                if (startIdx > 0){
                    startIdx = -1;
                }
            }
        }
        return dp[nums.length -1];
    }
}
