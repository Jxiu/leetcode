package com.github.jxiu.doing;

import java.util.*;
import java.util.PriorityQueue;

public class TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        int i = 0, len = buildings.length;
        int cur_x,cur_y;
        while (i < len || !maxHeap.isEmpty()){
            // int[]{x1,x2,y}
            // 最大堆的top
            if (maxHeap.isEmpty() || (i < len && buildings[i][0] < maxHeap.peek()[1])){
                cur_x = buildings[i][0];
                while (i < len && cur_x == buildings[i][0]){
                    // 添加右上角坐标 (Y,X)
                    maxHeap.add(new int[]{buildings[i][2],buildings[i][1]});
                    i++;
                }
            }else{
                cur_x = maxHeap.peek()[1];
                while(!maxHeap.isEmpty() && cur_x > maxHeap.peek()[1]){
                    maxHeap.peek();
                }
            }
            cur_y = maxHeap.isEmpty()? 0 : maxHeap.peek()[0];
            if (ans.isEmpty() || cur_y != ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(cur_x,cur_y));
            }
        }
        return ans;
    }
}
