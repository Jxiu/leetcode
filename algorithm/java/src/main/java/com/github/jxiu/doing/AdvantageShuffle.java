package com.github.jxiu.doing;

import java.util.*;
import java.util.PriorityQueue;

/**
 * 870. 优势洗牌(medium)
 */
public class AdvantageShuffle {

    /**
     *  找到比当前数字大的最小的数字
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> tset= new TreeSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : nums1){
            // 统计次数
            map.put(x, map.getOrDefault(x,0) +1);
            if (map.get(x)== 1) {
                tset.add(x);//第一次添加到红黑树
            }
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < n; i++) {
            Integer cur = tset.ceiling(nums2[i] + 1); // 如果元素不存在则用最接近的元素
            if (cur == null){
                // 不存在比当前元素大的
                cur = tset.ceiling(Integer.MIN_VALUE); //取最小的元素
            }
            System.out.println(i);
            ans[i] = cur;
            map.put(cur, map.get(cur) -1);
            if (map.get(cur) == 0){
                tset.remove(cur); // 移除不存在元素
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

//    public int[] advantageCount(int[] nums1, int[] nums2) {
//        // 题目数组长度相等
//        int[] ans = new int[nums1.length];
//        // 构建最小堆
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        for (int num : nums1){
//            q.add(num);
//        }
//        // 找到比当前数字大的最小的数字
//        for (int i = 0; i < nums2.length; i++) {
//            while (!q.isEmpty()){
//                Integer min = q.peek();
//                if (min > )
//            }
//        }
//    }
}
