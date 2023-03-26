package com.github.jxiu.doing;

import java.util.Arrays;

/**
 * 单轴快排
 */
public class QuickSort {

    // TODO　debug
    public void sort(int[] arr){
        if (arr == null || arr.length <= 1) return;
        qucikSort(arr, 0, arr.length-1);
    }

    private void qucikSort(int[] a, int lo, int hi) {
        // 如果分割后长度等于1，则表示排序完成
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        // 分别最两部分进行排序
        qucikSort(a, lo, j-1);
        qucikSort(a, j+1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        // 选择随机数
        int i = lo,  j = hi +1;
        int v = a[lo];
        // [8,1,-1,4,3,2,5]
        // 将数组分成大于随机数和小于随机数的两部分
        while (true){
            while (a[++i] < v){
                if (i == hi) break;
            }
            while (v < a[--j]){
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        System.out.println(Arrays.toString(a));
        return j;
    }

    private static void swap(int[] arr, int li, int hi) {
        int temp = arr[hi];
        arr[hi] = arr[li];
        arr[li] = temp;
    }
}
