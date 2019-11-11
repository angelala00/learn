package cn.jc.exercise.leetcode.problems.lessthan500.problem215;

class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        int currentidx = left;
        //left=0,right=1
        int currentside = 0;
        //遍历
        while (left <= currentidx && currentidx <= right && left < right) {
            //在左边
            if (currentside == 0) {
                //如果当前元素大于右边，交换
                if (nums[currentidx] > nums[right]) {
                    swap(nums, left, right);
                    currentidx = right;
                    currentside = 1;
                } else {
                    right--;
                }
            } else {
                //如果当前元素小于左边，交换
                if (nums[currentidx] < nums[left]) {
                    swap(nums, left, right);
                    currentidx = left;
                    currentside = 0;
                } else {
                    left++;
                }
            }
        }
        if (target < currentidx) {
            return quickSort(nums, start, currentidx - 1, target);
        } else if (target > currentidx) {
            return quickSort(nums, currentidx + 1, end, target);
        } else {
            return nums[left];
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().findKthLargest(new int[]{3,2,1,5,6,4}, 2));//5
        System.out.println(new Solution3().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));//4
        System.out.println(new Solution3().findKthLargest(new int[]{2,1}, 1));//2
    }
}
