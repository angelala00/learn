package cn.jc.exercise.leetcode.problems.problem647;

class Solution4 {
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
        while (s.charAt(i) == s.charAt(j)) {
            if (i >= j) {
                return true;
            } else {
                i++;
                j--;
            }
        }
        return false;
    }
}
