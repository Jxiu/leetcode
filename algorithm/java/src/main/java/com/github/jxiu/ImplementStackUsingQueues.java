package com.github.jxiu;

import java.util.LinkedList;

/**
 * 225. 用队列实现栈(easy)
 */
public class ImplementStackUsingQueues {

    public static class MyStack {
        private LinkedList<Integer> reverse; // 倒叙排好的队列
        private LinkedList<Integer> temp;
        public MyStack() {
            temp = new LinkedList<>();
            reverse = new LinkedList<>();
        }

        public void push(int x) {
            // 入栈新元素
            temp.offer(x);//最后元素排到队首
            while (!reverse.isEmpty()){
                temp.offer(reverse.removeFirst());
            }
            // temp 倒叙排列完成, 成为新的倒排队列，旧的队列成为临时队列
            LinkedList<Integer> queue = this.temp;
            temp = reverse;
            reverse = queue;
        }

        /**
         * 移除并返回栈顶元素。
         * @return
         */
        public int pop() {
            // 从源队列取出
            return reverse.removeFirst();
        }

        /**
         * 返回栈顶元素
         * @return
         */
        public int top() {
            return reverse.getFirst();
        }

        /**
         *  如果栈是空的，返回 true ；否则，返回 false 。
         * @return
         */
        public boolean empty() {
            return reverse.isEmpty();
        }
    }
}
