package cn.jc.exercise.leetcode.problems.lessthan500.problem215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int currentidx = partation(nums,start,end);
        if (currentidx == k) {
            return nums[k];
        } else if (currentidx > k) {
            return quickSelect(nums, start, currentidx - 1, k);
        } else {
            return quickSelect(nums, currentidx + 1, end, k);
        }
    }

    private int partation(int[] nums, int start, int end) {
        int pr = nums[end];
        int tmp = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] < pr) {
                swap(nums,tmp,i);
                tmp++;
            }
        }
        swap(nums, tmp, end);
        return tmp;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
