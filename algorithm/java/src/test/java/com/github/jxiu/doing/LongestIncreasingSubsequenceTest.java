package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(int[] in, int expected){
        Assertions.assertEquals(
                expected, new LongestIncreasingSubsequence().lengthOfLIS(in)
        );
    }

    static Stream<Arguments> successTest(){
        return Stream.of(Arguments.of(new int[]{10,9,2,5,3,7,101,18},4));
    }
}