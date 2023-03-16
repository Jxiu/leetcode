package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvantageShuffleTest {


    @Test
    public static void main(String[] args) {
        AdvantageShuffle issue = new AdvantageShuffle();
        Assertions.assertArrayEquals(new int[]{2,11,7,15},issue.advantageCount(new int[]{2,11,7,15}, new int[]{1,10,4,11}));
        Assertions.assertArrayEquals(new int[]{24,32,8,12},issue.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11}));
    }
}