//package cn.jc.datastructure.sort;
//
//import cn.jc.util.Util;
//
//public class InsertionSort {
//
//    public void sort(int[] a) {
//        for (int i = 1; i < a.length ; i++) {
//            for (int j = 0; j < i; j++) {
//                if (a[i] > a[j] && i != j+1) {
//                    Util.swap(a,i,j);
//                }
//            }
//            a[i]
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] aaa = new int[]{1,5,3,17,6,9,2,4};
//        new InsertionSort().sort(aaa);
//        System.out.println(Util.toString(aaa));
//    }
//}
