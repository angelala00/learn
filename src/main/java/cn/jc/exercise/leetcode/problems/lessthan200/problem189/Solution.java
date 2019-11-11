package cn.jc.exercise.leetcode.problems.lessthan200.problem189;

class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < nums.length; j++) {
                swap(nums, 0, j);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
