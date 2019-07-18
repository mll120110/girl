package com.road.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/25 13:34
 **/
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        System.out.println("readWriteLock.readLock().lock() begin");
        reentrantReadWriteLock.readLock().lock();
        System.out.println("readWriterLock.readLock().lock() over");

        new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 2; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    System.out.println("Thread readWriteLock.readLock().lock begin i:" + i);
                    reentrantReadWriteLock.readLock().lock();
                    System.out.println("Thread readWriteLock.readLock().lock over i:" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }.start();

        Thread.sleep(1 * 1000);

        System.out.println("readWriteLock.writerLock().lock() begin");
        reentrantReadWriteLock.writeLock().lock();
        System.out.println("readWriteLock.writerLock().lock() over");

    }


}
