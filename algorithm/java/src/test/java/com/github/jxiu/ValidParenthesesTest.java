package com.github.jxiu;

import com.github.jxiu.ValidParentheses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource("successTestParameter")
    public void successTest(String s, boolean expected){
        ValidParentheses issue = new ValidParentheses();
        boolean actual = issue.isValid(s);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> successTestParameter(){
        return Stream.of(Arguments.of("{}", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(}", false));
    }
}