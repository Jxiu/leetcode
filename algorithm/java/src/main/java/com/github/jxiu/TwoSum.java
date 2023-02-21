package com.github.jxiu;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            Integer needIdx;
            if (need == nums[i] || ((needIdx = map.get(need))== null)){
                map.put(nums[i],i);
            }else {
                result[1] = needIdx;
                result[0] = i;
                break;
            }
        }
        return result;
    }
}
