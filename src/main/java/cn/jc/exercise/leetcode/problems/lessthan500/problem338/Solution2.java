package cn.jc.exercise.leetcode.problems.lessthan500.problem338;

/**
 * 换了一个递归调用
 */
class Solution2 {
    public int[] countBits(int num) {
        int[] r = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            r[i] = countBitsOne(i);
        }
        return r;
    }

    public int countBitsOne(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 2 + countBitsOne(n >> 1);
        }
    }
}
