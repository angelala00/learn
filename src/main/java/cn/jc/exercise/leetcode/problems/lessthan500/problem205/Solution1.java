package cn.jc.exercise.leetcode.problems.lessthan500.problem205;

import java.util.HashMap;
import java.util.Map;

class Solution1 {

    public boolean isIsomorphic(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Map<Character,Character> map = new HashMap<Character,Character>();
        for (int i = 0; i < ss.length; i++) {
            if (!map.containsKey(ss[i])) {
                if (map.containsValue(ts[i])) {
                    return false;
                }
                map.put(ss[i],ts[i]);
            } else {
                if (map.get(ss[i]) != ts[i]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution1().isIsomorphic("ab","aa"));
    }
}
