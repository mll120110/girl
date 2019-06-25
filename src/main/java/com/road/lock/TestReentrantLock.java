package com.road.lock;

/**
 * 第一种定义：在一个线程中可以多次获取同一把锁，比如：一个线程在执行一个带锁的方法，该方法中又调用了另一个需要相同锁的方法，则该线程可以直接执行调用的方法，而无需重新获得锁；
 * 第二种定义：可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁（前提得是同一个对象或者class）。
 */
public class TestReentrantLock implements Runnable {
    /**
     * 线程先调用一个sync锁的方法，然后又调用set被sync修饰的方法
     */
    public synchronized void get() {
        System.out.println("get():" + Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println("set()" + Thread.currentThread().getId());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        TestReentrantLock testReentrantLock = new TestReentrantLock();
        new Thread(testReentrantLock).start();
        new Thread(testReentrantLock).start();
        new Thread(testReentrantLock).start();
    }
}
