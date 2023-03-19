package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    public void successTest(){
        int[] in = new int[]{2,7,9,3,1};
        HouseRobber issue = new HouseRobber();

        int out = issue.rob(in);

        Assertions.assertEquals(12,out);
    }

}