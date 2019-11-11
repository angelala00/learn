package cn.jc.exercise.leetcode.problems.lessthan200.problem167;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (m.get(numbers[i]) != null) {
                return new int[]{m.get(numbers[i])+1,i+1};
            }
            m.put((target - numbers[i]),i);
        }
        return null;
    }
}
