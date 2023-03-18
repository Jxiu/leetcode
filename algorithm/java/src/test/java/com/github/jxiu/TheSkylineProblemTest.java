package com.github.jxiu;

import com.github.jxiu.TheSkylineProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TheSkylineProblemTest {

    @Test
    public void successTest(){
        TheSkylineProblem problem = new TheSkylineProblem();
        int[][] in = { {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        List<List<Integer>> out = problem.getSkyline1(in);
        Assertions.assertTrue(out != null && !out.isEmpty());
        System.out.println(out);
    }

}