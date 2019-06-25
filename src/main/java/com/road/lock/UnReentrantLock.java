package com.road.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 不可重入锁
 */
public class UnReentrantLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();


    public void lock() {
        Thread current = Thread.currentThread();
        owner.get();
        for (;;) {
            if (!owner.compareAndSet(null, current)) {
                return;
            }
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }

    public static void main(String[] args) {
        new Thread().start();
    }
}
