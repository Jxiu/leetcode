package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestHarmoniousSubsequenceTest {


    @ParameterizedTest
    @MethodSource
    public void successTest(int[] in, int expected){
        LongestHarmoniousSubsequence issue = new LongestHarmoniousSubsequence();
        int out = issue.findLHS(in);
        Assertions.assertEquals(expected, out);
    }

    static Stream<Arguments> successTest(){
        return Stream.of(
                Arguments.of(new int[]{1,3,2,2,5,2,3,7},5),
                Arguments.of(new int[]{1,2,3,4},2),
                Arguments.of(new int[]{1,1,1,1},0)
        );
    }
}