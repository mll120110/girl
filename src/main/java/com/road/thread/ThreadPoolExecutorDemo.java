package com.road.thread;

import java.util.concurrent.*;

/**
 * 线程池
 * 
 * @author Road
 */
public class ThreadPoolExecutorDemo {
    // 获取本地服务器CPU核心数
    private final static Integer MAX_PROCESSOR = Runtime.getRuntime().availableProcessors();

    public void startThread() {
        ExecutorService threadPool = new ThreadPoolExecutor(MAX_PROCESSOR, MAX_PROCESSOR * 10, 10L, TimeUnit.SECONDS,
            new ArrayBlockingQueue(128), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        // threadPool.submit();
    }

    public FutureTask threadTask() {
        //FutureTask<Integer> futureTask = new FutureTask<Integer>();
        return null;
    }
}

class FutureTaskDemo implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}