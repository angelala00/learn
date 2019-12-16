package cn.jc.exercise.leetcode.problems.lessthan100.problem55;

/**
 * 还有不同思路，从前往后跳，这个解法，写出来了，也参考了解题中一位C++同学的解法，还没有想透彻，一下午，脑子已经不好使了
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int pos = 0;
        for (int i = 0; i <= nums.length - 2; i++) {
            if (i > pos) {
                return false;
            }
            if (pos < nums[i] + i) {
                pos = nums[i] + i;
            }
        }
        return pos >= nums.length - 1;
    }
}
