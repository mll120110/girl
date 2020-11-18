package com.road.thread;

/**
 * Thread start方法与run方法区别
 */
public class ThreadRunTest {

    /**
     * start() 方法则是 Thread 类的方法，
     *
     * 用来异步启动一个线程，然后主线程立刻返回。
     *
     * 该启动的线程不会马上运行，会放到等待队列中等待 CPU 调度，
     *
     * 只有线程真正被 CPU 调度时才会调用 run() 方法执行
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new Thread(() -> pong());
        // 将当前线程设置为就绪状态，让CPU自动调用，并分配时间片运行
        t.start();
        System.out.println("ping");
    }

    /**
     * 静态方法打印输出
     */
    public static void pong() {
        System.out.println("pong");
    }
}
