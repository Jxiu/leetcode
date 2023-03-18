package com.github.jxiu;

import com.github.jxiu.MaxPointsOnALine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxPointsOnALineTest {

    @ParameterizedTest
    @MethodSource("successParameter")
    public void successTest(int[][] in, int max){
        MaxPointsOnALine issue = new MaxPointsOnALine();
        int out = issue.maxPoints(in);
        Assertions.assertEquals(max, out);
    }

    static Stream<Arguments> successParameter(){
        return Stream.of(
                Arguments.of(new int[][]{{1,1}},1),
                Arguments.of(new int[][]{{1,1},{1,1}},2),
                Arguments.of(new int[][]{{1,1},{2,2},{3,3}},3),
                Arguments.of(new int[][]{{1,1},{1,1},{3,3}},3),
                Arguments.of(new int[][]{{4,1},{1,1},{3,2},{5,3},{2,3},{1,4}},4)
                );
    }
}