package cn.jc.exercise.hackerrank.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * airbnb interview
 */
public class TestMain {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        //first_name,last_name,email,interests,notes,city,age
        //[first_name], [age] years old, is from [city] and is interested in [interests].
        //
        //Elena,Martinez,emrt@lsofnbr.rt,"cooking, traveling",superhost,Valencia,42
        String inputString = "Weronika,Zaborska,njkfdsv@dsgfk.sn,\"running, sci-fi\",new,Krakow,25\n" +
                "Ryuichi,Akiyama,jkg@ljnsfd.fjn,music,guide,Tokyo,65\n" +
                "Elena,Martinez,emrt@lsofnbr.rt,\"cooking, traveling\",superhost,Valencia,42\n" +
                "\"John \"\"Mo\"\"\",Smith,sfn@flkaei.km,biking and hiking,,\"Seattle, WA\",23";
        System.out.println(inputString);
//        Scanner scan = new Scanner(System.in);
//        inputString = scan.nextLine();
        String[] lines = inputString.split("\n");
//        scan.close();
        for (String line : lines) {
            String r = formatLine(line);
            System.out.println(r);
        }
    }
    private static String formatLine (String s) {
        List<String> list = new ArrayList<String>();
        char[] chars = s.toCharArray();
        int tag = 0;//标记位，标记了当前是处于某一个字段域内的
        StringBuilder sb0 = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (',' == chars[i] && tag == 0) {
                list.add(sb0.toString());
                sb0 = new StringBuilder();
            } else {
                sb0.append(chars[i]);
                if ('"' == chars[i] && tag == 0) {
                    tag ++;
                } else if ('"' == chars[i] && tag == 1) {
                    tag--;
                }
            }
        }
        list.add(sb0.toString());
        String firstName = formatString(list.get(0));
        String interests = formatString(list.get(3));
        String city = formatString(list.get(5));
        String age = list.get(6);
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(", ").append(age).append(" years old, is from ").append(city).append(" and is interested in ").append(interests).append(".");
        return sb.toString();
    }
    private static String formatString(String s){
        //如果包含"，那么判断里面的两倍的"变成一个
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        if (s.length() >= 2 && chars[0] == '"'){
            boolean tag = false;
            for (int i = 1; i < chars.length - 1; i++) {
                if ('"' == chars[i] && tag == false) {
                    tag = true;
                } else if ('"' == chars[i] && tag == true) {
                    sb.append(chars[i]);
                    tag = false;
                } else {
                    sb.append(chars[i]);
                }
            }
        } else {
            return s;
        }
        return sb.toString();
    }
}
