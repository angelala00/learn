package cn.jc.exercise.leetcode.problems.lessthan100.problem33;

class Solution {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        return search(nums, target, begin, end);
    }
    public int search(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }

        if (nums[begin] == target) {
            return begin;
        }

        if (nums[end] == target) {
            return end;
        }

        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[begin] < nums[mid]) {
            if (nums[begin] < target && target < nums[mid]) {
                return search(nums, target, begin + 1, mid - 1);
            } else {
                return search(nums, target, mid + 1, end - 1);
            }
        } else {
            if (nums[mid] < target && target < nums[end]) {
                return search(nums, target, mid + 1, end - 1);
            } else {
                return search(nums, target, begin + 1, mid - 1);
            }
        }
    }
}
