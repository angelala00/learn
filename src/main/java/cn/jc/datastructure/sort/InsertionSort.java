package cn.jc.datastructure.sort;

import cn.jc.util.Util;

public class InsertionSort {

    /**
     * 从前往后遍历插入，插入后，后面所有的元素都需要往后挤一下
     * 代码没写出来。。。
     *
     * @param a
     */
    public void sort0(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                // TODO
            }
        }
    }

    /**
     * 从后往前遍历插入，这个插入过程有点像冒泡，只冒到合适的位置即可
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int compareTimes = 0;
        int swapTimes = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                compareTimes++;
                if (arr[j] < arr[j - 1]) {
                    Util.swap(arr, j, j - 1);
                    swapTimes++;
                } else {
                    break;
                }
            }
        }
        System.out.println("数组长度:" + arr.length + " 比较次数:" + compareTimes + " 交换次数:" + swapTimes);
    }

    public static void main(String[] args) {
        int[] aaa;
        aaa = new int[]{1, 17, 6, 9, 2, 4, 100, 38, 94, 29, 46, 3, 57, 65, 19, 5};
        new InsertionSort().sort(aaa);
        System.out.println(Util.toString(aaa));
    }
}
