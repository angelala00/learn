package cn.jc.exercise.leetcode.problems.lessthan100.problem55;

/**
 * 目前最快，看了官方解答，才写出来的
 */
public class Solution5 {
    public boolean canJump(int[] nums) {
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= pos) {
                pos = i;
            }
        }
        return pos == 0;
    }
}
