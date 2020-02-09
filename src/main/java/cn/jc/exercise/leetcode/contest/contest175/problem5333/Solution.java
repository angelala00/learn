package cn.jc.exercise.leetcode.contest.contest175.problem5333;

class Solution {
    public int minSteps(String s, String t) {
        int[] scount = count(s);
        int[] tcount = count(t);
        int r = 0;
        for (int i = 0; i < 26; i++) {
            int d = scount[i] - tcount[i];
            if (d > 0) {
                r += d;
            }
        }
        return r;
    }

    public int[] count(String s) {
        char[] cs = s.toCharArray();
        int[] r = new int[26];
        for (int i = 0; i < cs.length; i++) {
            r[(int) cs[i] - 'a'] += 1;
        }
        return r;
    }
}
