package com.github.jxiu.doing;

import java.util.ArrayList;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!indices.isEmpty()){
                int pre_idx = indices.peek();
                if (temperatures[i] <= temperatures[pre_idx]){
                    // 没有升温
                    break;
                }
                // 找到所有遍历过还没升温的天气
                // 升温
                indices.pop();
                ans[pre_idx] = i - pre_idx;
            }
            // 记录天数
            indices.push(i);
            System.out.println(i  + ": " + temperatures[i]);

            System.out.println(indices);
        }
        return ans;
    }
}
