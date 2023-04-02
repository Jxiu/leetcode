package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuyAndSellStockTest {


    @ParameterizedTest
    @MethodSource
    public void test(int[] in,int expected){
        Assertions.assertEquals(expected, new BestTimeToBuyAndSellStock().maxProfit(in));
    }

    static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(new int[]{7,1,5,3,6,4}, 5)
        );
    }
}