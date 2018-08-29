package cn.jc.exercise.leetcode.problem1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(nums[i]) != null) {
                return new int[]{m.get(nums[i]),i};
            }
            m.put((target - nums[i]),i);
        }
        return null;
    }
}