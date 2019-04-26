package com.road.threadLocal;

import java.util.concurrent.CountDownLatch;

/**
 * @Describe ThreadLocal简单使用及分析
 * @Author Road
 * @Date 2019/4/26 14:33
 **/
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for (int i = 0; i <= threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }
        countDownLatch.await();
    }

    private static class InnerClass {
        public void add(String newStr) {
            StringBuilder str = new StringBuilder();
            if (Counter.counter.get() != null) {
                str = Counter.counter.get();
            }
            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("Thread nameL %s , ThreadLocal hashcode: %s, Instance hashcode: %s, Value: %s \n",
                Thread.currentThread().getName(), Counter.counter.hashCode(), Counter.counter.get().hashCode(),
                Counter.counter.get().toString());
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("Set, Thread name: %s , ThreadLocal hashcode: %s , Instance hashcode: %s, Value: %s \n",
                Thread.currentThread().getName(), Counter.counter.hashCode(), Counter.counter.get().hashCode(),
                Counter.counter.get().toString());
        }
    }

    private static class Counter {
        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>();

        protected StringBuilder initialValue() {
            return new StringBuilder();
        }
    }
}
