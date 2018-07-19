package com.road.test.java;

public class StaticThreadTest {
    static {
        new Thread() {
            public void run() {
                System.out.println("Hello World");
            }
        }.start();
    }
}
