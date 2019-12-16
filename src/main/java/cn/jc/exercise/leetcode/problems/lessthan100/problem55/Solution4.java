package cn.jc.exercise.leetcode.problems.lessthan100.problem55;

/**
 * 从后往前缓存，减少递归调用
 */
public class Solution4 {
    int[] cache = null;

    public boolean canJump(int[] nums) {
        cache = new int[nums.length];
        cache[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int farthest = Math.min(nums[i] + i, nums.length - 1);
            for (int j = farthest; j > i; j--) {
                if (cache[j] == 1) {
                    cache[i] = 1;
                    break;
                }
            }
        }
        return cache[0] == 1;
    }
}
