package cn.jc.exercise.leetcode.problems.lessthan200.problem137;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer tmp = map.get(nums[i]);
            if (tmp == null) {
                map.put(nums[i], 1);
            } else {
                if (tmp == 2) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], tmp + 1);
                }
            }
            // System.out.println(map);
        }
        return map.keySet().iterator().next();
    }
}
