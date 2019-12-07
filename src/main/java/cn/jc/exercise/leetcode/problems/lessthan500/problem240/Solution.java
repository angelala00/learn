package cn.jc.exercise.leetcode.problems.lessthan500.problem240;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int linemax = matrix.length - 1;
        if (linemax == -1) {
            return false;
        }
        int rowmax = matrix[0].length - 1;
        int linemin = 0;
        int rowmin = 0;
        boolean flag = true;
        for (; linemin <= linemax && rowmax >= rowmin; ) {
            if (flag) {
                if (matrix[linemin][rowmax] == target) {
                    return true;
                } else if (matrix[linemin][rowmax] > target) {
                    rowmax--;
                } else {
                    linemin++;
                }
                flag = false;
            } else {
                if (matrix[linemax][rowmin] == target) {
                    return true;
                } else if (matrix[linemax][rowmin] > target) {
                    linemax--;
                } else {
                    rowmin++;
                }
                flag = true;
            }
        }
        return false;
    }
}
