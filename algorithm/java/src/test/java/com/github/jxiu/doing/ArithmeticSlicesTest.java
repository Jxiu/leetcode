package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class ArithmeticSlicesTest {

    @ParameterizedTest
    @MethodSource
    public void testSuccess(int[] in, int expected){
        ArithmeticSlices issue = new ArithmeticSlices();

        int out = issue.numberOfArithmeticSlices(in);

        Assertions.assertEquals(expected, out);
    }

    static Stream<Arguments> testSuccess(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4},3),
                Arguments.of(new int[]{1,2,3,4,5}, 6),
                Arguments.of(new int[]{1,2,3,4,5,6}, 10),
                Arguments.of(new int[]{1,2,3,4,5,6,4}, 10),
                Arguments.of(new int[]{1,2,3,4,5,6,4,2}, 11),
                Arguments.of(new int[]{1,2,3,4,5,6,4,2,0}, 13)
        );
    }
}