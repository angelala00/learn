package cn.jc.exercise.leetcode.problem844;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return typedintoeditor(S).equals(typedintoeditor(T));
    }

    private String typedintoeditor(String t) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if ('#' == c) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}