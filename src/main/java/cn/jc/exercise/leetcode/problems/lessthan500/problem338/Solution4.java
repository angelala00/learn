package cn.jc.exercise.leetcode.problems.lessthan500.problem338;

/**
 * 想把map换掉，想着想着发现现有的数组不就是存了之前计算的结果么
 */
class Solution4 {
    int[] result = null;

    public int[] countBits(int num) {
        result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = countBitsOne(i);
        }
        return result;
    }

    public int countBitsOne(int n) {
        int r = 0;
        if (n != 0) {
            if (result[n] != 0) {
                r = result[n];
            } else {
                r = n % 2 + countBitsOne(n / 2);
            }
        }
        return r;
    }
}
