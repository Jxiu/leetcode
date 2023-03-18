package com.github.jxiu;

import com.github.jxiu.SubarraySumEqualsK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SubarraySumEqualsKTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(int[] in, int k,int n){
        SubarraySumEqualsK issue = new SubarraySumEqualsK();
        Assertions.assertEquals(n,issue.subarraySum(in,k));

    }

    static Stream<Arguments> successTest(){
        return Stream.of(
               Arguments.of(new int[]{1,1,1,1},2,3),
               Arguments.of(new int[]{1,1,2,2},4,2),
               Arguments.of(new int[]{1,1,2,-2,2,2,4},4,5),
               Arguments.of(new int[]{1,2,3},3,2)
        );
    }
}