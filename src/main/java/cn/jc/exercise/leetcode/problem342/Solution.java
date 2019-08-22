package cn.jc.exercise.leetcode.problem342;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private static Set<Integer> set = new HashSet<Integer>();
    static {
        set.add(1);
        set.add(4);
        set.add(16);
        set.add(64);
        set.add(256);
        set.add(1024);
        set.add(4096);
        set.add(16384);
        set.add(65536);
        set.add(262144);
        set.add(1048576);
        set.add(4194304);
        set.add(16777216);
        set.add(67108864);
        set.add(268435456);
        set.add(1073741824);
    }

    public boolean isPowerOfFour(int num) {
        Integer.bitCount(num);
        return set.contains(num);
    }
}
