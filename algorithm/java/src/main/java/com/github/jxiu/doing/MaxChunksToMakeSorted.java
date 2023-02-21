package com.github.jxiu.doing;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, max = 0, count = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i],max);
            if (max == i){
                count++;
            }
        }
        return count;
    }
}
