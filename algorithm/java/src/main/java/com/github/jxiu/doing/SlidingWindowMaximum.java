package com.github.jxiu.doing;

import java.util.*;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        // TODO
//        ArrayDeque<Integer> deque = new ArrayDeque();
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!deque.isEmpty() && deque.getFirst() )
//        }
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 做一个长度为k的最大值优先队列
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt((Integer i) -> i).reversed());
        int[] ans = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            if (maxHeap.size() == k){
                // 取出最大值
                ans[i+1-k] = maxHeap.peek();
                maxHeap.remove(nums[i+1-k]);
            }
        }
        return ans;
    }
}
