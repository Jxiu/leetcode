package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FullPackageTest {

    @ParameterizedTest
    @MethodSource
    public void test(int[] weight,int[] values, int N, int W, int expected){
        Assertions.assertEquals(expected, new FullPackage().knapsack(weight,values,N,W));
        Assertions.assertEquals(expected, new FullPackage().knapsack_better(weight,values,N,W));
    }

    static Stream<Arguments> test(){
        return Stream.of(
//                Arguments.of(new int[]{1,2,1},new int[]{2,2,1},1,1, 2),
                Arguments.of(new int[]{3,2,1},new int[]{9,3,1},1,2, 3),
                Arguments.of(new int[]{4,2,1},new int[]{9,3,1},1,3, 3)
//                Arguments.of(new int[]{4,2,1},new int[]{9,3,1},1,4, 9),
//                Arguments.of(new int[]{4,2,1},new int[]{9,3,1},2,4, 9),
//                Arguments.of(new int[]{1,2,1},new int[]{2,3,1},1,2, 4)
        );
    }

}