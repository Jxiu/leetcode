package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @ParameterizedTest
    @MethodSource
    public void testSuccess(String s, List<String> wordDict, boolean expected){
        WordBreak issue = new WordBreak();
        Assertions.assertEquals(expected, issue.wordBreak(s, wordDict));
    }

    static Stream<Arguments> testSuccess(){
        return Stream.of(
                Arguments.of("leetcode", Arrays.asList("leet", "code"), true),
                Arguments.of("applepenapple", Arrays.asList("apple", "pen"), true),
                Arguments.of("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"), false)
        );
    }
}