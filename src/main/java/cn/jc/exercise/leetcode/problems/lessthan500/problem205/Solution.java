package cn.jc.exercise.leetcode.problems.lessthan500.problem205;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[128];
        int[] n = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != n[t.charAt(i)]) {
                return false;
            }
            m[s.charAt(i)] = i + 1;
            n[t.charAt(i)] = i + 1;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("ab", "aa"));
    }
}
