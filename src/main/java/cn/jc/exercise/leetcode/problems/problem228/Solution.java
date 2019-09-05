package cn.jc.exercise.leetcode.problems.problem228;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<String>();
        int numslength = nums.length;
        if (numslength == 1) {
            resultList.add(""+nums[0]);
        } else {
            int startnum = 0;
            int lastnum = 0;
            for (int i = 0; i < nums.length; i++) {
                int currentnum = nums[i];
                if (i == 0) {
                    startnum = currentnum;
                    lastnum = currentnum;
                } else if (i == nums.length - 1) {
                    if (lastnum + 1 == currentnum) {
                        lastnum = currentnum;
                        resultList.add(printStr(startnum,lastnum));
                    } else {
                        resultList.add(printStr(startnum,lastnum));
                        startnum = currentnum;
                        lastnum = currentnum;
                        resultList.add(printStr(currentnum,currentnum));
                    }
                } else {
                    if (lastnum + 1 == currentnum) {
                        lastnum = currentnum;
                    } else {
                        resultList.add(printStr(startnum,lastnum));
                        startnum = currentnum;
                        lastnum = currentnum;
                    }
                }
            }
        }
        return resultList;
    }
    private String printStr(int start, int end){
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start+"->"+end;
        }
    }

    public static void main(String[] args) {
        List<String> l = new Solution().summaryRanges(new int[]{1,5});
        for (String i : l) {
            System.out.println(i);
        }
    }
}
