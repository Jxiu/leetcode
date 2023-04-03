package com.github.jxiu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OnesAndZeroesTest {


    @ParameterizedTest
    @MethodSource
    public void test(String[] ins,int limitM, int limitN, int expected){
        Assertions.assertEquals(expected, new OnesAndZeroes().findMaxForm(ins,limitM,limitN));
    }

    static Stream<Arguments> test(){
        return Stream.of(Arguments.of(new String[] {"10", "0001", "111001", "1", "0"},5,3 ,4));
    }
}