package com.road.thread;

import java.util.concurrent.TimeUnit;

class LockDemo implements Runnable {

    String lockA;
    String lockB;

    public LockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println("锁住" + lockA + "尝试获取" + lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
                synchronized (lockB) {
                    System.out.println("锁住" + lockB + "尝试获取" + lockA);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DeadThread {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new LockDemo(lockA, lockB)).start();
        new Thread(new LockDemo(lockB, lockA)).start();
    }
}
