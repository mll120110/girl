package com.road.test.java;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JNC {

	public static void main(String[] args) throws InterruptedException {

		int corePoolSize = Runtime.getRuntime().availableProcessors();
		System.out.println(corePoolSize);

		final CountDownLatch countDownLatch = new CountDownLatch(4);
		Runnable run1 = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("统计C盘");
					countDownLatch.countDown();// 单任务，把计数器减1
				} catch (InterruptedException e) {
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

		String sql = "hashCode";
		System.out.println("120 row" + sql.hashCode());
		int h = 0, hash;
		char[] value = { 'h', 'a', 's', 'h', 'C', 'o', 'd', 'e' };
		if (h == 0 && value.length > 0) {
			char val[] = value;

			for (int i = 0; i < value.length; i++) {
				h = 31 * h + val[i];
				System.out.println("h" + h);
			}
			hash = h;
			System.out.println("hash值" + hash);
		}
		System.out.println(sql.hashCode() ^ (sql.hashCode() >>> 16));
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.hashCode();
		hashMap.put("key", "value");

	}
}
