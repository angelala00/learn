package cn.jc.exercise.leetcode;

import java.util.TreeMap;

class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, -1, 4, -2, -3, -1};
        int result = new Solution().maxProduct(nums);
        System.out.println("result=" + result);
    }

}
