package cn.jc.exercise.leetcode.problems.lessthan500.problem338;

/**
 * 计算每一个数的二进制1的个数，然后遍历调用一次
 */
class Solution1 {
    public int[] countBits(int num) {
        int[] r = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            r[i] = countBitsOne(i);
        }
        return r;
    }

    public int countBitsOne(int n) {
        int r = 0;
        while (n > 0) {
            int remain = n % 2;
            r += remain;
            n = n / 2;
        }
        return r;
    }
}
