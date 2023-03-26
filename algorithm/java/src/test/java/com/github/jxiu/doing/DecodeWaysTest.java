package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(String s, int excepted){
        DecodeWays problem = new DecodeWays();
        Assertions.assertEquals(excepted, problem.numDecodings(s));
    }


    static Stream<Arguments> successTest(){
        return Stream.of(
                Arguments.of("0",0),
                Arguments.of("1",1),
                Arguments.of("10",1),
                Arguments.of("60",0),
                Arguments.of("100",0),
                Arguments.of("160",0),
                Arguments.of("110",1),
                Arguments.of("101",1),
                Arguments.of("11",2),
                Arguments.of("1111",5)
        );
    }

}