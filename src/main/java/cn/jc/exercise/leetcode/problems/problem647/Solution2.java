package cn.jc.exercise.leetcode.problems.problem647;

class Solution2 {
    int result = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            ishuiwen(s,i,i);
            ishuiwen(s,i,i+1);
        }
        return result;
    }
    public void ishuiwen(String s, int i, int j){
        if (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                result++;
                ishuiwen(s,i-1,j+1);
            }
        }
    }
}
