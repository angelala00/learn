package cn.jc.exercise.leetcode.contest.contest174.problem5328;

import java.util.*;

/**
 * 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 0 和 1 表示。
 *
 * 请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    class Team{
        int idx;
        int count;

        public Team(int i, int count) {
            this.idx = i;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "idx=" + idx +
                    ", count=" + count +
                    '}';
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Team> teams = new ArrayList<Team>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            teams.add(new Team(i, count));
        }
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                if (o1.count == o2.count) {
                    return o1.idx - o2.idx;
                }
                return o1.count - o2.count;
            }
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = teams.get(i).idx;
        }
        return result;
    }
}
