package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    @Test
    public void successTest(){
        LongestConsecutiveSequence issue = new LongestConsecutiveSequence();
        int excepted = issue.longestConsecutive(new int[]{100,4,200,1,3,2});
        Assertions.assertEquals(4, excepted);
        excepted = issue.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        Assertions.assertEquals(9, excepted);
    }

}