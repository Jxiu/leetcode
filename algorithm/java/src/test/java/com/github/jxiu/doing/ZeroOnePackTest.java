package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ZeroOnePackTest {


    @ParameterizedTest
    @MethodSource
    public void test(int[] weight,int[] values, int W, int N, int expected){
        Assertions.assertEquals(expected, new ZeroOnePack().knapsack(weight,values,N,W));
        Assertions.assertEquals(expected, new ZeroOnePack().knapsack_better(weight,values,N,W));
    }

    static Stream<Arguments> test(){
        return Stream.of(
//                Arguments.of(new int[]{1,2,1},new int[]{2,2,2},2,1, 2),
//                Arguments.of(new int[]{1,3,1},new int[]{2,2,2},3,1, 2),
                Arguments.of(new int[]{1,2,1},new int[]{2,2,2},3,2, 4)
        );
    }
}