package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(int[] in){
        int[] copy = Arrays.copyOf(in, in.length);
        Arrays.sort(in);
        new QuickSort().sort(copy);
        Assertions.assertArrayEquals(in , copy);
    }

    static Stream<Arguments> successTest(){
        return Stream.of(Arguments.of(new int[]{1, 4 ,2 ,10 ,5 }));
    }
}