package cn.jc.exercise.leetcode.problem647;

class Solution3 {
    int result = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            ishuiwen(s,i,i);
            ishuiwen(s,i,i+1);
        }
        return result;
    }
    public void ishuiwen(String s, int i, int j){
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                result++;
                i--;
                j++;
            } else {
                break;
            }
        }
    }
}