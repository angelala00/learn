package cn.jc.exercise.leetcode.problems.lessthan500.problem228;

import java.util.ArrayList;
import java.util.List;

class SolutionV2 {
    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<String>();
        int numslength = nums.length;
        if (numslength == 0) {
        }else if (numslength == 1) {
            resultList.add(""+nums[0]);
        } else {
            int startnum = nums[0];
            int lastnum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int currentnum = nums[i];
                if (lastnum + 1 == currentnum) {
                    lastnum = currentnum;
                } else {
                    resultList.add(printStr(startnum,lastnum));
                    startnum = currentnum;
                    lastnum = currentnum;
                }
                if (i == nums.length - 1) {
                    resultList.add(printStr(startnum,lastnum));
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
        List<String> l = new SolutionV2().summaryRanges(new int[]{1,5});
        for (String i : l) {
            System.out.println(i);
        }
    }
}
