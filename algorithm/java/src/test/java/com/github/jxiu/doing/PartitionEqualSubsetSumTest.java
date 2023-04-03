package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PartitionEqualSubsetSumTest {

    @ParameterizedTest
    @MethodSource
    public void test(int[] in, boolean expected){
        Assertions.assertEquals(expected, new PartitionEqualSubsetSum().canPartition(in));
        Assertions.assertEquals(expected, new PartitionEqualSubsetSum().canPartition_better(in));
    }

    static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(new int[]{1,5,11,5},true),
                Arguments.of(new int[]{1,2,3,5},false)
        );
    }


}