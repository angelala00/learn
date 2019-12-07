package cn.jc.exercise.leetcode.problems.lessthan500.problem239;

/**
 * 直觉思维优化，
 */
class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (i > 0) {
                int lastMax = result[i-1];
                if (nums[i-1] != lastMax) {
                    result[i] = lastMax;
                    if (result[i] < nums[i + k - 1]) {
                        result[i] = nums[i + k - 1];
                    }
                    continue;
                }
            }

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
        int[] result = new Solution2().maxSlidingWindow(nums,4);
        for (int i : result) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}
