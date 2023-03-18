package com.github.jxiu;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    /**
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     *
     */
    public static class MyQueue {

        private Stack<Integer> in;
        private Stack<Integer> out;
        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2out();
            return out.pop();
        }

        /**
         * 返回队列开头的元素
         * @return
         */
        public int peek() {
            in2out();
            return out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }

        /**
         * 翻转in栈，构造out栈
         */
        private void in2out(){
            if (out.empty()){ //只有清空out，才需要重新翻转in链表，否则会乱序
                while (!in.empty()){
                    out.push(in.pop());
                }
            }
        }
    }
}
