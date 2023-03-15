package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SuperUglyNumberTest {

    @ParameterizedTest
    @MethodSource
    public void successTest(int n, int[] primes, int excepted){
        SuperUglyNumber issue = new SuperUglyNumber();
        int out = issue.nthSuperUglyNumber(n,primes);
        Assertions.assertEquals(excepted, out);
    }

    static Stream<Arguments> successTest(){
        return Stream.of(
          Arguments.of(12, new int[]{2,7,13,19}, 32)
        );
    }
}