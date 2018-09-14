package cn.jc.exercise.leetcode.problem647;

class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (ishuiwen(s, j, i)) {
                    result++;
                }
            }
        }
        return result;
    }
    public boolean ishuiwen(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return ishuiwen(s, i + 1, j - 1);
        } else {
            return false;
        }
    }
}