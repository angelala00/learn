package cn.jc.exercise.leetcode.problems.lessthan100.problem55;

/**
 * 改map为数组作为缓存，通过，效率不高
 */
public class Solution2 {
    int[] cache = null;

    public boolean canJump(int[] nums) {
        cache = new int[nums.length];
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int idx) {
        if (idx > nums.length - 1) {
            return false;
        }
        if (idx == nums.length - 1) {
            return true;
        }
        if (cache[idx] != 0) {
            return cache[idx] == 1;
        } else {
            int step = nums[idx];
            for (int j = step; j >= 1; j--) {
                boolean r = canJump(nums, idx + j);
                if (r) {
                    cache[idx] = 1;
                    return true;
                }
            }
            cache[idx] = -1;
            return false;
        }
    }
}
