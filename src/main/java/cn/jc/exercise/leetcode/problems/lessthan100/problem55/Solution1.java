package cn.jc.exercise.leetcode.problems.lessthan100.problem55;

import java.util.HashMap;
import java.util.Map;

/**
 * 直接挨着跳，超时，加了map，仍然超时
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>(100000);

    public boolean canJump(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            return true;
        } else if (idx > nums.length - 1) {
            return false;
        }
        int step = nums[idx];
        if (step == 0) {
            return false;
        }
        for (int j = step; j >= 1; j--) {
            boolean r;
            if (map.containsKey(idx + j)) {
                r = map.get(idx + j);
            } else {
                r = canJump(nums, idx + j);
                map.put(idx + j, r);
            }
            if (r) {
                return true;
            }
        }
        return false;
    }
}
