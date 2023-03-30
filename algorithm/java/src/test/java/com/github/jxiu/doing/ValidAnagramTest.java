package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    @ParameterizedTest
    @MethodSource
    public void test(String s, String t, boolean excepted){
        Assertions.assertEquals(excepted, new ValidAnagram().isAnagram(s,t));
    }

    static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(null,null,false),
                Arguments.of("aa",null,false),
                Arguments.of("","",true),
                Arguments.of("3123","2133",true)
        );
    }

}