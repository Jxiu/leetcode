package com.github.jxiu;

public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        int n = matrix[0].length - 1;//下标最大值
        int i = 0,j = n -1;
        while (i < m && j >0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
