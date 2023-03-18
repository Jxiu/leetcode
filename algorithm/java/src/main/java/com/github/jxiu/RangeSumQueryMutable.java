package com.github.jxiu;

import java.util.Arrays;

/**
 * 307. 区域和检索 - 数组可修改
 */
public class RangeSumQueryMutable {

    // TODO 用线段树实现

    static class NumArray {
        private int[] sumArr;
        public NumArray(int[] nums) {
            sumArr = new int[nums.length+1];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sumArr[i+1] = (sum);
            }
            System.out.println(Arrays.toString(sumArr));
        }

        public void update(int index, int val) {
            // 更新坐标重新计算
            int old = sumArr[index+1] - sumArr[index];
            int j = val - old;
            for (int i= index+1; i < sumArr.length; i ++){
                sumArr[i] = sumArr[i] + j;
            }
        }

        public int sumRange(int left, int right) {
            return sumArr[right+1] - sumArr[left];
        }
    }
}
