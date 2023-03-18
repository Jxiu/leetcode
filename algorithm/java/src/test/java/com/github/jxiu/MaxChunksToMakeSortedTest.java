package com.github.jxiu;

import com.github.jxiu.MaxChunksToMakeSorted;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxChunksToMakeSortedTest {

    @ParameterizedTest
    @MethodSource("test_success_source")
    public void test_success(int[] arr, int nums){
        MaxChunksToMakeSorted issue = new MaxChunksToMakeSorted();
        int result = issue.maxChunksToSorted(arr);
        Assertions.assertEquals(nums,result);
    }

    static Stream<Arguments> test_success_source(){
        return  Stream.of(
                Arguments.of(new int[]{4,3,2,1,0},1),
                Arguments.of(new int[]{0,1,2,3,4},5),
                Arguments.of(new int[]{0,1,3,2,4},4),
                Arguments.of(new int[]{1,0,2,3,4},4)
        );
    }

}