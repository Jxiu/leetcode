package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ZeroOneMatrixTest {

    @ParameterizedTest
    @MethodSource
    public void testSuccess(int[][] in, int[][] expected){
        ZeroOneMatrix problem = new ZeroOneMatrix();
        Assertions.assertArrayEquals(expected,problem.updateMatrix(in));
    }

    static Stream<Arguments> testSuccess(){
        return Stream.of(
                Arguments.of(new int[][]{{0,0,0},{0,1,0},{0,0,0}}, new int[][]{{0,0,0},{0,1,0},{0,0,0}}),
                Arguments.of(new int[][]{{0,0,0},{0,1,0},{1,1,1}}, new int[][]{{0,0,0},{0,1,0},{1,2,1}})
        );
    }}