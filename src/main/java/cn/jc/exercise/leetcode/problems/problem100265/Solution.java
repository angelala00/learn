package cn.jc.exercise.leetcode.problems.problem100265;

/**
 * 调试了2个小时
 */
class Solution {public String q() {
    String g = "\\";
    String n = "\n";
    String y = "\"";
    String s = "class Solution {public String q() {%s    String g = %s%s%s%s;%s    String n = %s%s%s;%s    String y = %s%s%s;%s    String s = %s%s%s;%s    s = String.format(s, n, y, g, g, y, n, y, %s%s%sn%s, y, n, y, %s%s%s%s%s%s, y, n, y, s, y, n, y, g, g, y, y, g, g, g, y, y, n, n);%s    return s;%s}}";
    s = String.format(s, n, y, g, g, y, n, y, "\\n", y, n, y, "\\\"", y, n, y, s, y, n, y, g, g, y, y, g, g, g, y, y, n, n);
    return s;
}}
