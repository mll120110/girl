package com.road.test.java;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestSout {
    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
    final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private Condition condition = lock.newCondition();

    @Override
    public Object clone() {
        return null;
    }

    static final int hash(Object key) {
        int hs = 0;
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void main(String[] args) throws Exception {
        Object o;
        reentrantReadWriteLock.readLock().lock();
        condition.await();




        System.out.println(hash("123"));
        System.out.println(hash("321"));
        System.out.println(args == null ? null : "1");
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        ReentrantLock reentrantLock;

        HashMap<String, Integer> hashMap = new HashMap<>(16);
        hashMap.put("aab", 1);
        hashMap.put("baa", 2);
        System.out.println(hashMap);
    }
}
