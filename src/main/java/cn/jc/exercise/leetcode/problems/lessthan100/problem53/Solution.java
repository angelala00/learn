package cn.jc.exercise.leetcode.problems.lessthan100.problem53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentMaxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = maxSum + nums[i];
            currentMaxSum = Math.max(currentMaxSum, sum);
            maxSum = Math.max(sum, nums[i]);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

}
