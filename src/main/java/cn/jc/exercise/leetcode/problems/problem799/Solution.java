package cn.jc.exercise.leetcode.problems.problem799;

/**
 * 优化执行次数
 */
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] cache = new double[query_row + 1][query_row + 3];
        cache[0][1] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = Math.max(1, query_glass + 1 - query_row + i); j <= Math.min(i + 1, query_glass + 1); j++) {
                if (cache[i - 1][j - 1] > 1) {
                    cache[i][j] += (cache[i - 1][j - 1] - 1) / 2;
                }
                if (cache[i - 1][j] > 1) {
                    cache[i][j] += (cache[i - 1][j] - 1) / 2;
                }
            }
        }
        return Math.min(1, cache[query_row][query_glass+1]);
    }

    public static void main(String[] args) {
        new Solution().champagneTower(4, 2, 0);
    }
}
