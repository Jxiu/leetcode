package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockIVTest {

    @ParameterizedTest
    @MethodSource
    public void test(int[] prices, int limit, int excepted){
        Assertions.assertEquals(excepted, new BestTimeToBuyAndSellStockIV().maxProfit(limit,prices));
    }


    static Stream<Arguments> test(){
        return Stream.of(Arguments.of(new int[]{3,2,6,5,0,3},2,7));
    }
}