package cn.jc.exercise.leetcode.problems.lessthan500.problem214;

class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int a = s.length() / 2;
        String addStr = "";
        for (int i = a; i >= 0; i--) {
            String r = extend(s,i,i);
            if (r == null) {
                r = extend(s,i-1,i);
                if (r == null) {
                    continue;
                } else {
                    addStr = r;
                    break;
                }
            } else {
                addStr = r;
                break;
            }
        }
        return addStr + s;
    }
    private String extend(String s, int i, int j){
        while(i >= 0){
            if (j >= s.length()) {
                break;
            }
            if (s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            } else {
                break;
            }
        }
        if (i == -1) {
            String r = "";
            for (int k = s.length()-1; k >= j; k--) {
                r = r + s.charAt(k);
            }
            return r;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome("ba"));
    }
}
