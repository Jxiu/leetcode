package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementStackUsingQueuesTest {


    @Test
    public void successTest(){
        ImplementStackUsingQueues.MyStack stack = new ImplementStackUsingQueues.MyStack();
        stack.push(1);
        stack.push(2);
        Assertions.assertEquals(2,stack.top());
        Assertions.assertEquals(false, stack.empty());
        stack.push(3);
        Assertions.assertEquals(3,stack.top());
        stack.pop();
        Assertions.assertEquals(2,stack.top());
        stack.pop();
        stack.pop();
        Assertions.assertEquals(true, stack.empty());



    }
}