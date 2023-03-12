package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NextGreaterElementIITest {

    @ParameterizedTest
    @MethodSource
    public void testSuccess(int[] in, int[] expected){
        NextGreaterElementII issue = new NextGreaterElementII();
        int[] out = issue.nextGreaterElements(in);
        System.out.println("out:" + Arrays.toString(out));
        Assertions.assertArrayEquals(expected, out);
    }

    static Stream<Arguments> testSuccess(){
        return Stream.of(
                Arguments.of(new int[]{1,2,1}, new int[]{2,-1,2}),
                Arguments.of(new int[]{1,2,3,4,3}, new int[]{2,3,4,-1,4})
        );
    }

}