package cn.jc.exercise.leetcode.problems.lessthan100.problem20;

class Solution2 {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int stacklen = 0;
        char[] arrs = s.toCharArray();
        for (char c : arrs) {
            if (stacklen == 0 || !match(stack[stacklen - 1], c)) {
                stack[stacklen] = c;
                stacklen++;
            } else {
                stacklen--;
            }
        }
        return stacklen == 0;
    }

    private boolean match(char top, char c) {
        return ('{' == top && '}' == c) || ('(' == top && ')' == c) || ('[' == top && ']' == c);
    }
}
