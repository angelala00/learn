package cn.jc.exercise.leetcode.problems.problem541;

class Solution {
    public String reverseStr(String s, int k) {
        char[] ans = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += 2 * k) {
            if (len < i + k) {
                reverse(ans, i, len - 1);
            } else {
                reverse(ans, i, i + k - 1);
            }
        }
        return new String(ans);
    }

    private void reverse(char[] ans, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ans[i];
            ans[i] = ans[j];
            ans[j] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
    }
}
