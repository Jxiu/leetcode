package com.github.jxiu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 */
public class MaxPointsOnALine {

    /**
     * 等价于计算斜率相等的点做多多少个
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int maxCount = 1,same, samey;
        HashMap<Double,Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            same = 0; // 重复点
            samey = 1; // 斜率不存在
            for (int j = i+1 ; j < points.length ; j++) { // 前面的点已经计算过了
                // 计算斜率
                if (points[i][1]==points[j][1]){ // 斜率不存在
                    samey++;
                    if (points[i][0]==points[j][0]){
                        // 重复点
                        same++;
                    }
                }else {
                    double dx = points[i][0]-points[j][0];
                    double dy = points[i][1]-points[j][1]; // 可能等于0
                    double dxy = dx/dy;
                    Integer sameCount;
                    if ((sameCount = map.get(dxy)) == null){
                        map.put(dxy, 2);
                    }else {
                        map.put(dxy, sameCount+1);
                    }
                }
            }
            // 计算对于这个点的最大值
            maxCount = Integer.max(samey, maxCount);
            // 遍历所有经过改点的斜率最大值
            for (Map.Entry<Double, Integer> e: map.entrySet()){
                maxCount = Integer.max(maxCount , same + e.getValue());
            }
            // 清空斜率表
            System.out.println(Arrays.toString(points[i]) + ":" + map);
            map.clear();
        }
        return maxCount;
    }
}
