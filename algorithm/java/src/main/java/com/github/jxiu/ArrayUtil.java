package com.github.jxiu;

public class ArrayUtil {

    private ArrayUtil(){}

    /**
     * 打印二维矩阵
     */
    public static void printMatrix(int[][] matrix){
        int N = matrix.length, L = N == 0 ? 0 : matrix.length;
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < N; i++) {
            sb.append("[");
            for (int j = 0; j < L; j++) {
                if (j != 0){
                    sb.append(",");
                }
                sb.append(matrix[i][j]);
            }
            sb.append("]\n");
        }

        System.out.print(sb.toString());
    }
}
