package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeSumQueryMutableTest {

    @Test
    public void successTest(){
        RangeSumQueryMutable.NumArray issue = new RangeSumQueryMutable.NumArray(new int[]{1, 3, 5});
        Assertions.assertEquals(9,issue.sumRange(0,2));
        issue.update(1,2);
        Assertions.assertEquals(8,issue.sumRange(0,2));

    }

}