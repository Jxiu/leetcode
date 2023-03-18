package com.github.jxiu;

import com.github.jxiu.FindTheDuplicateNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindTheDuplicateNumberTest {

    @Test
    public void testSuccess(){
        FindTheDuplicateNumber problem = new FindTheDuplicateNumber();
        Assertions.assertEquals(2,problem.findDuplicate(new int[]{1,3,4,2,2}));
        Assertions.assertEquals(3,problem.findDuplicate(new int[]{3,1,3,4,2}));
    }

}