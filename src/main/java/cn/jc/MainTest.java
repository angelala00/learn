package cn.jc;

import java.util.*;

public class MainTest {
    public static void main(String[] args){
        String[] arrays = new String[]{"11","22","33"};
        List<String> list = Arrays.asList(arrays);
        list.add("44");
        System.out.println(list.size());

//        Set<String> seta = new HashSet<>();
//        System.out.println(seta.hashCode());
//        System.out.println(seta.toString());
//        System.out.println(seta);
//        seta.add("sdf");
//        System.out.println(seta.hashCode());
//        System.out.println(seta.toString());
//        System.out.println(seta);
//        seta.add("sdfa");
//        System.out.println(seta.hashCode());
//        System.out.println(seta.toString());
//        System.out.println(seta);

//        Double.parseDouble("");
//        ThreadLocal<String> tl1 = new ThreadLocal();
//        tl1.get();
//        tl1.set("");
//        tl1.remove();
//
//        ThreadLocal<String> tl2 = new ThreadLocal();
//        tl2.get();
//        tl2.set("");
//        tl2.remove();
    }

}


