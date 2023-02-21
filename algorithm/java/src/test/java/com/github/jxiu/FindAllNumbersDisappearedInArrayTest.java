package com.github.jxiu;

import com.github.jxiu.FindAllNumbersDisappearedInArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInArrayTest {

    @Test
    public void test_success(){
        FindAllNumbersDisappearedInArray issue = new FindAllNumbersDisappearedInArray();
        List<Integer> result = issue.solution(new int[]{4,3,2,7,8,2,3,1});
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.containsAll(Arrays.asList(5,6)));
    }
}