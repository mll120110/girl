package com.road.thread;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/26 11:00
 **/
public class ThreadClassLoad extends AbstractThreadTest {
    /**
     * 类加载，设置线程任务
     */
    static {
        System.out.println("ThreadClassLoad开始加载.......");
        AbstractThreadTest.setThreadTask(new ThreadClassLoad());
    }
}
