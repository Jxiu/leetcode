package com.github.jxiu;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.PriorityQueue;

public class TheSkylineProblem {

    public List<List<Integer>> getSkyline1(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        // 转换坐标
        List<int[]> ps = new ArrayList<>();
        for (int[] b: buildings){
            ps.add(new int[]{b[0], -b[2]}); // 左端点
            ps.add(new int[]{b[1], b[2]}); // 右端点
        }
        Collections.sort(ps,Comparator.comparingInt((int[] o)-> o[0]).thenComparingInt((int[] o) -> o[1]));
        ps.forEach(Arrays::toString);
        ps.forEach(p ->{
            System.out.print(Arrays.toString(p));
        });
        System.out.println();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt((Integer o) -> o).reversed());
        int pre = 0;
        queue.add(pre);
        for (int[] p : ps){
            int x = p[0], y = p[1];
            if (y < 0){
                // 左端点
                queue.add(-y);
            }else {
                // 右端点
                queue.remove(y);
            }
            System.out.println(queue);
            int top = queue.peek();// 当前最高高度
            if (top != pre){ // 取出最高高度，如果当前不与前一矩形“上边”延展而来的那些边重合，则可以被记录
                List<Integer> e = new ArrayList<>();
                e.add(x);
                e.add(top);
                ans.add(e);
                pre = top;
            }
        }
        return ans;
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        // 优先比较y坐标，再比较x坐标
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        int i = 0, len = buildings.length;
        int cur_x,cur_y;
        while (i < len || !maxHeap.isEmpty()){
            // int[]{x1,x2,y}
            // 最大堆的top
            if (maxHeap.isEmpty() || (i < len && buildings[i][0] < maxHeap.peek()[1])){
                // 当前建筑的最左边
                cur_x = buildings[i][0];
                while (i < len && cur_x == buildings[i][0]){
                    // 添加右上角坐标 (Y,X),高度和右端
                    maxHeap.add(new int[]{buildings[i][2],buildings[i][1]});
                    i++;
                }
            }else{
                cur_x = maxHeap.peek()[1];
                while(!maxHeap.isEmpty() && cur_x >= maxHeap.peek()[1]){
                    maxHeap.poll();
                }
            }
            printHeap(maxHeap);
            cur_y = maxHeap.isEmpty()? 0 : maxHeap.peek()[0];
            if (ans.isEmpty() || cur_y != ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(cur_x,cur_y));
            }
        }
        return ans;
    }

    private void printHeap(PriorityQueue<int[]> queue){
        if (queue == null || queue.isEmpty()){
            System.out.println("[]");
        }
        queue.forEach( o ->{
            System.out.print(Arrays.toString(o)+" ");
        });
        System.out.println();

    }
}
