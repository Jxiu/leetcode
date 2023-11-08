package com.github.jxiu.doing;

import com.github.jxiu.struct.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource
    public void test(int[] in1,int[] in2,int[] excepted){
        Assertions.assertEquals(
                ListNode.valueOf(excepted),
                new MergeTwoSortedLists().mergeTwoLists(ListNode.valueOf(in1),ListNode.valueOf(in2)));
    }

    @ParameterizedTest
    @MethodSource(value = "test")
    public void test1(int[] in1,int[] in2,int[] excepted){
        Assertions.assertArrayEquals(
                excepted,
                new MergeTwoSortedLists().mergeTwoArrays(in1,in2));
    }

    static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(new int[]{1,2,4}, new int[]{1,3,4},new int[]{1,1,2,3,4,4})
        );
    }
}