package cn.jc.exercise.leetcode.problems.problem786;

import java.util.TreeMap;

/**
 * 未完成
 * Time Limit Exceeded
 */
class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        TreeMap<Double, int[]> treeMap = new TreeMap();
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                System.out.println(A[i] + "/" + A[j]);
                treeMap.put((double) A[i] / A[j], new int[]{A[i], A[j]});
            }
        }
        System.out.println("treeMap=" + treeMap);
        int i = 0;
        for (int[] s : treeMap.values()) {
            i++;
            if (i == K) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] r = new Solution().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
        System.out.println(r[0] + "," + r[1]);
    }
}
