package com.road.test.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestSout implements Cloneable {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("");
    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
    final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private Condition condition = lock.newCondition();
    private static int x = 100;
    private static String a = new String("ab");

    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];
    static String s;

    public static void main(String[] args) {
        int a = 626627285 & 15;
        System.out.println(a);
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        // 不断缩小gap，直到1为止
        for (; gap > 0; gap /= 2) {
            for (int j = 0; (j + gap) < arr.length; j++) {
                for (int k = 0; (k + gap) < arr.length; k += gap) {
                    if (arr[k] > arr[k + gap]) {
                        int temp = arr[k + gap];
                        arr[k + gap] = arr[k];
                        arr[k] = temp;
                        System.out.println("Sorting: " + Arrays.toString(arr));
                    }
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 取出下一个元素，
            int temp = arr[i];
            // 在已经排序的元素序列中从后向前扫描
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1]; // 如果该元素（已排序）大于取出的元素temp，将该元素移到下一位置
                    System.out.println("Temping: " + Arrays.toString(arr));
                } else {
                    // 将新元素插入到该位置后
                    arr[j] = temp;
                    System.out.println("Sorting: " + Arrays.toString(arr));
                    break;
                }
            }
        }
    }

    public static void insertionSortDesc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] <= arr[j]) {
                    break;
                }
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                System.out.println("Sorting: " + Arrays.toString(arr));
            }
        }
    }

    public static int getValue1() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }

    public static int getValue() {
        int i = 1;
        try {
            i = 4;
        } finally {
            i++;
            return i;
        }
    }

    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += "4";
    }

    private static void testMethod() {
        System.out.println("testMethod");
    }

    @Override
    public Object clone() {
        applicationContext.getBean("qweqwewqw");
        return null;
    }

    public static final int hash(Object key) {
        int hs = 0;
        int h;
        System.out.println("key HashCode" + (h = key.hashCode()));
        System.out.println("h " + (h >>> 16));
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static int compareInt() {
        int len1 = 3;
        int len2 = 3;
        int lim = Math.min(len1, len2);
        char v1[] = {'q', 'q', 'e'};
        char v2[] = {'q', 'w', 'q'};

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                System.out.println("c1 - c2 : " + (c1 - c2));
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    transient volatile char[] table;

    final void putVal(String key, String value, boolean onlyIfAbsent) {
        if (key == null || value == null)
            throw new NullPointerException();
        int hash = 123;
        int binCount = 0;
        for (char[] tab = table;;) {
            Object f = null;
            int n, i, fh;
            //
            if (tab == null || (n = tab.length) == 0)
                System.out.println("tab is null");
            //
            else if ((fh = f.hashCode()) == 0) {

            } else {
                String oldVal = null;
                synchronized (f) {
                    if (f.hashCode() >= 0) {

                    } else {

                    }
                }
            }
        }
    }

}
