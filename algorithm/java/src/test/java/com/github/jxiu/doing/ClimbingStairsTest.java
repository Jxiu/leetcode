package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(int n, int expected){
        ClimbingStairs issue = new ClimbingStairs();
        int out = issue.climbStairs(n);
        Assertions.assertEquals(expected, out);
    }


    static Stream<Arguments> successTest(){
        return Stream.of(
          Arguments.of(1,1),
          Arguments.of(2,2),
          Arguments.of(3,3),
          Arguments.of(4,5),
          Arguments.of(5,8)
        );
    }

}