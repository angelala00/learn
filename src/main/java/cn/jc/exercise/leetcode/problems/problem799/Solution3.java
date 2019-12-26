package cn.jc.exercise.leetcode.problems.problem799;

/**
 * 效率有所提升
 */
class Solution3 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] cache = new double[query_row + 1][query_row + 1];
        cache[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double leftup;
                if (j == 0) {
                    leftup = 0;
                } else {
                    leftup = cache[i - 1][j - 1];
                }
                double rightup;
                if (j == i) {
                    rightup = 0;
                } else {
                    rightup = cache[i - 1][j];
                }
                double result = 0.0;
                if (leftup > 1) {
                    result = (leftup - 1) / 2;
                }
                if (rightup > 1) {
                    result = result + (rightup - 1) / 2;
                }
                cache[i][j] = result;
            }
        }
        if (cache[query_row][query_glass] > 1) {
            return 1;
        }
        return cache[query_row][query_glass] ;
    }

    public static void main(String[] args) {
        new Solution3().champagneTower(4,2,0);
    }
}
