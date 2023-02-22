package com.github.jxiu.doing;

import java.util.Stack;

/**
 * 155
 */
public class MinStack {
        private Stack<Integer> origin;
        // 元素插入当时栈中最小值，之前的元素都比它大
        private Stack<Integer> min;

        public MinStack() {
            origin = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            origin.push(val);
            // 我们每次插入原栈时，都向新栈插入一次
            //原栈里所有值的最小值（新栈栈顶和待插入值中小的那一个）
            // 即 插入前的最小值已经保存了，min栈中每一个值都是在之后一段范围内最小的值
            if (min.isEmpty() || min.peek() >= val){
                min.push(val);
            }
        }

        public void pop() {
            if (!min.isEmpty() && min.peek() == origin.peek()){
                min.pop();
            }
            origin.pop();
        }

        public int top() {
            return origin.peek();
        }

        public int getMin() {
            System.out.println(this);
            return min.peek();
        }

    @Override
    public String toString() {
            return origin.toString() + "\n "+ min.toString();
    }
}
