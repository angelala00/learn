package cn.jc.exercise.leetcode.explore;

public class AAA {
    public int removeDuplicates(int[] nums) {
        int lastIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                lastIdx = i;
            } else {
                if (nums[lastIdx] != nums[i]) {
                    nums[lastIdx + 1] = nums[i];
                    lastIdx = lastIdx + 1;
                }
            }
        }
        return lastIdx+1;
    }

    public static void main(String[] args) {
        int length = new AAA().removeDuplicates(new int[]{0,1,1,1,2,2,3,3,4});
        System.out.println(length);
    }
}
