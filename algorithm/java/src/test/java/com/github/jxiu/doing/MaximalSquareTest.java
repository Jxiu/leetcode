package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximalSquareTest {


    @ParameterizedTest
    @MethodSource
    public void successTest(char[][] in, int expected){
        Assertions.assertEquals(expected, new MaximalSquare().maximalSquare(in));
    }

    static Stream<Arguments> successTest(){
        return Stream.of(
                Arguments.of(new char[][]{{'0'}},0),
                Arguments.of(new char[][]{{'0','1'},{'1','0'}},1),
                Arguments.of(new char[][]{{'0','0','1','0'},{'0','1','1','1'},{'1','1','1','1'},{'0','1','1','1'}},9),
                Arguments.of(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}},4)
        );
    }

}