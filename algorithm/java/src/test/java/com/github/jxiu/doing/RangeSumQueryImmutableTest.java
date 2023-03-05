package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeSumQueryImmutableTest {

    @Test
    public void successTest(){
        RangeSumQueryImmutable.NumArray numArray = new RangeSumQueryImmutable.NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        Assertions.assertEquals(numArray.sumRange(0,2),1);
        Assertions.assertEquals(numArray.sumRange(0,5),-3);
        Assertions.assertEquals(numArray.sumRange(2,5),-1);
    }

}