package cn.jc.exercise.leetcode.problems.lessthan500.problem338;

/**
 * 换成位运算后，击败了100%
 */
class Solution6 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = (i & 1) + result[i >> 1];
        }
        return result;
    }
}
