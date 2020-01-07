package com.road.LeeCode;

/**
 *
 */
public class SortArithmetic {

    /**
     * 插入算法，将某个元素插入到有序数组;
     * 思想将数组分为2部分，从第一个元素
     * 
     * @param a
     * @param n
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 1)
            return;
        for (int i = 1; i < n; ++i) {
            // 当i为1时，数组中的第二个元素
            int value = a[i];
            // 当i为1时，数组中第一个元素
            int j = i - 1;
            //
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    //
                    a[j + 1] = a[j];
                }
            }
        }
    }
}
