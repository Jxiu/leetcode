package com.github.jxiu;

import com.github.jxiu.RangeSumQuery2DImmutable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RangeSumQuery2DImmutableTest {

    @Test
    public void successTest(){
        int[][] in = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        RangeSumQuery2DImmutable.NumMatrix1 numMatrix = new RangeSumQuery2DImmutable.NumMatrix1(in);
//        Assertions.assertEquals(8,numMatrix.sumRegion(2,1,4,3));
        Assertions.assertEquals(11,numMatrix.sumRegion(1,1,2,2));
        Assertions.assertEquals(12,numMatrix.sumRegion(1,2,2,4));

    }

}