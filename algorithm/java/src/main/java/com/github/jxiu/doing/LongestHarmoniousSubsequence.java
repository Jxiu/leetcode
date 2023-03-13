package com.github.jxiu.doing;

import java.util.HashMap;
import java.util.Map;

/**
 * 594.最长的和谐子序列
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int lhs = 0;
        // 统计出现频率
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.computeIfPresent(num, ((k, v) -> v + 1));
            map.putIfAbsent(num, 1);
        }
        System.out.println(map);
        // 遍历所有次数最高元素，能否找到元素的上一个元素
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer next, k = e.getKey(), v = e.getValue();
            next = map.get(k + 1);
            if (next != null) {
                lhs = Integer.max(v + next, lhs);
            }
        }
        return lhs;
    }
}
