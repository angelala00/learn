package cn.jc.exercise.leetcode.problems.lessthan500.problem338;

/**
 * 简化一下代码，发现不用子函数了，简单很多，然而时间并没有达到最快
 */
class Solution5 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = i % 2 + result[i / 2];
        }
        return result;
    }
}
