package com.github.jxiu;

/**
 * 566.重塑矩阵
 */
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // mat not null
        int row = mat.length, col = mat[0].length;
        if ((row == r && col == c) || (row*col != r*c)){
            return mat;
        }
        int[][] ans = new int[r][c];
        // 个数
        int count = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count++;
                ans[(count)/c][(count)%c]=mat[i][j];
            }
        }
        return ans;
    }
}
