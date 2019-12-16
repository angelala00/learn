package cn.jc.exercise.leetcode.problems.lessthan100.problem55;

/**
 * 代码做了优化，跳的距离作了限制，直接不跳超过边界的距离
 */
public class Solution3 {
    int[] cache = null;

    public boolean canJump(int[] nums) {
        cache = new int[nums.length];
        cache[nums.length - 1] = 1;
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int idx) {
        if (cache[idx] != 0) {
            return cache[idx] == 1;
        } else {
            int step = nums[idx];
            step = Math.min(step, nums.length - 1 - idx);
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
