package cn.jc.exercise.leetcode.problems.problem13;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<String,Integer> m = new HashMap<String,Integer>();
        m.put("I",1);
        m.put("V",5);
        m.put("X",10);
        m.put("L",50);
        m.put("C",100);
        m.put("D",500);
        m.put("M",1000);

        m.put("IV",4);
        m.put("IX",9);
        m.put("XL",40);
        m.put("XC",90);
        m.put("CD",400);
        m.put("CM",900);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (i+1 < s.length()) {
                char nextChar = s.charAt(i+1);
                String k = "" + currentChar + nextChar;
                Integer num = m.get(k);
                if (num != null) {
                    result = result + num;
                    i++;
                    continue;
                }
            }
            String k = "" + currentChar;
            result = result + m.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("III"));
    }
}
