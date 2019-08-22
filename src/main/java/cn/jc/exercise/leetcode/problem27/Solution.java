package cn.jc.exercise.leetcode.problem27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int a = nums.length - 1;
        for (int i = 0; i <= a; i++) {
            int current = nums[i];
            if (current == val) {
                while (a > 0 && nums[a] == val) {
                    a--;
                }
                if (a < 0) {
                    a--;
                }
                if (a > i) {
                    nums[i] = nums[a];
                    a--;
                }
            } else {
                continue;
            }
        }
        return a + 1;
    }

    public static void main(String[] args) {
        new Solution().removeElement(new int[]{1}, 1);
    }
}
