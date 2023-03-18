package com.github.jxiu;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0 ;
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + sum;
            Integer preSum = sum - k, pCount = null;
            if ((pCount = sumMap.get(preSum)) != null){
                count = count + pCount; //// 先获得前缀和为 preSum - k 的个数，加到计数变量里
            }
            sumMap.put(sum, sumMap.getOrDefault(sum,0) + 1); // 因为有负数，可以多次出现同一个和
            System.out.println(sumMap);
        }

        return count;
    }
}
