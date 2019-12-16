package cn.jc.exercise.leetcode.problems.lessthan200.problem136;

/**
 * 位运算
 */
class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
