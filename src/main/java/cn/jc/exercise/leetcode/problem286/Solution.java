package cn.jc.exercise.leetcode.problem286;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> resultList = new ArrayList<>();
        int lastint = 0;
        for (int i = 1; i <= n; i++) {
            Integer intvar;
            if (lastint == 0) {
                intvar = 1;
            } else {
                int tenTimesIntvar = lastint * 10;
                if (tenTimesIntvar <= n) {
                    intvar = tenTimesIntvar;
                } else {
                    int lastintaddone = lastint + 1;
                    if (lastintaddone > n) {
                        intvar = lastint / 10 + 1;
                    } else {
                        intvar = lastintaddone;
                    }
                    while (intvar % 10 == 0){
                        intvar = intvar / 10;
                    }
                }
            }
            lastint = intvar;
            resultList.add(intvar);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(29));
        System.out.println(new Solution().lexicalOrder(14959).size());
        System.out.println(new Solution().lexicalOrder(14959));
    }
}
