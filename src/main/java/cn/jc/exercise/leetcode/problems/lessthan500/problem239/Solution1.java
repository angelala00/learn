package cn.jc.exercise.leetcode.problems.lessthan500.problem239;

/**
 * 直觉思维，时间复杂度O(nums.length * k)
 */
class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i + 1; j <= i + k - 1; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-8,7,5,7,1,6,0};
        int[] result = new Solution1().maxSlidingWindow(nums,4);
        for (int i : result) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}
