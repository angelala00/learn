package cn.jc.exercise.hackerrank.interview;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestMain3 {

    static String[] getMoneySpent(int perPageSize, String[] datas) {
        int pageNumbers = datas.length / perPageSize;
        int lastPageSize = datas.length % perPageSize;
        int resultLength = datas.length + pageNumbers;
        if (lastPageSize == 0) {
            resultLength = resultLength - 1;
        }
//        Map map;
//        map.containsKey()
        String[] result = new String[resultLength];

        int currentPageNumber = 1;
        int currentDataIndex = 1;
        //last page set
        int lineIndex = 1;
        int resultIndex = 0;
        Set<String> tmpSet = new HashSet<>();
        for (String line : datas) {
            //往结果里面放，判断当前页的集合中是否有重复，如果有，放到另一个集合中去
            //判断，如果放够5个元素了，追回一个换行符号，记录新起一行

            if (lineIndex == 5) {//要放的是第5条记录
                //放完后
                result[resultIndex] = "";//加换行符
                lineIndex = 1;//初始化下一行索引
                tmpSet.clear();//清空另一集合
            } else {
                if (tmpSet.size() > 0) {
//                    for () {
//
//                    }
                }
                lineIndex++;
            }
            //判断，如果是新一行，先判断另一个集合中是否有元素，如果有，遍历另一集合，完了之后，如果不满，再接着遍历原集合
            result[currentDataIndex] = line;
        }



        return result;
    }
}
