package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMaximumTest {

    @Test
    public void successTest(){
        SlidingWindowMaximum issue = new SlidingWindowMaximum();
        int[] actual = issue.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        Assertions.assertArrayEquals(new int[]{3,3,5,5,6,7}, actual);
    }

}