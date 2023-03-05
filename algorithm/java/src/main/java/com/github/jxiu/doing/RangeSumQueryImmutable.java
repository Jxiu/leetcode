package com.github.jxiu.doing;

import java.util.*;

public class RangeSumQueryImmutable {

    public static class NumArray {
        private List<Integer> sumList;
        public NumArray(int[] nums) {
            if (nums == null){
                sumList = Collections.emptyList();
            }
            System.out.println(Arrays.toString(nums));
            sumList = new ArrayList<>();
            int sum = 0;
            sumList.add(sum);
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                sumList.add(sum);
            }
            System.out.println(sumList);
        }

        public int sumRange(int left, int right) {
            return sumList.get(right+1)-sumList.get(left);
        }
    }

    public static class NumArray1 {
        private Map<Integer,Map<Integer,Integer>> sumMap;

        public NumArray1(int[] nums) {
            if (nums == null || nums.length == 0){
                sumMap = new HashMap<>(2);
            }
            sumMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length-1; i++) {
                 sumMap.put(i,new HashMap<>());
                for (int j = i+1; j < nums.length; j++) {
                    Integer prevSum = sumMap.get(i).get(j-1);
                    if (prevSum == null){
                        prevSum = nums[i];
                    }
                    sumMap.get(i).put(j,prevSum + nums[j]);
                }
            }
            System.out.println(sumMap);
        }

        public int sumRange(int left, int right) {
            return sumMap.get(left) == null ? 0 : sumMap.get(left).get(right);
        }
    }
}
