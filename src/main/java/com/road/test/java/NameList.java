package com.road.test.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author Road
 * @Date 2019/4/10 17:46
 **/
public class NameList {
    private List names = new ArrayList<>();

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + "");
        }
    }

    public static void main(String[] args) {
        final NameList s1 = new NameList();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    s1.add("A");
                    s1.add("B");
                    s1.add("C");
                    s1.printAll();
                }
            }.start();
        }
    }
}
