package com.github.jxiu;

import java.util.*;

public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i : nums){
            set.add(i);
        }
        List<Integer> r = new ArrayList<>(nums.length-set.size());
        for (int i=1; i<=nums.length; i++){
            if (!set.contains(i)){
                r.add(i);
            }
        }
        return r;
    }

    /**
     * 不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题, 可以假定返回的数组不算在额外空间内。
     * [4, 3, 2, -7, 8, 2, 3, 1]
     * [4, 3, -2, -7, 8, 2, 3, 1]
     * [4, -3, -2, -7, 8, 2, 3, 1]
     * [4, -3, -2, -7, 8, 2, -3, 1]
     * [4, -3, -2, -7, 8, 2, -3, -1]
     * [4, -3, -2, -7, 8, 2, -3, -1]
     * [4, -3, -2, -7, 8, 2, -3, -1]
     * [-4, -3, -2, -7, 8, 2, -3, -1]
     *
     * 思路：将位置上的值跟数组的坐标映射，把所有重复出现的标记
     * @param nums
     * @return
     */
    public List<Integer> solution(int[] nums){

        List<Integer> result = new ArrayList<>();
        for(int num : nums){
            int idx = Math.abs(num) - 1; // 1.计算当前值的位置
            if (nums[idx] > 0) { // 3.防止重复标记，导致负数变整数
                nums[idx] = - nums[idx]; // 2. 标记当前位置，数组中当前值为负数表示
            }
            System.out.println(Arrays.toString(nums));
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){ // 过滤出重复值的位置
                result.add(i+1); // 根据位置还原缺省的数字
            }
        }
        return result;
    }
}
