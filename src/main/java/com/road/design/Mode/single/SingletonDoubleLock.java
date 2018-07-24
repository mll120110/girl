package com.road.design.Mode.single;

/**
 * 单例模式双重锁/双重校验所
 */
public class SingletonDoubleLock {
	private volatile static SingletonDoubleLock singleton;

	private SingletonDoubleLock() {
	}

	public static SingletonDoubleLock getInstance() {
		if (singleton == null) {
			synchronized (SingletonDoubleLock.class) {
				if (singleton == null) {
					singleton = new SingletonDoubleLock();
				}
			}
		}
		return singleton;
	}
}
