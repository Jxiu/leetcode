package com.github.jxiu;

import com.github.jxiu.DailyTemperatures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DailyTemperaturesTest {

    @Test
    public void successTest(){
        DailyTemperatures issue = new DailyTemperatures();
        int[] in = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] out = issue.dailyTemperatures(in);
        Assertions.assertArrayEquals(out, new int[]{ 1, 1, 4, 2, 1, 1, 0, 0});
    }
}