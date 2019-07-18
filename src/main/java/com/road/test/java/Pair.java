package com.road.test.java;

/**
 * @Describe
 * @Author Road
 * @Date 2019/4/25 11:35
 **/
public class Pair<T> {
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
}
