package cn.jc.exercise.leetcode.problems.problem786;

/**
 * 未完成
 * https://www.cnblogs.com/grandyang/p/9135156.html
 * Time Limit Exceeded
 */
class Solution2 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double left = 0, right = 1;
        while (true) {
            double mid = left + (left + right) / 2.0;
            int p = 1;
            int q = 1;
            int count = 0;
            for (int i = 0; i < A.length - 1; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    System.out.println(A[i] + "/" + A[j]);
                    double tmp = (double) A[i] / A[j];
                    if (tmp < mid) {
                        count++;
                    }
                    if (tmp < p / q) {
                        p = A[i];
                        q = A[j];
                    }
                }
            }
            if (count == K) {
                return new int[]{p, q};
            } else if (count < K) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] r = new Solution2().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
        System.out.println(r[0] + "," + r[1]);
    }
}
