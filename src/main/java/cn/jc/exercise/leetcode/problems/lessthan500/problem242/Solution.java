package cn.jc.exercise.leetcode.problems.lessthan500.problem242;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }
        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
