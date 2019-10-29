package cn.jc.exercise.leetcode.problems.lessthan100.problem34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result[0] = findLeftPosition(nums, target, left,mid);
                result[1] = findRightPosition(nums, target, mid,right);
                break;
            }
        }
        return result;
    }

    private int findLeftPosition(int[] nums, int target, int left, int mid) {
        int left0 = left;
        int right0 = mid;
        int result = right0;
        while (left0 <= right0) {
            int mid0 = (left0 + right0) / 2;
            if (nums[mid0] < target) {
                left0 = mid0 + 1;
            } else {
                right0 = mid0 - 1;
                result = mid0;
            }
        }
        return result;
    }

    private int findRightPosition(int[] nums, int target, int mid, int right) {
        int left0 = mid;
        int right0 = right;
        int result = left0;
        while (left0 <= right0) {
            int mid0 = (left0 + right0) / 2;
            if (nums[mid0] > target) {
                right0 = mid0 - 1;
            } else {
                left0 = mid0 + 1;
                result = mid0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] r = new Solution().searchRange(new int[]{5,7,7,8,8,10},8);
        System.out.println("r=" + r[0] + "," + r[1]);
    }
}
