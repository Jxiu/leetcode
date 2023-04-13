package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @ParameterizedTest
    @MethodSource("test")
    public void test(int[] coins, int amount, int excepted){
        Assertions.assertEquals(
                excepted, new CoinChange().coinChange(coins,amount)
        );
    }

    static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(new int[] {2, 5},11, -1),
                Arguments.of(new int[] {1, 2},11, 6),
                Arguments.of(new int[] {1, 2, 5},11, 3)
        );
    }

}