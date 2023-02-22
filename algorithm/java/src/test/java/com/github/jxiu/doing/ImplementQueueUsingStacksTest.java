package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementQueueUsingStacksTest {


    @Test
    public void success_test(){
        ImplementQueueUsingStacks issue = new ImplementQueueUsingStacks();
        ImplementQueueUsingStacks.MyQueue queue = new ImplementQueueUsingStacks.MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.pop());
        Assertions.assertEquals(2, queue.pop());
        Assertions.assertEquals(3, queue.pop());
        Assertions.assertEquals(true, queue.empty());
    }
}