package com.road.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/26 11:01
 **/
public class AbstractThreadTest {
    /**
     * 设置线程池核心数大小
     */
    private static final int MAX_PROCESSORS = 10;
    /**
     * 类加载时，初始化线程池
     */
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(MAX_PROCESSORS, MAX_PROCESSORS * 5, 30L,
        TimeUnit.SECONDS, new ArrayBlockingQueue<>(MAX_PROCESSORS * 20), new ThreadPoolExecutor.DiscardOldestPolicy());

    /**
     * 线程池启动
     *
     * @param abstractThreadTest
     * @param asyncTaskId
     */
    public void beginThreadTask(AbstractThreadTest abstractThreadTest, String asyncTaskId) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池启动");
            }
        });
    }

    /**
     * 子类初始化调用，创建异步任务线程
     *
     * @param taskQueue
     */
    public static void setThreadTask(AbstractThreadTest taskQueue) {

        threadPoolExecutor.execute(() -> {
            // 设置线程名称
            Thread.currentThread().setName("qwe" + taskQueue.hashCode());
            System.out.println(Thread.currentThread().getName());
        });
    }

}
