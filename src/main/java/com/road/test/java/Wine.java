package com.road.test.java;

public class Wine {
    /**
     * 父类fun1
     */
    public void fun1() {
        System.out.println("Wine 的Fun1...");
        fun2();
    }

    public void fun2() {
        System.out.println("Wine 的Fun2...");
    }
}
