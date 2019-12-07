package cn.jc.exercise.leetcode.problems.problem1106;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<Character>();
        char[] strs = expression.toCharArray();
        for (char c : strs) {
            if (c == ')') {
                List<Character> tmps = new ArrayList<Character>();
                char tmp = stack.pop();
                while (tmp != '(') {
                    if (tmp == 't' || tmp == 'f') {
                        tmps.add(tmp);
                    }
                    tmp = stack.pop();
                }
                tmp = stack.pop();
                char r = calu(tmp,tmps);
                stack.push(r);
            } else {
                stack.push(c);
            }
        }
        char r = stack.peek();
        return r == 't';
    }

    private char calu(char op, List<Character> tmps) {
        if (op == '!') {
            return tmps.get(0) == 't' ? 'f' : 't';
        } else if (op == '|') {
            for (char tmp : tmps) {
                if (tmp == 't') {
                    return 't';
                }
            }
            return 'f';
        } else if (op == '&') {
            for (char tmp : tmps) {
                if (tmp == 'f') {
                    return 'f';
                }
            }
            return 't';
        }
        return 'f';
    }

}
