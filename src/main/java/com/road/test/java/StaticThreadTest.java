package com.road.test.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StaticThreadTest {
	public static void main(String[] args) {
		/**
		 * 设置线程池核心数量与最大数量一致
		 */
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (int j = 0; j < 100; j++) {
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
	}
}
