package com.github.jxiu;

import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        // 先找到最先出现的最大值下标
        int maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx]){
                maxIdx = i;
            }
        }
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[nums.length];
        for (int i = maxIdx+nums.length; i > maxIdx; i--) {
            int ai = i%nums.length; // 数组中的坐标
            // 维护一个单调的递增的栈
            while(!stk.isEmpty() && nums[ai] >= stk.peek()){
                // 栈不满足单调递增，弹出所有小于等于当前元素的栈
                stk.pop();
            }
            // 计算出
//            ans[ai] = stk.empty() ? -1 : Math.abs(stk.peek() - i);
            ans[ai] =  stk.empty() ? -1 : stk.peek();
            //推入当前元素
            stk.push(nums[ai]);
            System.out.println(stk);
            // 重新计算最大值之后的元素
        }
        return  ans;
    }
}
