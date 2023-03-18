package com.github.jxiu;

import java.util.Arrays;

public class RotateImage {

    // TODO 复习
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1, temp=0;
        // 只需要遍历四分之一的格子
        for (int i = 0; i <= n/2; ++i) { // 行
            // 遍历过的外圈不需要重复遍历 j是从I开始
            for (int j = i; j < n-i; ++j) { // 列
                //(0,1) -->  temp
                //(2,0) --> (0,1)
                //(3,2) --> (2,0)
                //(1,3) --> (3,2)
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = temp;
            }
        }
    }

    public void printMatrix(int[][] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println("-----");
    }
}
