package com.vision.common;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂类
 *
 * @author Road
 */
public class NamedThreadFactory implements ThreadFactory {

    /**
     * 原子操作保证每个线程都有唯一的Number
     */
    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    private final String prefix;

    private final boolean daemonThread;

    private final ThreadGroup threadGroup;

    public NamedThreadFactory() {
        this("rpc-server-threadpool-" + threadNumber.getAndIncrement(), false);
    }

    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }

    public NamedThreadFactory(String prefix, boolean daemo) {
        this.prefix = StringUtils.isNotEmpty(prefix) ? prefix + "-thread-" : "";
        daemonThread = daemo;
        SecurityManager s = System.getSecurityManager();
        threadGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        String name = prefix + mThreadNum.getAndIncrement();
        Thread ret = new Thread(threadGroup, runnable, name, 0);
        ret.setDaemon(daemonThread);
        return ret;
    }
}