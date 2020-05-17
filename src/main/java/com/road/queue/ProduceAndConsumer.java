package com.road.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 由ArraryBlockingQueue构建生产者消费者
 */
public class ProduceAndConsumer {

    // 构建固定线程池
    private final static ExecutorService executorService = Executors.newFixedThreadPool(4);
    // 构架有界阻塞队列
    private final static ArrayBlockingQueue<Data> queue = new ArrayBlockingQueue<>(1);

    /**
     * 数据类
     */
    static class Data {

    }

    /**
     * 生产者
     */
    static class Produce implements Runnable {

        private final ArrayBlockingQueue<Data> dataArrayBlockingQueue;

        Produce(ArrayBlockingQueue<Data> dataArrayBlockingQueue) {
            this.dataArrayBlockingQueue = dataArrayBlockingQueue;
        }

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                Data data = new Data();
                this.dataArrayBlockingQueue.put(data);
                System.out.println("生产数据@" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费者
     */
    static class Consumer implements Runnable {
        private final ArrayBlockingQueue<Data> dataArrayBlockingQueue;

        Consumer(ArrayBlockingQueue<Data> dataArrayBlockingQueue) {
            this.dataArrayBlockingQueue = dataArrayBlockingQueue;
        }

        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            try {
                Data data = this.dataArrayBlockingQueue.take();
                System.out.println("消费数据@" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        executorService.execute(new Produce(queue));
        executorService.execute(new Consumer(queue));
        executorService.execute(new Produce(queue));
        executorService.execute(new Consumer(queue));
        executorService.shutdown();
    }
}
