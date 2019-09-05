package cn.jc.exercise.leetcode.problems.problem440;

class Solution_timeout {
    public int findKthNumber(int n, int k) {
        int lastint = 0;
        for (int i = 1; i <= k; i++) {
            int intvar;
            if (lastint == 0) {
                intvar = 1;
            } else {
                if (lastint <= n / 10) {
                    int tenTimesIntvar = lastint * 10;
                    intvar = tenTimesIntvar;
                } else {
                    int lastintaddone = lastint + 1;
                    if (lastintaddone > n) {
                        intvar = lastint / 10 + 1;
                    } else {
                        intvar = lastintaddone;
                    }
                    while (intvar % 10 == 0) {
                        intvar = intvar / 10;
                    }
                }
            }
            lastint = intvar;
        }
        return lastint;
    }

    public static void main(String[] args) {
        System.out.println(10*10*10*10*10*10*10*10*10);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
