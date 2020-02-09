package cn.jc.exercise.leetcode.contest.contest174.problem5329;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }
        Integer[] r = new Integer[map.values().size()];
        map.values().toArray(r);
        Arrays.sort(r);
        int count = 0;
        int sum = 0;
        for (int i = r.length - 1; i >= 0; i--) {
            count++;
            sum += r[i];
            if (sum >= arr.length / 2) {
                break;
            }
        }
        return count;
    }
}
