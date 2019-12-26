package cn.jc.exercise.leetcode.problems.problem799;

/**
 * 执行超时
 */
class Solution1 {
    int poured;

    public double champagneTower(int poured, int query_row, int query_glass) {
        this.poured = poured;
        double r = champagneTowerTotal(query_row, query_glass);
        if (r > 1) {
            r = 1;
        }
        return r;
    }

    public double champagneTowerTotal(int query_row, int query_glass) {
        if (query_row == 0 && query_glass == 0) {
            return poured;
        }
        if (query_glass == -1) {
            return 0;
        }
        if (query_glass > query_row) {
            return 0;
        }
        double leftup = champagneTowerTotal(query_row - 1, query_glass - 1);
        double rightup = champagneTowerTotal(query_row - 1, query_glass);
        double result = 0.0;
        if (leftup > 1) {
            result = (leftup - 1) / 2;
        }
        if (rightup > 1) {
            result = result + (rightup - 1) / 2;
        }
        return result;
    }
}
