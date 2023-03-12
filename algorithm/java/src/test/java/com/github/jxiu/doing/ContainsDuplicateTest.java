package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(int[] in, boolean expected){
        ContainsDuplicate issue = new ContainsDuplicate();
        Assertions.assertEquals(expected, issue.containsDuplicate(in));
    }

    static Stream<Arguments> successTest(){
        return Stream.of(
                Arguments.of(new int[]{1,2},false),
                Arguments.of(new int[]{1,2,3,1},true),
                Arguments.of(new int[]{1,2,3,4},false),
                Arguments.of(new int[]{1,1,1,3,3,4,3,2,4,2},true)
        );
    }
}