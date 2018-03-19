package cn.jc.exercise;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    //获取最后一个词的长度
    public static int getLastWordLength(String str) {
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    //统计每个词出现的次数
    public static void countWordsTimes(String[] strs) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : strs) {
            if (map.containsKey(str)) {
                Integer i = map.get(str);
                map.put(str, i + 1);
            } else {
                map.put(str, 1);
            }
        }
        //按结果打印map就好了
    }

    //洗牌算法

    //水仙数
}


