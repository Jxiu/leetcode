package com.github.jxiu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoSumTest {

    @ParameterizedTest(name = "success_test")
    @MethodSource("success_test_parameter")
    public void success_test(int[] arr, int target,int[] idxArr){
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(arr, target);
        Assertions.assertEquals(2,result.length);
        Assertions.assertTrue(Arrays.stream(idxArr).boxed().collect(Collectors.toList())
                .containsAll(Arrays.stream(result).boxed().collect(Collectors.toList())));
    }

    static Stream<Arguments> success_test_parameter(){
        return Stream.of(
                Arguments.of(new int[]{2,7,11,15},9, new int[]{0,1}),
                Arguments.of(new int[]{3,2,4},6,new int[]{1,2})
        );
    }


}