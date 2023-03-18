package com.github.jxiu;

import com.github.jxiu.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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