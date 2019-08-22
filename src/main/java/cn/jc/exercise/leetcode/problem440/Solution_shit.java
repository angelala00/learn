package cn.jc.exercise.leetcode.problem440;

class Solution_shit {
    public int findKthNumber(int n, int k) {
        int lastint = 0;
        for (int i = 1; i <= n; i++) {
            if (lastint == 0) {
                lastint = 1;
                System.out.println(lastint);
            }
            // 乘10，
            int tenTimesIntvar = lastint * 10;
            if (tenTimesIntvar <= n) {// 乘10没超，上一个数等于乘10数，输出该数，继续
                lastint = tenTimesIntvar;
                System.out.println(lastint);
            } else {// 乘10超了
                // 就变为不乘10加1，
                int lastintaddone = lastint + 1;
                if (lastintaddone % 10 == 0) {// 如果进位了，
                    // 就再除10，输出该数，继续
                    lastint = lastintaddone / 10;
                    System.out.println(lastint);
                } else {// 如果没进位，判断是否超，如果超了，除10+1
                    if (lastintaddone > n) {
                        lastint = lastintaddone / 10 + 1;
                        System.out.println(lastint);
                    } else {
                        lastint = lastintaddone;
                        System.out.println(lastint);
                    }
                }
            }
        }
        return lastint;
    }

    public static void main(String[] args) {
        new Solution_shit().findKthNumber(13, 2);
    }
}
