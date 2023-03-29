package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {


    @ParameterizedTest
    @MethodSource
    public void testSuccess(String in1,String in2, int expected){
        Assertions.assertEquals(expected, new LongestCommonSubsequence().longestCommonSubsequence(in1,in2));
    }

    static Stream<Arguments> testSuccess(){
        return Stream.of(
                Arguments.of("abc","a1bc1ce",3),
                Arguments.of("aaa","11aa1ba",3)
        );
    }
}