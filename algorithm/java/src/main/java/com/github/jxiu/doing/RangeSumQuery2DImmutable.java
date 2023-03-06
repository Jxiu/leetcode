package com.github.jxiu.doing;


import java.util.Arrays;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class RangeSumQuery2DImmutable {

    /**
     * 优雅
     * 使用积分图
     */
    public static class NumMatrix {
        private int[][] integral ;
        public NumMatrix(int[][] matrix) {
            // 获取长度
            int m = matrix.length, n = m > 0 ? matrix[0].length :0;
            // 构造积分图
            integral = new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j<=n; j++) {
                    // 积分和 = 当前元素 + 左上角的积分和 + 右下角积分和 - 二者交集的积分和
                    integral[i][j] = matrix[i][j] + integral[i][j-1] + integral[j][i-1] - integral[i][j];
                }
            }
            Arrays.stream(integral).forEach(i ->{
                System.out.println(Arrays.toString(i));});
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 当前积分和 - 右上角和 - 左下角和 + 二者交集
            return integral[row2][col2] - integral[row1-1][col2] - integral[row2][col1-1] + integral[row1-1][col1-1];
        }
    }

    /**
     * 搜索复杂度o(n)
     */
    public static class NumMatrix1 {
        private int[][] sumMatrix ;
        public NumMatrix1(int[][] matrix) {
            // 假设输入有效
            sumMatrix = new int[matrix.length][matrix[0].length+1];
            //分别计算每个数组前n个数的和
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    sumMatrix[i][j+1] = sumMatrix[i][j] + matrix[i][j];
                }
            }
            Arrays.stream(sumMatrix).forEach(i ->{
                System.out.println(Arrays.toString(i));});
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                // 分别计算每个数组的和
                sum += sumMatrix[i][col2+1] - sumMatrix[i][col1];
            }
            return sum;
        }
    }
}
