package cn.jc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainTest {
    public static void main(String[] args){
        Set<String> seta = new HashSet<>();
//        System.out.println(seta.hashCode());
//        System.out.println(seta.toString());
        System.out.println(seta);
        seta.add("sdf");
//        System.out.println(seta.hashCode());
//        System.out.println(seta.toString());
        System.out.println(seta);
        seta.add("sdfa");
//        System.out.println(seta.hashCode());
//        System.out.println(seta.toString());
        System.out.println(seta);

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


