package com.github.jxiu.doing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    public void successTest(){
        PriorityQueue queue = new PriorityQueue();
        queue.push(1);
        System.out.println(queue);

        queue.push(2);
        System.out.println(queue);

        queue.push(3);
        System.out.println(queue);

        queue.push(4);
        System.out.println(queue);
        Assertions.assertEquals(4, queue.top());
        queue.pop();
        Assertions.assertEquals(3, queue.top());
    }

}