package cn.jc.datastructure.sort;

import cn.jc.util.Util;

public class BubbleSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    Util.swap(arr,j,j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] aaa = new int[]{1,5,3,17,6,9,2,4};
        new BubbleSort().sort(aaa);
        System.out.println(Util.toString(aaa));
    }
}
