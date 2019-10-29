package cn.jc.exercise.leetcode.problems.lessthan100.problem20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] arrs = s.toCharArray();
        for (char c : arrs) {
            if (stack.empty() || !match(stack.peek(), c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }

    private boolean match(char top, char c) {
        return ('{' == top && '}' == c) || ('(' == top && ')' == c) || ('[' == top && ']' == c);
    }
}
