package com.github.jxiu;

import java.util.*;

/**
 * 128. 最长连续序列
 */
public class LongestConsecutiveSequence {

    /**
     * 不使用排序
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            int next = i + 1, prev = i-1, count = 1;
            while (set.contains(next)){
                set.remove(next);
                count++;
                next++;
            }
            while (set.contains(prev)){
                set.remove(prev);
                count++;
                next--;
            }
            max = max > count ? max : count;
        }
        return max;
    }

    public int longestConsecutive(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Comparator.comparingInt((Integer o)-> o).reversed());
        for (int i : nums){
            map.put(i,0);
        }
        int max = 0 ;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            Integer next =  entry.getKey() + 1;
            Integer nextCount = map.get(next);
            if (nextCount == null){
                continue;
            }
            Integer count = nextCount+1;
            map.put(entry.getKey(), count);
            if (count > max){
                max = count;
            }
        }
        return max+1;
    }
}
