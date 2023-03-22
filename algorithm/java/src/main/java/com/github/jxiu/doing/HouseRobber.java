package com.github.jxiu.doing;

import java.util.Arrays;

/**
 * 198. 打家劫舍(easy)
 */
public class HouseRobber {

    //TODO 空间压缩
    public int rob(int[] nums) {
        // len = 1 ，max(n1,0)
        // len = 2 ，max(n1,n2)
        // len = 3 , max(max(1)+n3, max2)
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                dp[0] = nums[0];
                continue;
            }
            if (i == 1){
                dp[1] = Integer.max(nums[0],nums[1]);
                continue;
            }
            dp[i] = Integer.max(dp[i-2] + nums[i], dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length -1];

    }
}
