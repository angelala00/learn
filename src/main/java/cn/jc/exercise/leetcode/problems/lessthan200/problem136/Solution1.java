package cn.jc.exercise.leetcode.problems.lessthan200.problem136;

import java.util.HashMap;
import java.util.Map;

/**
 * hash表 or set
 */
class Solution1 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], null);
            } else {
                map.remove(nums[i]);
            }
            //System.out.println(map);
        }
        return map.keySet().iterator().next();
    }
}
