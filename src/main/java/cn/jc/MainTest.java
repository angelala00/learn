package cn.jc;

import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Logger;

public class MainTest {

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
    public int[] kWeakestRows(int[][] mat, int k) {
//        Logger.getGlobal().
        return null;
    }
    public static void main(String[] args){

        TreeMap<String, String> a;
        System.out.println(new MainTest().minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));

//        LockSupport.parkNanos(20*1000*1000);
//
//        ConcurrentHashMap<String, String> chm;

//        AtomicReferenceArray<WindowWrap<String>> array;

//        new RuntimeException();
//        Semaphore sp = new Semaphore(1);
//        CountDownLatch cdl = new CountDownLatch(2);
//        CyclicBarrier cb = new CyclicBarrier(1);
//        CopyOnWriteArrayList cowal = new CopyOnWriteArrayList();
////        Collections.synchronized
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


