package cn.jc.exercise.leetcode.problems.problem46;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                List<Integer> sl = new ArrayList<Integer>();
                sl.add(nums[0]);
                resultList.add(sl);
            } else {
                List<List<Integer>> tempResultList = new ArrayList<List<Integer>>();
                for (List<Integer> tempList : resultList) {
                    for (int j = 0; j <= tempList.size(); j++) {
                        List<Integer> sl = new ArrayList<Integer>(tempList);
                        sl.add(j,nums[i]);
                        tempResultList.add(sl);
                    }
                }
                resultList = tempResultList;
            }
        }
        return resultList;
    }
}
