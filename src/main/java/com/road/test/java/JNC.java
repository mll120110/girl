package com.road.test.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JNC {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(4);
		Runnable run1 = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("统计C盘");
					countDownLatch.countDown();// 单任务，把计数器减1
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable run2 = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("统计D盘");
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable run3 = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("统计E盘");
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable run4 = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("统计F盘");
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		ExecutorService service = Executors.newFixedThreadPool(4);
		service.submit(run1);
		service.submit(run2);
		service.submit(run3);
		service.submit(run4);

		countDownLatch.await();// 主线程，即第5线程等待
		System.out.println("合计C,D,E,F");
		service.shutdown();

		/**
		 * 设置线程池核心数量与最大数量一致
		 */
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (int j = 0; j < 10; j++) {
			int index1 = j;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("newFixedThreadPool个" + index1 + "个线程");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
		 */
		ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
		for (int i = 0; i <= 5; i++) {
			int index = i;
			singleThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("第" + index + "个线程");
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		}
	}
}
