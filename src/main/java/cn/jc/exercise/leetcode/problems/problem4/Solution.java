package cn.jc.exercise.leetcode.problems.problem4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int tag = (len1 + len2) % 2;
        int median_len = (len1 + len2) / 2;
        int aaaa = 0;
        int i = 0;
        int j = 0;
        int num_median_len_1 = 0;
        int num_median_len = 0;
        while (aaaa <= median_len) {
            int currentval = 0;
            if (j == len2) {
                currentval = nums1[i];
                i++;
            } else if (i == len1){
                currentval = nums2[j];
                j++;
            } else {
                if (nums1[i] < nums2[j]) {
                    currentval = nums1[i];
                    i++;
                } else if (nums1[i] > nums2[j]){
                    currentval = nums2[j];
                    j++;
                } else {
                    if (j == len2) {
                        currentval = nums1[i];
                        i++;
                    } else {
                        currentval = nums2[j];
                        j++;
                    }
                }
            }
            if (aaaa == median_len - 1) {
                num_median_len_1 = currentval;
            }
            if (aaaa == median_len) {
                num_median_len = currentval;
            }
            aaaa++;
        }
        if (tag == 0) {
            return ((double)(num_median_len_1 + num_median_len)) / 2;
        } else {
            return num_median_len;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1};
        int[] b = new int[] {1};
        System.out.println(new Solution().findMedianSortedArrays(a,b));
    }
}
