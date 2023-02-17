package com.github.jxiu.doing;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInArrayTest {

    @Test
    public void test_success(){
        FindAllNumbersDisappearedInArray issue = new FindAllNumbersDisappearedInArray();
        List<Integer> result = issue.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.containsAll(Arrays.asList(5,6)));
    }
}