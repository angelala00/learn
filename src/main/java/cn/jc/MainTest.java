package cn.jc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainTest {
    public static void main(String[] args){

        HashMap<Integer, Integer> map = new HashMap<>();
        Integer a = map.get(1);
        map.keySet().iterator().next();
//        int b = map.get(1);
        System.out.println("a="+a);

//
//        new RuntimeException();
//        Semaphore sp = new Semaphore(1);
//        CountDownLatch cdl = new CountDownLatch(2);
//        CyclicBarrier cb = new CyclicBarrier(1);
//        CopyOnWriteArrayList cowal = new CopyOnWriteArrayList();
////        Collections.synchronized
//
//        ArrayList<String> list = new ArrayList<String>(1);
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        for (String item : list) {
//            if ("4".equals(item)) {
//                list.remove(item);
//            }
//        }
//        System.out.println(list);
//
//        int a = 1;
//        switch (a) {
//            case 2:
//                System.out.println("print 2 ");
//            case 1:
//                System.out.println("print 1 ");
//            default:
//                System.out.println("first default print ");
//            case 3:
//                System.out.println("print 3 ");
//        }
//
//        String param = null;
//        switch (param) {
//            case "param":
//                System.out.println("print param");
//                break;
//            case "String":
//                System.out.println("print String");
//                break;
//            case "null":
//                System.out.println("print null");
//                break;
//            default:
//                System.out.println("second default print");
//        }



//        String[] arrays = new String[]{"11","22","33"};
//        List<String> list = Arrays.asList(arrays);
//        list.add("44");
//        System.out.println(list.size());

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


