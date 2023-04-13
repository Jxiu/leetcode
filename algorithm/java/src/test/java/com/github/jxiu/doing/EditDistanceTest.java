package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @ParameterizedTest
    @MethodSource
    public void test(String w1, String w2, int expected){
        Assertions.assertEquals(expected, new EditDistance().minDistance(w1,w2));
    }

    static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of("horse","ros",3),
                Arguments.of("intention","execution",5)
        );
    }

}