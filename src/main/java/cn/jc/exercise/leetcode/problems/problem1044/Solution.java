package cn.jc.exercise.leetcode.problems.problem1044;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public String longestDupSubstring(String S) {
        int maxlen = 0;
        List<Integer> l = new ArrayList<Integer>();

        Map<Character, List<Integer>> map = new HashMap<>();
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<Integer>(){});
                continue;
            }
            List<Integer> listtmp = map.get(arr[i]);
            for (int j : listtmp) {
                int len = 0;
                int tmp_i = i;
                while (arr[j] == arr[tmp_i]) {
                    len ++;
                    j++;
                    tmp_i++;
                }
                if (len > 1 && len > maxlen) {
                    maxlen = len;
                    l = new ArrayList<Integer>();
                    l.add(i);
                } else if (len == maxlen) {
                    l.add(i);
                }
            }
            listtmp.add(i);
        }
        System.out.println(maxlen);
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestDupSubstring("banana"));
    }
}
