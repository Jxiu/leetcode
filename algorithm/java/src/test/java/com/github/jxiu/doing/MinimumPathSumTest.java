package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumPathSumTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(int[][] in, int expected){
        MinimumPathSum issue = new MinimumPathSum();

        int out = issue.minPathSum(in);

        Assertions.assertEquals(expected, out);
    }

    static Stream<Arguments> successTest(){
        return Stream.of(
                Arguments.of(new int[][]{{1,3,1},{1,5,1},{4,2,1}},11)
        );
    }

}