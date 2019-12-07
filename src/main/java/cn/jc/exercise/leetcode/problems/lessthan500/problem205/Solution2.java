package cn.jc.exercise.leetcode.problems.lessthan500.problem205;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (map.containsValue(tc)) {
                    return false;
                }
                map.put(sc, tc);
            } else {
                if (map.get(sc) != tc) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isIsomorphic("ab", "aa"));
    }
}
