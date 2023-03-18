package com.github.jxiu;

import com.github.jxiu.ReshapeTheMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReshapeTheMatrixTest {

    @Test
    public void successTest(){
        ReshapeTheMatrix issue = new ReshapeTheMatrix();
        int[][] in = new int[][]{{1,2},{3,4}};
        Assertions.assertArrayEquals(new int[][]{{1,2,3,4}}, issue.matrixReshape(in,1,4));
        Assertions.assertArrayEquals(new int[][]{{1},{2},{3},{4}},issue.matrixReshape(in,4,1));
        Assertions.assertArrayEquals(in,issue.matrixReshape(in,4,2));

    }

}