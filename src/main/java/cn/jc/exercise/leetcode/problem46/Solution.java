package cn.jc.exercise.leetcode.problem46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            List<Integer> l = new ArrayList<Integer>();
            l.add(nums[0]);
            list.add(l);
            return list;
        }
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int[] subnums = remove(nums,i);
            List<List<Integer>> subresult = permute(subnums);
            for (List<Integer> l : subresult) {
                l.add(0,nums[i]);
                finalList.add(l);
            }
        }
        return finalList;
    }
    public int[] remove(int[] nums,int index){
        int[] newArr = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i < index) {
                newArr[i] = nums[i];
            } else {
                newArr[i] = nums[i+1];
            }
        }
        return newArr;
    }
}