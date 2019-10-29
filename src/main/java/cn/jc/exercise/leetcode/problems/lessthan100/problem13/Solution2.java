package cn.jc.exercise.leetcode.problems.lessthan100.problem13;

class Solution2 {
    public int romanToInt(String s) {
        int[] map = new int[26];
        map['I' - 'C'] = 1;
        map['V' - 'C'] = 5;
        map['X' - 'C'] = 10;
        map['L' - 'C'] = 50;
        map['C' - 'C'] = 100;
        map['D' - 'C'] = 500;
        map['M' - 'C'] = 1000;

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentNum = map[currentChar - 'C'];
            int nextNum = 0;
            if (i+1 < s.length()) {
                nextNum = map[s.charAt(i+1) - 'C'];
            }
            if (nextNum > currentNum) {
                result = result - currentNum;
            } else {
                result = result + currentNum;
            }
        }
        return result;
    }
}
