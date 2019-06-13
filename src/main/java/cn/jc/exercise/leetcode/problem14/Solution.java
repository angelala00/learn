package cn.jc.exercise.leetcode.problem14;

class Solution {

    public String longestCommonPrefix(String[] strs) {

//2层循环，外层i累加，内层遍历数组
//内层循环外，设置一个暂存区，存放当前内层循环判断的字母
//内层循环里，判断第i个字母与暂存区的字母是否相等
//如果暂存区为空，设置当前字母到暂存区
//如果相等，继续走下一个内层循环
//如果不相等，结束，返回String
//判断如果有一个到头了，结束，返回String
//内层循环结束后，判断暂存区如果有字母，加到buffer中，继续外层循环

        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            char a = '+';
            for (String str : strs) {
                if (str.length() == i) {
                    return sb.toString();
                }
                if (a == '+') {
                    a = str.charAt(i);
                } else if (a == str.charAt(i)) {
                    continue;
                } else {
                    return sb.toString();
                }
            }
            if (a != '+') {
                sb.append(a);
            }
            i++;
        }
    }
}
