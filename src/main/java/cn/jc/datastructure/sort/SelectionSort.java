package cn.jc.datastructure.sort;

import cn.jc.util.Util;

public class SelectionSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            int min_idx = i;
            for (int j = i; j < arr.length ; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            if (i != min_idx) {
                Util.swap(arr,i,min_idx);
            }
        }
    }

    public static void main(String[] args) {
        int[] aaa = new int[]{1,5,3,17,6,9,2,4};
        new SelectionSort().sort(aaa);
        System.out.println(Util.toString(aaa));
    }
}
