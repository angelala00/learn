package cn.jc.interview.airbnb.date201912.second;

public class Solution {

    public static void main(String[] args) {
        int M = 4;
        int N = 4;

        int[][] result = new int[M][N];

        int x = 0;
        int y = 0;
        int tag = 1;//0 left down 1 right up
        for (int i = 1; i <= M*N; i++) {
            //System.out.println("y=" + y + " x=" + x + " i=" + i + " tag=" + tag);
            result[y][x] = i;

            if (tag == 1) {
                if (y == 0 && x < N - 1) {//top not right
                    x = x + 1;
                    tag = 0;
                } else if (y == 0 && x == N - 1) {
                    y = y + 1;
                    tag = 0;
                } else if (x == N - 1) {
                    y = y + 1;
                    tag = 0;
                } else {
                    x = x + 1;
                    y = y - 1;
                }

            } else if (tag == 0) {
                if (x == 0 && y < M - 1) {//left not bottom
                    y = y + 1;
                    tag = 1;
                } else if (x == 0 && y == M - 1) {
                    x = x + 1;
                    tag = 1;
                } else if (y == M - 1) {
                    x = x + 1;
                    tag = 1;
                } else {
                    x = x - 1;
                    y = y + 1;
                }

            }
        }
        for (int i = 0; i <= M - 1; i++) {
            for (int j = 0; j <= N - 1; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
