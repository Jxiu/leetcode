package com.github.jxiu;

import com.github.jxiu.MinStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinStackTest {

    @Test
    public void SuccessTest(){
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(1);
        minStack.push(1);
        minStack.push(3);
        minStack.push(-1);
        Assertions.assertEquals(-1, minStack.getMin());
        Assertions.assertEquals(-1, minStack.top());
        minStack.pop();
        Assertions.assertEquals(1, minStack.getMin());
        Assertions.assertEquals(3, minStack.top());
        minStack.pop();
        Assertions.assertEquals(1, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(1, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(2, minStack.getMin());
    }
}