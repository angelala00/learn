package cn.jc.exercise.leetcode.problem647;

import java.util.HashMap;
import java.util.Map;

class Solution5 {
    Map<String, Boolean> cash = new HashMap<String, Boolean>();
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
        String key = i + "_" + j;
        if (cash.containsKey(key)) {
            return cash.get(key);
        }
        while (s.charAt(i) == s.charAt(j)) {
            if (i >= j) {
                cash.put(key,true);
                return true;
            } else {
                i++;
                j--;
            }
        }
        cash.put(key,false);
        return false;
    }
}