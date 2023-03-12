package com.github.jxiu.doing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 697. Degree of an Array
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        int max = 0;
        HashMap<Integer,int[]> degreeMap = new HashMap();
        ArrayList<Integer> maxSet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] arr = degreeMap.get(nums[i]);
            if (arr == null){
                arr = new int[]{1, i, i};// 频率，第一次出现位置，最后一次出现位置
                degreeMap.put(nums[i], arr);
            }else {
                arr[0] = arr[0] + 1;
                arr[2] = i;
            }
            if (max < arr[0]){
                max = arr[0];
                maxSet.clear();
                maxSet.add(nums[i]);
            }else if (max == arr[0]){
                maxSet.add(nums[i]);
            }
        }
        int minLen = 0;
        boolean init = false;
        for (int i : maxSet){
            int[] arr = degreeMap.get(i);
            if (init){
                minLen = Integer.min(arr[2] - arr[1], minLen);
            }else {
                minLen = arr[2] - arr[1];
                init = true;
            }
        }
        return minLen + 1;
    }
}
