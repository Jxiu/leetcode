package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class ReverseLinkedListTest {

    @ParameterizedTest
    @MethodSource
    public void test(int[] in){
        int[] copy = Arrays.copyOf(in,in.length);
        for (int i = 0; i < copy.length/2; i++) {
            int temp = copy[i];
            copy[i] = copy[copy.length-i-1];
            copy[copy.length-i-1] = temp;
        }
        System.out.println(ReverseLinkedList.ListNode.valueOf(copy));
//        Assertions.assertEquals(ReverseLinkedList.ListNode.valueOf(copy),new ReverseLinkedList().reverseList(ReverseLinkedList.ListNode.valueOf(in)));
        Assertions.assertEquals(ReverseLinkedList.ListNode.valueOf(copy),new ReverseLinkedList().reverseList_ptr(ReverseLinkedList.ListNode.valueOf(in)));
    }

    static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5}),
                Arguments.of(new int[]{1})

        );
    }

}