package com.github.jxiu;

import com.github.jxiu.DegreeOfAnArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DegreeOfAnArrayTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(int[] in, int expected){
        DegreeOfAnArray issue = new DegreeOfAnArray();
        Assertions.assertEquals(expected, issue.findShortestSubArray(in));
    }

    static Stream<Arguments> successTest(){
        return Stream.of(
                Arguments.of(new int[]{1,2,2,3,1},2),
                Arguments.of(new int[]{1,2,2,3,1,4,2},6)
                );
    }

}