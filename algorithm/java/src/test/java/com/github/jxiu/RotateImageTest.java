package com.github.jxiu;

import com.github.jxiu.RotateImage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RotateImageTest {

    @ParameterizedTest
    @MethodSource
    public void success_test(int[][] in, int[][] out){
        RotateImage issue = new RotateImage();
        issue.rotate(in);
        issue.printMatrix(in);
        Assertions.assertArrayEquals(out, in);
    }

    static Stream<Arguments> success_test(){
        int[][] input3 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] output3 = {{7,4,1},{8,5,2},{9,6,3}};
        return Stream.of(Arguments.of(input3, output3));
    }
}