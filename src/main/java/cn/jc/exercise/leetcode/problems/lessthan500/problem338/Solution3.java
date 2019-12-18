package cn.jc.exercise.leetcode.problems.lessthan500.problem338;

import java.util.HashMap;
import java.util.Map;

/**
 * 想到有很多重复的计算过程，于是用map把之前计算过的结果存起来，时间居然增加了很多，估计是map导致的性能问题
 */
class Solution3 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int[] countBits(int num) {
        int[] r = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            r[i] = countBitsOne(i);
        }
        return r;
    }

    public int countBitsOne(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int r = 0;
            if (n != 0) {
                r = n % 2 + countBitsOne(n / 2);
            }
            map.put(n, r);
            return r;
        }
    }
}
