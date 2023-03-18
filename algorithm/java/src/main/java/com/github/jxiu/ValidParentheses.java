package com.github.jxiu;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() <= 1){
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i), pre;
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if (c == ')'){
                pre = stack.pop();
                if (pre == null || pre != '('){
                    return false;
                }
            }else if (c == '}'){
                pre = stack.pop();
                if (pre == null || pre != '{'){
                    return false;
                }
            }else if (c == ']'){
                pre = stack.pop();
                if (pre == null || pre != '['){
                    return false;
                }
            }else {
                return false;
            }
        }
            return stack.isEmpty();
    }
}
